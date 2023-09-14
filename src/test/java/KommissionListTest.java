import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class KommissionListTest
{
    InventoryContainer inventoryContainer;

    @Test
    void setInventoryContainer()
    {
     KommissionList kommissionList = new KommissionList(new InventoryContainer(new HashMap<>()));
     kommissionList.setInventoryContainer(inventoryContainer);
     assertEquals(inventoryContainer, kommissionList.getInventoryContainer());
    }

    @Test
    void kommissionListOfOneWarehouse()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        transitInventory.addBoundle(transitBundle);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, TransitBundle> monza = new HashMap<>();
        monza.put(0, transitBundle);
        assertEquals(monza, kommissionList.makeKommissionListOfOneWarehouse(501));

    }

    @Test
    void allKommissionListOfAllWarehouse()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        HashMap<Integer, Double> items2 = new HashMap<>();
        items2.put(50, 1.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        TransitBundle transitBundle2 = new TransitBundle(items2, 102, 501);
        transitInventory.addBoundle(transitBundle);
        transitInventory.addBoundle(transitBundle2);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, TransitBundle> monza = new HashMap<>();
        /**
         * az első hashmap indexe 0, a másodiké 1, stb...
         */
        monza.put(0, transitBundle);
        monza.put(1, transitBundle2);
        assertEquals(monza, kommissionList.makeAllKommissionListOfAllWarehouse());
    }

    @Test
    void refreshAKommissionListOneWarehouse()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        HashMap<Integer, Double> items2 = new HashMap<>();
        items2.put(1, 9.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        TransitBundle transitBundle2 = new TransitBundle(items2, 501, 90);
        transitInventory.addBoundle(transitBundle);
        transitInventory.addBoundle(transitBundle2);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, TransitBundle> monza = new HashMap<>();
        monza.put(0, transitBundle);
        monza.put(1, transitBundle2);
        kommissionList.makeKommissionListOfOneWarehouse(501);
        kommissionList.refreshKommissionListOneWarehouse(501);
        assertEquals(monza, kommissionList.getOnlyOneWarehouseList());
    }

    @Test
    void refreshKommissionListOfAllWarehouse()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        HashMap<Integer, Double> items2 = new HashMap<>();
        items2.put(1, 9.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        transitInventory.addBoundle(transitBundle);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, TransitBundle> monza = new HashMap<>();
        monza.put(0, transitBundle);
        kommissionList.makeAllKommissionListOfAllWarehouse();
        assertEquals(monza, kommissionList.getAllWarehouseList());
        TransitBundle transitBundle2 = new TransitBundle(items2, 1, 90);
        transitInventory.addBoundle(transitBundle2);
        monza.put(1, transitBundle2);
        kommissionList.refreshKommissionListOfAllWarehouse();
        assertEquals(monza, kommissionList.getAllWarehouseList());
    }

    @Test
    void getAllwarehouseList()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        HashMap<Integer, Double> items2 = new HashMap<>();
        items2.put(50, 1.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        TransitBundle transitBundle2 = new TransitBundle(items2, 102, 501);
        transitInventory.addBoundle(transitBundle);
        transitInventory.addBoundle(transitBundle2);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, TransitBundle> monza = new HashMap<>();
        monza.put(0, transitBundle);
        monza.put(1, transitBundle2);
        kommissionList.makeAllKommissionListOfAllWarehouse();
        assertEquals(monza, kommissionList.getAllWarehouseList());

    }

    @Test
    void getDedicatedWarehouseList()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        transitInventory.addBoundle(transitBundle);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, TransitBundle> monza = new HashMap<>();
        monza.put(0, transitBundle);
        kommissionList.makeKommissionListOfOneWarehouse(501);
        assertEquals(monza, kommissionList.getOnlyOneWarehouseList());
    }

    @Test
    void getInventoryContainer()
    {
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        assertEquals(inventoryContainer, kommissionList.getInventoryContainer());
    }

    @Test
    void makeKommissionListOfOneWarehouseWithTransitBundleId()
    {
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 10.0);
        ArrayList<TransitBundle> wasMoving = new ArrayList<>();
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        ItemMovement reservations = new ItemMovement(wasMoving);
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        TransitBundle transitBundle = new TransitBundle(items, 501, 102);
        transitInventory.addBoundle(transitBundle);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, reservations);
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        HashMap<Integer, HashMap<Integer, Double>> valami = kommissionList.makeKommissionListOfOneWarehouseWithTransitBundleId(501);
        assertEquals(valami, kommissionList.makeKommissionListOfOneWarehouseWithTransitBundleId(501));
    }

}