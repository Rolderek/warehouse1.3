import java.time.Instant;
import java.util.HashMap;

/**
  * Második lépcső a rendelésben
  */
public class PurchaseConfirmation
{

    private int purchaseOfferId;

    private int confirmationId;

    private HashMap<Integer, AmountAndPrice> confirmedItems;

    private Instant makingDate;

    private String note;

    private int warehouseId;

    private PurchaseConfirmationIdGenerator confirmationIdGenerator;

    public PurchaseConfirmation(int purchaseOfferId, HashMap<Integer, AmountAndPrice> confirmedItems, String note, int warehouseId)
    {
        this.confirmationIdGenerator = new PurchaseConfirmationIdGenerator();
        this.purchaseOfferId = purchaseOfferId;
        this.confirmationId = confirmationIdGenerator.PurchaseConfirmationIdGenerator();
        this.confirmedItems = confirmedItems;
        this.makingDate = Instant.now();
        this.note = note;
        this.warehouseId = warehouseId;
    }
    public PurchaseConfirmation(int purchaseOfferId, HashMap<Integer, AmountAndPrice> confirmedItems, int warehouseId)
    {
        this.confirmationIdGenerator = new PurchaseConfirmationIdGenerator();
        this.purchaseOfferId = purchaseOfferId;
        this.confirmationId = confirmationIdGenerator.PurchaseConfirmationIdGenerator();
        this.confirmedItems = confirmedItems;
        this.makingDate = Instant.now();
        this.warehouseId = warehouseId;
    }

    public int getWarehouseId()
    {
        return warehouseId;
    }

    public void setWarehouseId(int newId)
    {
        warehouseId = newId;
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

    public void setConfirmationId(int confirmationId)
    {
        this.confirmationId = confirmationId;
    }

    public HashMap<Integer, AmountAndPrice> getConfirmedItems()
    {
        return confirmedItems;
    }

    public void setConfirmedItems(HashMap<Integer, AmountAndPrice> confirmedItems)
    {
        this.confirmedItems = confirmedItems;
    }
}
