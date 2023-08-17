import java.time.Instant;
import java.util.HashMap;

/**
  *  Harmadik lápcső a rendelésben
  */
public class PurchaseFinal
{

    private PurchaseConfirmation purchaseConfirmation;

    private int purchaseConfirmationId;

    private int purchaseFinalId;

    private HashMap<Integer, PurchaseAmount> items;

    private Instant makingDate;

    private String note;

    private int warehouseId;

    private PurchaseFinalStatus status;

    private static GreviousGeneratorForTransitBundle finalIdGenerator = new GreviousGeneratorForTransitBundle(GreviousType.FINAL);

    public PurchaseFinal(PurchaseConfirmation purchaseConfirmation)
    {
        this.purchaseConfirmation = purchaseConfirmation;
        this.purchaseConfirmationId = purchaseConfirmation.getConfirmationId();
        this.purchaseFinalId = finalIdGenerator.generateBundleId();
        this.items = purchaseConfirmation.getConfirmedItems();
        this.note = purchaseConfirmation.getNote();
        this.makingDate = Instant.now();
        this.warehouseId = purchaseConfirmation.getReceivingWarehouseId();
        this.status = PurchaseFinalStatus.JUSTORDER;
    }

    public PurchaseFinal(int purchaseConfirmationId, HashMap<Integer, PurchaseAmount> items, String note, int warehouseId)
    {
        this.purchaseConfirmationId = purchaseConfirmationId;
        this.purchaseFinalId = finalIdGenerator.generateBundleId();
        this.items = items;
        this.note = note;
        this.makingDate = Instant.now();
        this.warehouseId = warehouseId;
        this.status = PurchaseFinalStatus.JUSTORDER;
    }

    public PurchaseFinal(int purchaseConfirmationId, HashMap<Integer, PurchaseAmount> items, int warehouseId)
    {
        this.purchaseConfirmationId = purchaseConfirmationId;
        this.purchaseFinalId = finalIdGenerator.generateBundleId();
        this.items = items;
        this.makingDate = Instant.now();
        this.warehouseId = warehouseId;
        this.status = PurchaseFinalStatus.JUSTORDER;
    }

    public PurchaseConfirmation getPurchaseConfirmation()
    {
        return purchaseConfirmation;
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

    public int getPurchaseConfirmationId()
    {
        return purchaseConfirmationId;
    }

    public int getPurchaseFinalId()
    {
        return purchaseFinalId;
    }

    public HashMap<Integer, PurchaseAmount> getItems()
    {
        return items;
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
