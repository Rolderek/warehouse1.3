import java.time.Instant;
import java.util.HashMap;

/**
 * ellenőrzött rendeléseket tárol kétféle státusszal(RESERVED,SENT)
 */
public class TransitBundle
{

    /**
     * This stores Item Identifier, amount pairs.
     */
    private HashMap<Integer, Double> items;

    private int senderId;

    private int recipientId;

    private Instant sendTime;

    private String notes;

    private TransitBundleStatus status;

    public TransitBundle(HashMap<Integer, Double> items, int senderId, int recipientId)
    {
        this.items = items;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.sendTime = Instant.now();
        this.status = TransitBundleStatus.RESERVED;
    }

    public TransitBundle(HashMap<Integer, Double> items, int senderId, int recipientId, String notes)
    {
        this.items = items;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.sendTime = Instant.now();
        this.notes = notes;
        this.status = TransitBundleStatus.RESERVED;
    }

    public HashMap<Integer, Double> getItems()
    {
        return items;
    }

    public int getSenderId()
    {
        return senderId;
    }

    public int getRecipientId()
    {
        return recipientId;
    }

    public Instant getSendTime()
    {
        return sendTime;
    }

    public String getNotes()
    {
        return notes;
    }

    public TransitBundleStatus getStatus()
    {
        return status;
    }

    public void setStatusToSent()
    {
        status = TransitBundleStatus.SENT;
    }

    public void addNotes(String newNote)
    {
        if (notes == null)
        {
            notes = newNote;
        } else
            {
            notes = notes.concat("\n" + newNote);
            }
    }

}
