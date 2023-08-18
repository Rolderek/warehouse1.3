import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * rövidités kész
 */

class ItemProviderTest
{
    HashMap<Integer, ItemAmount> items;
    WarehouseInventory w1;
    HashMap<Integer, WarehouseInventory> inventories;
    InventoryContainer inventoryContainer;
    ItemProvider itemProvider;
    ItemMovement itemMovement;

    @BeforeEach
    public void setUp()
    {
        items = new HashMap<>();
        items.put(9000, new ItemAmount(5.0, 0.0));
        w1 = new WarehouseInventory(501, "a", new Address(1, "b", "c", "d", "e"), items);
        inventories = new HashMap<>();
        inventories.put(501, w1);
        inventoryContainer = new InventoryContainer(inventories);
        itemMovement = new ItemMovement(new ArrayList<>());
        inventoryContainer.setReservations(itemMovement);
        itemProvider = new ItemProvider(inventoryContainer);
    }

    @Test
    void warehouseInventoryNotBeNullAfterFill()
    {
        assertNotNull(itemProvider.getInventories().getInventory(501).getAllItems());
    }

    @Test
    void wareHouseInventoryHasFreeAmount()
    {
        assertEquals(5.0, itemProvider.getInventories().getInventory(501).getItemAmount(9000).getFreeAmount());
    }

    @Test
    void amountControlAmountReturnTrue()
    {
        assertTrue(itemProvider.getInventories().getInventory(501).getItemAmount(9000).getFreeAmount() >= 5.0);
    }

    @Test
    void amountControlAmountReturnFalse()
    {
        assertFalse(itemProvider.getInventories().getInventory(501).getItemAmount(9000).getFreeAmount() > 7.0);
    }

    @Test
    void itemListCheckTrue()
    {
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(9000, 4.0);
        assertEquals(true, itemProvider.itemListCheck(inventoryContainer, itemsToSend1, 501));
    }

    @Test
    void itemListCheckFalseBecauseThereIsNotEoughtFreeAmount()
    {
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(9000, 6.0);
        assertEquals(false, itemProvider.itemListCheck(inventoryContainer, itemsToSend1, 501));
    }

    @Test
    void reserveAllAmountAndMakeTransitBundle()
    {
        WarehouseInventory w2 = new WarehouseInventory(102, "másik", w1.getAddress(), items);
        inventoryContainer.addInventory(w2);
        itemProvider.getInventories().getInventory(501).getItemAmount(9000).addAmount(10.0);
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(9000, 3.0);
        assertEquals(itemsToSend1, itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 501, 102).getItems());
    }

    @Test
    void reserveAllAmountAndMakeTransitBundleIsNull()
    {
        WarehouseInventory w2 = new WarehouseInventory(102, "másik", w1.getAddress(), items);
        inventoryContainer.addInventory(w2);
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        Item itemTwo = new Item(8000, "izéke", "tulajdonság", "MZ/X", 500, 680);
        Item itemThree = new Item(50, "bigyóka", "tulajdonság", "AH64", 100, 127);
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(itemOne.getIdentifier(), 11.0);
        itemsToSend1.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend1.put(itemThree.getIdentifier(), 1.0);
        assertNull(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 102, 501));
    }

    @Test
    void reserveAllAmountHelper()
    {
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(itemOne.getIdentifier(), 10.0);
        itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 501, 102);
        assertEquals(5.0, inventories.get(501).getItemAmount(9000).getFreeAmount());
    }

    @Test
    void reserveAllAmountHelperWrong()
    {
        //?!
    }

    @Test
    void makeReservation()
    {
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        ItemAmount itemOneAmount = new ItemAmount(10.0, 0.0);
        HashMap<Integer, ItemAmount> items = new HashMap<>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        w1.setItems(items);
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(itemOne.getIdentifier(), 10.0);
        itemProvider.makeReservation(itemsToSend1, 501, 102);
        assertEquals(10.0, itemProvider.makeReservation(itemsToSend1, 501, 102).getItems().get(9000));
    }

    @Test
    void makeReservationReturnNull()
    {
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        itemsToSend1.put(itemOne.getIdentifier(), 10.0);
        assertNull(itemProvider.makeReservation(itemsToSend1, 501, 102));

    }

    @Test
    void makeReservationJustOneItemIsNull()
    {
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        ItemAmount itemOneAmount = new ItemAmount(10.0, 0.0);
        items.put(itemOne.getIdentifier(), itemOneAmount);
        WarehouseInventory w3 = new WarehouseInventory(100, "a", new Address(1, "b", "c", "d", "e"),items);
        inventoryContainer.addInventory(w3);
        HashMap<Integer, Double> itemsToSend1 = new HashMap<>();
        /**
         * többet kérek mint ami van ezért null-t kapok
         */
        itemsToSend1.put(itemOne.getIdentifier(), 15.0);
        assertNull(itemProvider.makeReservation(itemsToSend1, 100, 501));
    }
}