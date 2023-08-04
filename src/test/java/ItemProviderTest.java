import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ItemProviderTest
{

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
    HashMap<Integer, Double> itemsToSend2;
    HashMap<Integer, WarehouseInventory> inventories;
    HashMap<Integer, TransitBundle> bundles;
    TransitInventory transitInventory;
    ItemProvider itemProvider;
    InventoryMover mover;

    @BeforeEach
    public void setUp()
    {
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

        itemsToSend2 = new HashMap<Integer, Double>();
        itemsToSend2.put(itemOne.getIdentifier(), 2.0);
        itemsToSend2.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend2.put(itemThree.getIdentifier(), 2.0);
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
         inventoryContainer = new InventoryContainer(inventories, transitInventory, new ItemMovement(new ArrayList<TransitBundle>()));
        /**
          * ItemProvider létrehozása
          */
        itemProvider = new ItemProvider(inventoryContainer);
        /**
          * InventoryMover létrehozása
          */
        mover = new InventoryMover(itemProvider, transitInventory);
    }

    @Test
    void warehouseInventoryNotBeNullAfterFill()
    {
        assertNotNull(w1.getAllItems());
    }

    @Test
    void wareHouseInventoryHasFreeAmount()
    {
        assertEquals(10.0, w1.getItemAmount(9000).getFreeAmount());
    }

    @Test
    void amountControlAmountReturnTrue()
    {
        assertTrue(w1.getItemAmount(9000).getFreeAmount() >= 10.0);
    }

    @Test
    void amountControlAmountReturnFalse()
    {
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        assertFalse(w1.getItemAmount(9000).getFreeAmount() > 7.0);
    }

    @Test
    void itemListCheckTrue()
    {
        assertEquals(true, itemProvider.itemListCheck(inventoryContainer, itemsToSend1, 501));
    }

    @Test
    void itemListCheckFalseBecauseThereIsNotEoughtFreeAmount()
    {
        assertEquals(false, itemProvider.itemListCheck(inventoryContainer, itemsToSend2, 100));
    }

    @Test
    void reserveAllAmountAndMakeTransitBundle()
    {
        TransitBundle tb = new TransitBundle(itemsToSend1, 501, 102);
        assertEquals(tb.getItems(), itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 501, 102).getItems());
    }

    @Test
    void reserveAllAmountAndMakeTransitBundleIsNull()
    {
        assertNull(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 100, 501));
    }

    @Test
    void reserveAllAmountHelper()
    {
        itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, 501, 102);
        assertEquals(7.0, inventories.get(501).getItemAmount(9000).getFreeAmount());
    }

    @Test
    void reserveAllAmountHelperWrong()
    {
        //?!
    }

    @Test
    void makeReservation()
    {
        assertEquals(3.0, itemProvider.makeReservation(itemsToSend1, 501, 102).getItems().get(9000));
        assertEquals(2.0, itemProvider.makeReservation(itemsToSend1, 501, 102).getItems().get(8000));
        assertEquals(1.0, itemProvider.makeReservation(itemsToSend1, 501, 102).getItems().get(50));
    }

    @Test
    void makeReservationReturnNull()
    {
        assertNull(itemProvider.makeReservation(itemsToSend1, 100, 501));
    }

    @Test
    void makeReservationJustOneItemIsNull()
    {
        Address address1 = new Address(3903, "Bekecs", "Tűzoltó út", "28", "06901123456");
        itemOneAmountW3 = new ItemAmount(3.0, 0.0);
        itemTwoAmountW3 = new ItemAmount(2.0, 0.0);
        itemThreeAmountW3 = new ItemAmount(0.0, 0.0);
        itemsW3.put(itemOne.getIdentifier(), itemOneAmountW3);
        itemsW3.put(itemTwo.getIdentifier(), itemTwoAmountW3);
        itemsW3.put(itemThree.getIdentifier(), itemThreeAmountW3);
        w3 = new WarehouseInventory(100, "Lepsény", address1, itemsW3);

        assertNull(itemProvider.makeReservation(itemsToSend1, 100, 501));
    }

    /**
      * reserveAllAmountHelper -> még hátra van
      */

}