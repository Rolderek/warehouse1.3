import java.util.HashMap;
/** Az összes raktárat ez tárolja */
public class InventoryContainer {

    /** stores Inventory and TransitInventory classes */

    private HashMap<Integer, WarehouseInventory> inventories;

    private TransitInventory transitInventory;

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory) {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
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

    public boolean addInventory(WarehouseInventory newWarehouseInventory) {
        WarehouseInventory result = inventories.putIfAbsent(newWarehouseInventory.getWarehouseId(), newWarehouseInventory);
        if (result == null) {
            return true;
        }
        return false;
    }

}
