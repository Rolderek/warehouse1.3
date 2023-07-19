/** WarehouseInventory-kat tárol.
 * */
import java.sql.Time;
import java.time.Instant;
import java.util.HashMap;

public class InventoryContainer {

    /** stores Inventory and TransitInventory classes */

    private HashMap<Integer, WarehouseInventory> inventories;

    private TransitInventory transitInventory;

    /** ezt át kell dolgozni, TransitBundle-ből kellene kinyernie az adatokat! */
    private HashMap<Instant, ItemReservation> reservations = new HashMap<Instant, ItemReservation>();

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory, HashMap<Instant, ItemReservation> reservations) {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
        this.reservations = reservations;
    }

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory) {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
    }

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories) {
        this.inventories = inventories;
    }

    public HashMap<Integer, WarehouseInventory> getAllInventories() {
        return inventories;
    }

    public WarehouseInventory getInventory(int inventoryId) {
        return inventories.get(inventoryId);
    }

    public TransitInventory getTransitInvertory() {
        return transitInventory;
    }

    public HashMap<Instant, ItemReservation> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<Instant, ItemReservation> newReservation) {
        this.reservations = reservations;
    }

    public void addReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        reservations.put(Instant.now(), new ItemReservation(itemsToReservate, senderId, recipientId));
    }

    public boolean addInventory(WarehouseInventory newWarehouseInventory) {
        WarehouseInventory result = inventories.putIfAbsent(newWarehouseInventory.getWarehouseId(), newWarehouseInventory);
        if (result == null) {
            return true;
        }
        return false;
    }


}
