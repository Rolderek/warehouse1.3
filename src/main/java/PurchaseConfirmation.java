import java.time.Instant;
import java.util.HashMap;

/**
  * Második lépcső a rendelésben
  */
public class PurchaseConfirmation
{
    private PurchaseOffer purchaseOffer;

    private int purchaseOfferId;

    private int confirmationId;

    private HashMap<Integer, PurchaseAmount> confirmedItems;

    private Instant creationDate;

    private String note;

    private int receivingWarehouseId;

    private static PurchaseConfirmationIdGenerator confirmationIdGenerator = new PurchaseConfirmationIdGenerator();

    /**
     * új konstruktor, majd az egyik régit törölni kell
     */
    public PurchaseConfirmation(PurchaseOffer purchaseOffer)
    {
        this.purchaseOffer = purchaseOffer;
        this.confirmationId = confirmationIdGenerator.PurchaseConfirmationIdGenerator();
        this.purchaseOfferId = purchaseOffer.getId();
        this.confirmedItems = purchaseOffer.getItems();
        this.creationDate = Instant.now();
        this.receivingWarehouseId = purchaseOffer.getReceivingWarehouseId();
    }

    public PurchaseConfirmation(int purchaseOfferId, HashMap<Integer, PurchaseAmount> confirmedItems, String note, int receivingWarehouseId)
    {
        this.purchaseOfferId = purchaseOfferId;
        this.confirmationId = confirmationIdGenerator.PurchaseConfirmationIdGenerator();
        this.confirmedItems = confirmedItems;
        this.creationDate = Instant.now();
        this.note = note;
        this.receivingWarehouseId = receivingWarehouseId;
    }
    public PurchaseConfirmation(int purchaseOfferId, HashMap<Integer, PurchaseAmount> confirmedItems, int receivingWarehouseId)
    {
        this.confirmationIdGenerator = new PurchaseConfirmationIdGenerator();
        this.purchaseOfferId = purchaseOfferId;
        this.confirmationId = confirmationIdGenerator.PurchaseConfirmationIdGenerator();
        this.confirmedItems = confirmedItems;
        this.creationDate = Instant.now();
        this.receivingWarehouseId = receivingWarehouseId;
    }

    public PurchaseOffer getPurchaseOffer()
    {
        return purchaseOffer;
    }

    public int getReceivingWarehouseId()
    {
        return receivingWarehouseId;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public int getPurchaseOfferId()
    {
        return purchaseOfferId;
    }

    public int getConfirmationId()
    {
        return confirmationId;
    }

    public HashMap<Integer, PurchaseAmount> getConfirmedItems()
    {
        return confirmedItems;
    }
}
