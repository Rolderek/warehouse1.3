import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BeforeEach-et még röviditeni kell!
 * az új sendKommissionList tesztjét megírni!!!!!
 */
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
          PurchaseContainer purchaseContainer;
          PurchaseOffer purchaseOffer;
          PurchaseConfirmation purchaseConfirmation;
          PurchaseFinal purchaseFinal;
          HashMap<Integer, PurchaseAmount> itemsForPurchase;
          HashMap<Integer, PurchaseAmount> anotherItems;
          Address address;
          LocalDate date;
          Instant time;
          String note;
          HashMap<Integer, PurchaseOffer> purchaseOffers;
          HashMap<Integer, PurchaseConfirmation> purchaseConfirmations;
          HashMap<Integer, PurchaseFinal> purchaseFinals;
          KommissionList kommissionList;

    @BeforeEach
    public void setUp()
    {

        purchaseOffers = new HashMap<>();
        purchaseConfirmations = new HashMap<>();
        purchaseFinals = new HashMap<>();
        address = new Address(5, "a", "b", "c", "d");
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
        itemsForPurchase = new HashMap<>();
        itemsForPurchase.put(9000, new PurchaseAmount(10.0, 100.0, Currency.USD));
        itemsForPurchase.put(8000, new PurchaseAmount(10.0, 50.0, Currency.USD));
        itemsForPurchase.put(50, new PurchaseAmount(10.0, 10.0, Currency.USD));
        purchaseOffer = new PurchaseOffer(itemsForPurchase, address, date, 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
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
        kommissionList = new KommissionList(inventoryContainer);
        itemProvider = new ItemProvider(inventoryContainer);
        note = "valami";
        time = Instant.now();
        date = LocalDate.of(2023, 12, 8);
        anotherItems = new HashMap<>();
        anotherItems.put(4, new PurchaseAmount(1.0, 100, Currency.USD));
        purchaseContainer = new PurchaseContainer(purchaseOffers, purchaseConfirmations, purchaseFinals);
        purchaseContainer.addOffer(purchaseOffer);
        purchaseContainer.addConfirmation(purchaseConfirmation);
        purchaseContainer.addFinal(purchaseFinal);
        mover = new InventoryMover(itemProvider, transitInventory, purchaseContainer, kommissionList);
        
    }

    @Test
    void getKommission()
    {
        assertEquals(kommissionList, mover.getKommissionList());
    }

    @Test
    void getPurchaseContainer()
    {
        assertEquals(purchaseContainer, mover.getPurchaseContainer());
    }

    @Test
    void setPurchaseContainer()
    {
        PurchaseContainer pc = new PurchaseContainer(purchaseOffers, purchaseConfirmations, purchaseFinals);
        mover.setPurchaseContainer(pc);
        assertEquals(pc, mover.getPurchaseContainer());
    }

    @Test
    void findPurchaseFinalInPurchaseContainer()
    {
        assertEquals(100001,  mover.findPurchaseFinalInPurchaseContainer(purchaseFinal.getPurchaseFinalId()).getPurchaseFinalId());
    }

    @Test
    void recivePurchase()
    {
        mover.recivePurchase(purchaseFinal);
        assertEquals(20.0, mover.getProvider().getInventories().getInventory(501).getItemAmount(9000).getTotalAmount());
        assertEquals(19.0, mover.getProvider().getInventories().getInventory(501).getItemAmount(8000).getTotalAmount());
        assertEquals(18.0, mover.getProvider().getInventories().getInventory(501).getItemAmount(50).getTotalAmount());
        assertEquals(PurchaseFinalStatus.RECIVED, purchaseFinal.getStatus());
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
        assertEquals(TransitBundleStatus.SENT, transitInventory.getBundles().get(0).getStatus());
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