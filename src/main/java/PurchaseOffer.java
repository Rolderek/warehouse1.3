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


    public PurchaseOffer(int id, HashMap<Integer, AmountAndPrice> items, Address address, LocalDate recivingDate, String note)
    {
        this.id = id;
        this.items = items;
        this.makingDate = Instant.now();
        this.reciverAddres = address;
        this.recivingDate = recivingDate;
        this.note = note;
    }

    public PurchaseOffer(int id, HashMap<Integer, AmountAndPrice> items, Address address, LocalDate recivingDate)
    {
        this.id = id;
        this.items = items;
        this.makingDate = Instant.now();
        this.reciverAddres = address;
        this.recivingDate = recivingDate;
    }

    public int getId()
    {
        return id;
    }

    public HashMap<Integer, AmountAndPrice> getItems() {
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
}
