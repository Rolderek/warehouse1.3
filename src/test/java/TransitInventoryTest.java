import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ez egyszerűsiteni kell!!!
 */

class TransitInventoryTest
{
    Item itemOne;
    ItemAmount itemOneAmount;
    ItemAmount itemOneAmountW2;
    HashMap<Integer, ItemAmount> items;
    HashMap<Integer, ItemAmount> itemsW2;
    WarehouseInventory w1;
    WarehouseInventory w2;
    HashMap<Integer, Double> itemsToSend1;
    HashMap<Integer, Double> itemsToSend2;
    HashMap<Integer, WarehouseInventory> inventories;
    HashMap<Integer, TransitBundle> bundles;
    TransitInventory transitInventory;
    TransitInventory andAnotherTransitInventory;
    InventoryContainer inventoryContainer;
    ItemProvider itemProvider;
    InventoryMover mover;
    TransitBundle transitBundle;
    TransitBundle anotherTransitBundle;
    HashMap<Integer, Double> checkList;


    @BeforeEach
    public void setUp()
    {
        itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        itemOneAmount = new ItemAmount(10.0, 0.0);
        items = new HashMap<Integer, ItemAmount>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        itemsW2 = new HashMap<Integer, ItemAmount>();
        itemsW2.put(itemOne.getIdentifier(), itemOneAmountW2);
        itemsToSend1 = new HashMap<Integer, Double>();
        itemsToSend1.put(itemOne.getIdentifier(), 3.0);
        itemsToSend2 = new HashMap<Integer, Double>();
        itemsToSend2.put(itemOne.getIdentifier(), 2.0);
        inventories = new HashMap<>();
        inventories.put(501, w1);
        inventories.put(102, w2);
        bundles = new HashMap<>();
        transitInventory = new TransitInventory(bundles);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, new ItemMovement(new ArrayList<TransitBundle>()));
        itemProvider = new ItemProvider(inventoryContainer);
        mover = new InventoryMover(itemProvider, transitInventory);
        transitBundle = new TransitBundle(itemsToSend1, 501, 102);
        transitBundle = new TransitBundle(itemsToSend2, 501, 102);
        checkList = new HashMap<>();
        checkList.put(9000, 2.0);
    }
    @Test
    void getBundles()
    {
        assertEquals(bundles, transitInventory.getBundles());
    }

    @Test
    void transitInventoryConstructos()
    {
        andAnotherTransitInventory = new TransitInventory(bundles);
        assertEquals(bundles, andAnotherTransitInventory.getBundles());

    }

    @Test
    void removeBundle()
    {
        transitInventory.addBoundle(transitBundle);
        transitInventory.addBoundle(anotherTransitBundle);
        transitInventory.removeBundle(transitBundle);
        assertEquals(1, transitInventory.getBundles().size());
    }

    @Test
    void getAllItemsOfWarehouse()
    {
        transitInventory.addBoundle(transitBundle);
        assertEquals(checkList, transitInventory.getAllItemsOfWarehouse(501));

    }
}