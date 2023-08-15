import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

/**
  * Első lépcső a három lépcsős rendelésből
  */
public class PurchaseOffer
{

    private static PurchaseOfferIdGenerator idGenerator = new PurchaseOfferIdGenerator();

    private int id;

    /**
      * itemId és amountPrice
      */
    private HashMap<Integer, PurchaseAmount> items;

    private Instant creationDate;

    private Address receiverAddress;

    private LocalDate receivingDate;

    private String note;

    private int receivingWarehouseId;


    public PurchaseOffer(HashMap<Integer, PurchaseAmount> items, Address address, LocalDate receivingDate, String note, int receivingWarehouseId)
    {
        this.id = idGenerator.PurchaseOfferIdGenerator();
        this.items = items;
        this.creationDate = Instant.now();
        this.receiverAddress = address;
        this.receivingDate = receivingDate;
        this.note = note;
        this.receivingWarehouseId = receivingWarehouseId;
    }

    public PurchaseOffer(HashMap<Integer, PurchaseAmount> items, Address address, LocalDate receivingDate, int receivingWarehouseId)
    {
        this.id = idGenerator.PurchaseOfferIdGenerator();
        this.items = items;
        this.creationDate = Instant.now();
        this.receiverAddress = address;
        this.receivingDate = receivingDate;
        this.receivingWarehouseId = receivingWarehouseId;
    }

    public void setReceivingDate(LocalDate newDate)
    {
        receivingDate = newDate;
    }

    public int getReceivingWarehouseId()
    {
        return receivingWarehouseId;
    }

    public int getId()
    {
        return id;
    }

    public HashMap<Integer, PurchaseAmount> getItems()
    {
        return items;
    }

    public Address getReceiverAddres()
    {
        return receiverAddress;
    }

    public LocalDate getReceivingDate()
    {
        return receivingDate;
    }

    public Instant getCreationDate()
    {
        return creationDate;
    }

    public String getNote()
    {
        return note;
    }
}
