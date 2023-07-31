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

    public PurchaseConfirmation(int purchaseOfferId, int confirmationId, HashMap<Integer, AmountAndPrice> confirmedItems, String note)
    {
        this.purchaseOfferId = purchaseOfferId;
        this.confirmationId = confirmationId;
        this.confirmedItems = confirmedItems;
        this.makingDate = Instant.now();
        this.note = note;
    }
    public PurchaseConfirmation(int purchaseOfferId, int confirmationId, HashMap<Integer, AmountAndPrice> confirmedItems)
    {
        this.purchaseOfferId = purchaseOfferId;
        this.confirmationId = confirmationId;
        this.confirmedItems = confirmedItems;
        this.makingDate = Instant.now();
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
