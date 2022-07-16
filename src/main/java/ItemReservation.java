import java.time.Instant;
import java.util.HashMap;

public class ItemReservation {
    // foglalási akapot csinál az inventoryból/nak/nek

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

}
