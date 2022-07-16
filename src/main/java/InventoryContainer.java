import java.util.HashMap;

public class InventoryContainer {

    /* stores Inventory and TransitInventory classes */

    private HashMap<Integer, Inventory> inventories;

    private TransitInvertory transitInvertory;

    public InventoryContainer(HashMap<Integer, Inventory> inventories, TransitInvertory transitInvertory) {
        this.inventories = inventories;
        this.transitInvertory = transitInvertory;
    }

    public HashMap<Integer, Inventory> getAllInventories() {
        return inventories;
    }

    public Inventory getInventory(int inventoryId) {
        return inventories.get(inventoryId);
    }

    public TransitInvertory getTransitInvertory() {
        return transitInvertory;
    }

    public boolean addInventory(Inventory newInventory) {
        Inventory result = inventories.putIfAbsent(newInventory.getId(), newInventory);
        if (result == null) {
            return true;
        }
        return false;
    }

}
