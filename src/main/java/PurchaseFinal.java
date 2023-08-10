import java.time.Instant;
import java.util.HashMap;

/**
  *  Harmadik lápcső a rendelésben
  */
public class PurchaseFinal
{
    private int purchaseConfirmationId;

    private int purchaseFinalId;

    private HashMap<Integer, AmountAndPrice> items;

    private Instant makingDate;

    private String note;

    private int warehouseId;

    private PurchaseFinalStatus status;

    public PurchaseFinal(int purchaseConfirmationId, int purchaseFinalId, HashMap<Integer, AmountAndPrice> items, String note, int warehouseId)
    {
        this.purchaseConfirmationId = purchaseConfirmationId;
        this.purchaseFinalId = purchaseFinalId;
        this.items = items;
        this.note = note;
        this.makingDate = Instant.now();
        this.warehouseId = warehouseId;
        this.status = PurchaseFinalStatus.JUSTORDER;
    }

    public PurchaseFinal(int purchaseConfirmationId, int purchaseFinalId, HashMap<Integer, AmountAndPrice> items, int warehouseId)
    {
        this.purchaseConfirmationId = purchaseConfirmationId;
        this.purchaseFinalId = purchaseFinalId;
        this.items = items;
        this.makingDate = Instant.now();
        this.warehouseId = warehouseId;
        this.status = PurchaseFinalStatus.JUSTORDER;
    }

    public PurchaseFinalStatus getStatus()
    {
        return status;
    }

    public void setStatusToRecived()
    {
        status = PurchaseFinalStatus.RECIVED;
    }

    public int getWarehouseId()
    {
        return warehouseId;
    }

    public void setWarehouseId(int newId)
    {
        warehouseId = newId;
    }

    public int getPurchaseConfirmationId()
    {
        return purchaseConfirmationId;
    }

    public int getPurchaseFinalId()
    {
        return purchaseFinalId;
    }

    public void setPurchaseFinalId(int purchaseFinalId)
    {
        this.purchaseFinalId = purchaseFinalId;
    }

    public HashMap<Integer, AmountAndPrice> getItems()
    {
        return items;
    }

    public void setItems(HashMap<Integer, AmountAndPrice> items)
    {
        this.items = items;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
}
