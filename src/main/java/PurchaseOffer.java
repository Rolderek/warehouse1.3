import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

/**
  * Első lépcső a három lépcsős rendelésből
  */
public class PurchaseOffer
{

    private int id;

    private HashMap<Integer, AmountAndPrice> items;

    private Instant makingDate;

    private Address reciverAddres;

    private LocalDate recivingDate;

    private String note;

    private int warehouseId;


    public PurchaseOffer(HashMap<Integer, AmountAndPrice> items, Address address, LocalDate recivingDate, String note, int warehouseId)
    {
        this.id = new PurchaseOfferIdGenerator().PurchaseOfferIdGenerator();
        this.items = items;
        this.makingDate = Instant.now();
        this.reciverAddres = address;
        this.recivingDate = recivingDate;
        this.note = note;
        this.warehouseId = warehouseId;
    }

    public PurchaseOffer(HashMap<Integer, AmountAndPrice> items, Address address, LocalDate recivingDate, int warehouseId)
    {
        this.id = new PurchaseOfferIdGenerator().PurchaseOfferIdGenerator();
        this.items = items;
        this.makingDate = Instant.now();
        this.reciverAddres = address;
        this.recivingDate = recivingDate;
        this.warehouseId = warehouseId;
    }

    public void setRecivingDate(LocalDate newDate)
    {
        recivingDate = newDate;
    }

    public int getWarehouseId()
    {
        return warehouseId;
    }

    public void setWarehouseId(int newId)
    {
        warehouseId = newId;
    }

    public int getId()
    {
        return id;
    }

    public HashMap<Integer, AmountAndPrice> getItems()
    {
        return items;
    }

    public Address getReciverAddres()
    {
        return reciverAddres;
    }

    public LocalDate getRecivingDate()
    {
        return recivingDate;
    }

    public Instant getMakingDate()
    {
        return makingDate;
    }

    public String getNote()
    {
        return note;
    }
}
