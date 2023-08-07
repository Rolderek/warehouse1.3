import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InventoryMoverTest
{
    Address address1;
    Address address2;
    Item itemOne;
    Item itemTwo;
    Item itemThree;
    ItemAmount itemOneAmount;
    ItemAmount itemTwoAmount;
    ItemAmount itemThreeAmount;
    ItemAmount itemOneAmountW2;
    ItemAmount itemTwoAmountW2;
    ItemAmount itemThreeAmountW2;
    HashMap<Integer, ItemAmount> items;
    HashMap<Integer, ItemAmount> itemsW2;
    WarehouseInventory w1;
    WarehouseInventory w2;
    HashMap<Integer, Double> itemsToSend1;
    HashMap<Integer, Double> itemsToSend2;
    HashMap<Integer, WarehouseInventory> inventories;
    HashMap<Integer, TransitBundle> bundles;
    TransitInventory transitInventory;
    TransitInventory anotherTransitInventory;
    InventoryContainer inventoryContainer;
    ItemProvider itemProvider;
    ItemProvider anotherItemProvider;
    InventoryMover mover;


    @BeforeEach
    public void setUp()
    {
        address1 = new Address(3903, "Bekecs", "Tűzoltó út", "28", "06901123456");
        address2 = new Address(4000, "Debrecen", "Fing utca", "3", "11111111111");
        itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        itemTwo = new Item(8000, "izéke", "tulajdonság", "MZ/X", 500, 680);
        itemThree = new Item(50, "bigyóka", "tulajdonság", "AH64", 100, 127);
        itemOneAmount = new ItemAmount(10.0, 0.0);
        itemTwoAmount = new ItemAmount(9.0, 0.0);
        itemThreeAmount = new ItemAmount(8.0, 0.0);
        itemOneAmountW2 = new ItemAmount(5.0, 0.0);
        itemTwoAmountW2 = new ItemAmount(5.0, 0.0);
        itemThreeAmountW2 = new ItemAmount(5.0, 0.0);
        items = new HashMap<Integer, ItemAmount>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        items.put(itemTwo.getIdentifier(), itemTwoAmount);
        items.put(itemThree.getIdentifier(), itemThreeAmount);
        itemsW2 = new HashMap<Integer, ItemAmount>();
        itemsW2.put(itemOne.getIdentifier(), itemOneAmountW2);
        itemsW2.put(itemTwo.getIdentifier(), itemTwoAmountW2);
        itemsW2.put(itemThree.getIdentifier(), itemThreeAmountW2);
        w1 = new WarehouseInventory(501, "Központ", address1, items);
        w2 = new WarehouseInventory(102, "Dábrechen", address2, itemsW2);
        itemsToSend1 = new HashMap<Integer, Double>();
        itemsToSend1.put(itemOne.getIdentifier(), 3.0);
        itemsToSend1.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend1.put(itemThree.getIdentifier(), 1.0);
        itemsToSend2 = new HashMap<Integer, Double>();
        itemsToSend2.put(itemOne.getIdentifier(), 2.0);
        itemsToSend2.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend2.put(itemThree.getIdentifier(), 2.0);
        inventories = new HashMap<>();
        inventories.put(501, w1);
        inventories.put(102, w2);
        bundles = new HashMap<>();
        transitInventory = new TransitInventory(bundles);
        inventoryContainer = new InventoryContainer(inventories, transitInventory, new ItemMovement(new ArrayList<TransitBundle>()));
        itemProvider = new ItemProvider(inventoryContainer);
        mover = new InventoryMover(itemProvider, transitInventory);
    }
    @Test
    void sendItems()
    {
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        assertEquals(7.0, w1.getItemAmount(9000).getTotalAmount());
        assertEquals(7.0, w1.getItemAmount(8000).getTotalAmount());
        assertEquals(7.0, w1.getItemAmount(50).getTotalAmount());
    }

    @Test
    void sendItemsBundleStatus()
    {
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        assertEquals(TranstiBundleStatus.SENT, transitInventory.getBundles().get(0).getStatus());
    }

    @Test
    void reciveItems()
    {
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        mover.reciveItems(transitInventory.getBundles().get(0));
        assertEquals(8.0, w2.getItemAmount(9000).getTotalAmount());
        assertEquals(7.0, w2.getItemAmount(8000).getTotalAmount());
        assertEquals(6.0, w2.getItemAmount(50).getTotalAmount());
    }

    @Test
    void reciveItemsBundleRemoveFromTransitInventory()
    {
        assertEquals(0, transitInventory.getBundles().size());
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        assertEquals(1, transitInventory.getBundles().size());
    }

    @Test
    void searchBundleInTransitInventory()
    {
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        assertEquals(1, mover.searchBundleInTransitInventory(501, 102).size());
    }

    @Test
    void searchBundleInTransitInventoryIfNotContain()
    {
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        assertEquals(0, mover.searchBundleInTransitInventory(500, 102).size());
    }

    @Test
    void getProvider()
    {
        assertEquals(itemProvider, mover.getProvider());
    }

    @Test
    void setProvider()
    {
        mover.setProvider(anotherItemProvider);
        assertEquals(anotherItemProvider, mover.getProvider());
    }

    @Test
    void getTransit()
    {
        assertEquals(transitInventory, mover.getTransit());
    }

    @Test
    void setTransit()
    {
        mover.setTransit(anotherTransitInventory);
        assertEquals(anotherTransitInventory, mover.getTransit());
    }
}