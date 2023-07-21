/** WarehouseInventory-kat tárol.
 * */
import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryContainer {

    /** stores Inventory and TransitInventory classes */

    private HashMap<Integer, WarehouseInventory> inventories;

    private TransitInventory transitInventory;

/** Itemreservation lista mai tárolja a feladó, cimzett és tétellistát egy osztály formájában */
    private ArrayList<ItemReservation> reservations = new ArrayList<>();

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory, ArrayList<ItemReservation> reservations) {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
        this.reservations = reservations;
    }

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory) {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
    }

    public ArrayList<ItemReservation> getPackage() {
        return reservations;
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

    public void setReservations(ArrayList<ItemReservation> reservations) {
        this.reservations = reservations;
    }

    public ArrayList<ItemReservation> getReservations() {
        return reservations;
    }

    public ItemReservation addReservation(ItemReservation newReservation) {
        reservations.add(newReservation);
        return newReservation;
    }

    /**
     * public void addReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
     *         reservations.put(Instant.now(), new ItemReservation(itemsToReservate, senderId, recipientId));
     *     }
     *     */

    public boolean addInventory(WarehouseInventory newWarehouseInventory) {
        WarehouseInventory result = inventories.putIfAbsent(newWarehouseInventory.getWarehouseId(), newWarehouseInventory);
        if (result == null) {
            return true;
        }
        return false;
    }


}
