import java.time.Instant;
import java.util.HashMap;

/**
  *  Harmadik lápcső a rendelésben
  */
public class PurchaseFinal
{
    private PurchaseConfirmation confirmation;

    private int purchaseFinalId;

    private HashMap<Integer, AmountAndPrice> items;

    private Instant makingDate;

    private String note;

    public PurchaseFinal(PurchaseConfirmation confirmation, int purchaseFinalId, HashMap<Integer, AmountAndPrice> items, String note)
    {
        this.confirmation = confirmation;
        this.purchaseFinalId = purchaseFinalId;
        this.items = items;
        this.note = note;
        this.makingDate = Instant.now();
    }

    public PurchaseFinal(PurchaseConfirmation confirmation, int purchaseFinalId, HashMap<Integer, AmountAndPrice> items)
    {
        this.confirmation = confirmation;
        this.purchaseFinalId = purchaseFinalId;
        this.items = items;
        this.makingDate = Instant.now();
    }

    public PurchaseConfirmation getConfirmation()
    {
        return confirmation;
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
