import java.time.Instant;
import java.util.HashMap;

public class ItemReservation {

    private ItemPackage itemPackage;

    private int senderId;

    private int reciverId;

    private ItemReservationStatus status;

    public ItemReservation(ItemPackage itemPackage, int senderId, int reciverId) {
        this.itemPackage = itemPackage;
        this.senderId = senderId;
        this.reciverId = reciverId;
        this.status = ItemReservationStatus.NOTHING;
    }

    public ItemPackage getItemPackage() {
        return itemPackage;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReciverId() {
        return reciverId;
    }

    public ItemReservationStatus getStatus() {
        return status;
    }

    public void setStatusToDone() {
        this.status = ItemReservationStatus.DONE;
    }

    /**
    private HashMap<Integer, Double> items;

    private int senderId;

    private int reciverId;

    private Instant recivTime;

    public ItemReservation(HashMap<Integer, Double> items, int senderId, int reciverId) {
        this.items = items;
        this.senderId = senderId;
        this.reciverId = reciverId;
        this.recivTime = Instant.now();
    }

    public HashMap<Integer, Double> getItems() {
        return items;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReciverId() {
        return reciverId;
    }

    public Instant getRecivTime() {
        return recivTime;
    }
 */

}
