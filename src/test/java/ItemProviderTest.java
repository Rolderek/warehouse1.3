import org.junit.jupiter.api.BeforeAll;
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
    ItemAmount itemTwoAmount;
    ItemAmount itemThreeAmount;
    ItemAmount itemThreeAmountW2;
    ItemAmount itemTwoAmountW2;
    ItemAmount itemOneAmountW2;
    HashMap<Integer, ItemAmount> items;
    HashMap<Integer, ItemAmount> itemsW2;
    WarehouseInventory w1;
    WarehouseInventory w2;
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
        itemTwoAmount = new ItemAmount(9.0, 0.0);
        itemThreeAmount = new ItemAmount(8.0, 0.0);
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
        /**
          * raktárak létrehozása
          */
        w1 = new WarehouseInventory(501, "Központ", address1, items);
        w2 = new WarehouseInventory(102, "Dábrechen", address2, itemsW2);
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

    /**
      * itemListCheck -> lista készítész, belemegy e a listába, hiba dobása
      * reserveAllAmountHelper -> elég egyszerű, majd meglátjuk
      * reserveAllAmountAndMakeTransitBundle -> minden elem benne van e az új TB-ben, hibaüzenet
      * makeReservation -> jó e az új TB, hibaüzenet
      *
      */

}