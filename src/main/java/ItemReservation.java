/** foglalási alapot csinál az inventoryból/nak/nek
 * át kell irni egy egyszerű tároló osztállyá, mert a TransiBundle és az ItemPackage-el kell dolgoznia! */
import java.time.Instant;
import java.util.HashMap;

public class ItemReservation {

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
