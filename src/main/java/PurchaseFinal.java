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

    public PurchaseFinal(int purchaseConfirmationId, int purchaseFinalId, HashMap<Integer, AmountAndPrice> items, String note)
    {
        this.purchaseConfirmationId = purchaseConfirmationId;
        this.purchaseFinalId = purchaseFinalId;
        this.items = items;
        this.note = note;
        this.makingDate = Instant.now();
    }

    public PurchaseFinal(int purchaseConfirmationId, int purchaseFinalId, HashMap<Integer, AmountAndPrice> items)
    {
        this.purchaseConfirmationId = purchaseConfirmationId;
        this.purchaseFinalId = purchaseFinalId;
        this.items = items;
        this.makingDate = Instant.now();
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
