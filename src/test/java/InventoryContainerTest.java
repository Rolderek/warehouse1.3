import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * átnézve és kicsit leröviditve a BeforeEach
 */
class InventoryContainerTest {
    Item itemOne;
    Item itemTwo;
    Item itemThree;
    ItemAmount itemOneAmount;
    ItemAmount itemOneAmountW3;
    ItemAmount itemTwoAmount;
    ItemAmount itemTwoAmountW3;
    ItemAmount itemThreeAmount;
    ItemAmount itemThreeAmountW3;
    ItemAmount itemThreeAmountW2;
    ItemAmount itemTwoAmountW2;
    ItemAmount itemOneAmountW2;
    HashMap<Integer, ItemAmount> items;
    HashMap<Integer, ItemAmount> itemsW2;
    HashMap<Integer, ItemAmount> itemsW3;
    WarehouseInventory w1;
    WarehouseInventory w2;
    WarehouseInventory w3;
    InventoryContainer inventoryContainer;
    HashMap<Integer, Double> itemsToSend1;
    HashMap<Integer, WarehouseInventory> inventories;
    HashMap<Integer, TransitBundle> bundles;
    TransitInventory transitInventory;
    ItemMovement itemMovement;

    @BeforeEach
    public void setUp() {
        /**
         * address készités
         */
        Address address1 = new Address(3903, "Bekecs", "Tűzoltó út", "28", "06901123456");
        Address address2 = new Address(4000, "Debrecen", "Fing utca", "3", "11111111111");
        /**
         * itemek készités
         */
        itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        itemTwo = new Item(8000, "izéke", "tulajdonság", "MZ/X", 500, 680);
        itemThree = new Item(50, "bigyóka", "tulajdonság", "AH64", 100, 127);
        /**
         * itemAmount készités
         */
        itemOneAmount = new ItemAmount(10.0, 0.0);
        itemOneAmountW3 = new ItemAmount(1.0, 0.0);
        itemTwoAmount = new ItemAmount(9.0, 0.0);
        itemTwoAmountW3 = new ItemAmount(1.0, 0.0);
        itemThreeAmount = new ItemAmount(8.0, 0.0);
        itemThreeAmountW3 = new ItemAmount(1.0, 0.0);
        itemOneAmountW2 = new ItemAmount(5.0, 0.0);
        itemTwoAmountW2 = new ItemAmount(5.0, 0.0);
        itemThreeAmountW2 = new ItemAmount(5.0, 0.0);
        /**
         * item itemAmount párok bepakolása a raktárakba
         */
        items = new HashMap<Integer, ItemAmount>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        items.put(itemTwo.getIdentifier(), itemTwoAmount);
        items.put(itemThree.getIdentifier(), itemThreeAmount);

        itemsW2 = new HashMap<Integer, ItemAmount>();
        itemsW2.put(itemOne.getIdentifier(), itemOneAmountW2);
        itemsW2.put(itemTwo.getIdentifier(), itemTwoAmountW2);
        itemsW2.put(itemThree.getIdentifier(), itemThreeAmountW2);

        itemsW3 = new HashMap<Integer, ItemAmount>();
        itemsW3.put(itemOne.getIdentifier(), itemOneAmountW3);
        itemsW3.put(itemTwo.getIdentifier(), itemTwoAmountW3);
        itemsW3.put(itemThree.getIdentifier(), itemThreeAmountW3);
        /**
         * raktárak létrehozása
         */
        w1 = new WarehouseInventory(501, "Központ", address1, items);
        w2 = new WarehouseInventory(102, "Dábrechen", address2, itemsW2);
        w3 = new WarehouseInventory(100, "Lepsény", address2, itemsW3);
        /**
         * küldendő listák létrehozása
         */
        itemsToSend1 = new HashMap<Integer, Double>();
        itemsToSend1.put(itemOne.getIdentifier(), 3.0);
        itemsToSend1.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend1.put(itemThree.getIdentifier(), 1.0);
        /**
         * WarehouseInventory létrehozása
         */
        inventories = new HashMap<>();
        inventories.put(501, w1);
        inventories.put(102, w2);
        inventories.put(100, w3);
        /**
         * TransitInventory létrehozása
         */
        bundles = new HashMap<>();
        transitInventory = new TransitInventory(bundles);
        /**
         * InventoryContainer létrehozása
         */
        itemMovement = new ItemMovement(new ArrayList<TransitBundle>());
        inventoryContainer = new InventoryContainer(inventories, transitInventory, itemMovement);
        /**
         * InventoryMover létrehozása
         */

    }

    @Test
    void getAllInventories()
    {
        assertEquals(inventories, inventoryContainer.getAllInventories());
    }

    @Test
    void getReservation()
    {
        ItemProvider itemProvider = new ItemProvider(inventoryContainer);
        itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 501, 102);
        assertEquals(1, inventoryContainer.getMyReservation(501).size());
    }

    @Test
    void addInventoryAlreadyInTheList()
    {
        assertFalse(inventoryContainer.addInventory(w1));
    }

    @Test
    void addInventoryNotInTheList()
    {
        WarehouseInventory w4 = new WarehouseInventory(666, "legújabb",
                new Address(2222, "Büdös", "Macska", "12", "+36301114444"));
        assertTrue(inventoryContainer.addInventory(w4));
    }

    @Test
    void inventoryContainerConstructorWithTwo()
    {
        InventoryContainer inventoryContainer1 = new InventoryContainer(inventories, transitInventory);
        assertEquals(inventories, inventoryContainer1.getAllInventories());
        assertEquals(transitInventory, inventoryContainer1.getTransitInvertory());
    }

    @Test
    void inventoryContainerConstructorWithOne()
    {
        InventoryContainer inventoryContainer1 = new InventoryContainer(inventories);
        assertEquals(inventories, inventoryContainer1.getAllInventories());
    }

    @Test
    void getReservationsAllInOne()
    {
        assertEquals(itemMovement, inventoryContainer.getReservationsAllInOne());
    }

    @Test
    void setReservations()
    {
        ItemMovement itemMovement1 = new ItemMovement(new ArrayList<TransitBundle>());
        itemMovement1.addBundleToWasMovingList(new TransitBundle(itemsToSend1, 501, 102));
        assertNotEquals(itemMovement.getWasMoving(), itemMovement1.getWasMoving());
    }

}