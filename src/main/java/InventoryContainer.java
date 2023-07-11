import java.sql.Time;
import java.time.Instant;
import java.util.HashMap;
/** Az összes raktárat ez tárolja */
public class InventoryContainer {

    /** stores Inventory and TransitInventory classes */

    private HashMap<Integer, WarehouseInventory> inventories;

    private TransitInventory transitInventory;

    private HashMap<Instant, ItemReservation> reservations;

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
    /**
    public void addReservation(ItemReservation newReservation) {
        reservations.put(Instant.now(), newReservation);
    }
     */

    public boolean addInventory(WarehouseInventory newWarehouseInventory) {
        WarehouseInventory result = inventories.putIfAbsent(newWarehouseInventory.getWarehouseId(), newWarehouseInventory);
        if (result == null) {
            return true;
        }
        return false;
    }


}
