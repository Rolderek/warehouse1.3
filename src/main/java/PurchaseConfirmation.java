import java.time.Instant;
import java.util.HashMap;

/**
  * Második lépcső a rendelésben
  */
public class PurchaseConfirmation
{

    private PurchaseOffer offer;

    private int confirmationId;

    private HashMap<Integer, AmountAndPrice> confirmedItems;

    private Instant makingDate;

    private String note;

    public PurchaseConfirmation(PurchaseOffer offer, int confirmationId, HashMap<Integer, AmountAndPrice> confirmedItems, String note)
    {
        this.offer = offer;
        this.confirmationId = confirmationId;
        this.confirmedItems = confirmedItems;
        this.makingDate = Instant.now();
        this.note = note;
    }
    public PurchaseConfirmation(PurchaseOffer offer, int confirmationId, HashMap<Integer, AmountAndPrice> confirmedItems)
    {
        this.offer = offer;
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

    public PurchaseOffer getOffer()
    {
        return offer;
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
