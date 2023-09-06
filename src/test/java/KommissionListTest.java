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
        HashMap<Integer, HashMap<Integer, Double>> monza = new HashMap<>();
        monza.put(102, items);
        assertEquals(monza, kommissionList.kommissionListOfOneWarehouse(501));

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
        HashMap<Integer, HashMap<Integer, Double>> monza = new HashMap<>();
        /**
         * az első hashmap indexe 0, a másodiké 1, stb...
         */
        monza.put(0, items);
        monza.put(1, items2);
        assertEquals(monza, kommissionList.allKommissionListOfAllWarehouse());
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
        HashMap<Integer, HashMap<Integer, Double>> monza = new HashMap<>();
        monza.put(102, items);
        monza.put(90, items2);
        kommissionList.kommissionListOfOneWarehouse(501);
        kommissionList.refreshAKommissionListOneWarehouse(501);
        assertEquals(monza, kommissionList.getDedicatedWarehouseList());
        /**
         * System.out.print(kommissionList.getDedicatedWarehouseList());
         */

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
        HashMap<Integer, HashMap<Integer, Double>> monza = new HashMap<>();
        monza.put(0, items);
        kommissionList.allKommissionListOfAllWarehouse();
        assertEquals(monza, kommissionList.getAllwarehouseList());
        TransitBundle transitBundle2 = new TransitBundle(items2, 1, 90);
        transitInventory.addBoundle(transitBundle2);
        monza.put(1, items2);
        kommissionList.refreshAKommissionListOfAllWarehouse();
        assertEquals(monza, kommissionList.getAllwarehouseList());
    }

    @Test
    void sendKommissionList()
    {
        /**
         * még nincs készen az osztályban
         */
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
        HashMap<Integer, HashMap<Integer, Double>> monza = new HashMap<>();
        monza.put(0, items);
        monza.put(1, items2);
        kommissionList.allKommissionListOfAllWarehouse();
        assertEquals(monza, kommissionList.getAllwarehouseList());

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
        HashMap<Integer, HashMap<Integer, Double>> monza = new HashMap<>();
        monza.put(102, items);
        kommissionList.kommissionListOfOneWarehouse(501);
        assertEquals(monza, kommissionList.getDedicatedWarehouseList());
    }

    @Test
    void getInventoryContainer()
    {
        KommissionList kommissionList = new KommissionList(inventoryContainer);
        assertEquals(inventoryContainer, kommissionList.getInventoryContainer());
    }
}