import java.util.ArrayList;
import java.util.HashMap;

public class TestMain
{

    public static void main(String[] args)
    {
        /** address készités */
        Address address1 = new Address(3903, "Bekecs", "Tűzoltó út", "28", "06901123456");
        Address address2 = new Address(4000, "Debrecen", "Fing utca", "3", "11111111111");
        /** itemek készités */
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        Item itemTwo = new Item(8000, "izéke", "tulajdonság", "MZ/X", 500, 680);
        Item itemThree = new Item(50, "bigyóka", "tulajdonság", "AH64", 100, 127);
        /** itemAmount készités */
        ItemAmount itemOneAmount = new ItemAmount(10.0, 0.0);
        ItemAmount itemTwoAmount = new ItemAmount(9.0, 0.0);
        ItemAmount itemThreeAmount = new ItemAmount(8.0, 0.0);
        ItemAmount itemOneAmountW2 = new ItemAmount(5.0, 0.0);
        ItemAmount itemTwoAmountW2 = new ItemAmount(5.0, 0.0);
        ItemAmount itemThreeAmountW2 = new ItemAmount(5.0, 0.0);
        /** item itemAmount párok bepakolása a raktárakba */
        HashMap<Integer, ItemAmount> items = new HashMap<Integer, ItemAmount>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        items.put(itemTwo.getIdentifier(), itemTwoAmount);
        items.put(itemThree.getIdentifier(), itemThreeAmount);

        HashMap<Integer, ItemAmount> itemsW2 = new HashMap<Integer, ItemAmount>();
        itemsW2.put(itemOne.getIdentifier(), itemOneAmountW2);
        itemsW2.put(itemTwo.getIdentifier(), itemTwoAmountW2);
        itemsW2.put(itemThree.getIdentifier(), itemThreeAmountW2);
        /** raktárak létrehozása */
        WarehouseInventory w1 = new WarehouseInventory(501, "Központ", address1, items);
        WarehouseInventory w2 = new WarehouseInventory(102, "Dábrechen", address2, itemsW2);
        /** küldendő listák létrehozása */
        HashMap<Integer, Double> itemsToSend1 = new HashMap<Integer, Double>();
        itemsToSend1.put(itemOne.getIdentifier(), 3.0);
        itemsToSend1.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend1.put(itemThree.getIdentifier(), 1.0);

        HashMap<Integer, Double> itemsToSend2 = new HashMap<Integer, Double>();
        itemsToSend2.put(itemOne.getIdentifier(), 2.0);
        itemsToSend2.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend2.put(itemThree.getIdentifier(), 2.0);
        /** WarehouseInventory létrehozása */
        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        inventories.put(501, w1);
        inventories.put(102, w2);
        /** TransitInventory létrehozása */
        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory transitInventory = new TransitInventory(bundles);
        /** InventoryContainer létrehozása */
        InventoryContainer inventoryContainer = new InventoryContainer(inventories, transitInventory, new ItemMovement(new ArrayList<TransitBundle>()));
        /** ItemProvider létrehozása */
        ItemProvider itemProvider = new ItemProvider(inventoryContainer);
        /** InventoryMover létrehozása */
        InventoryMover mover = new InventoryMover(itemProvider, transitInventory);

        /** Tényleges munkavégzés:*/

        System.out.println("Foglalás előtti foglalt készlet: " + w1.getItemAmount(itemOne.getIdentifier()).getReservedAmount());
        System.out.println("Foglalás előtti szabad készlet: " + w1.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
        System.out.println("Foglalás előtti teljes készlet: " + w1.getItemAmount(itemOne.getIdentifier()).getTotalAmount());

        System.out.println(itemProvider.getInventories().getInventory(w2.getWarehouseId()).getItemAmount(itemOne.getIdentifier()).getTotalAmount());
/**
 mover.sendItems(new TransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
 mover.reciveItems(new TransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
 */
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));
        mover.sendItems(itemProvider.reserveAllAmountAndMakeTransitBundle(itemsToSend2, w1.getWarehouseId(), w2.getWarehouseId()));
        /** ha duplikálom a sort nem fordul le! */

        System.out.println("Tranziban lévő listák: " + inventoryContainer.getTransitInvertory().getBundles().size());

        //System.out.println(transitInventory.getBundles().get(0).getSendTime());

        mover.reciveItems(transitInventory.getBundles().get(0)); // ezt majd átnézni!
        mover.reciveItems(transitInventory.getBundles().get(0)); // ezt majd átnézni!


        System.out.println(itemProvider.getInventories().getInventory(w2.getWarehouseId()).getItemAmount(itemOne.getIdentifier()).getTotalAmount());

        /**
         System.out.println("w1 készlet: " + w1.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
         System.out.println("w2 készlet: " + w2.getItemAmount(itemOne.getIdentifier()).getFreeAmount());

         mover.reciveItems(new TransitBundle(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId()));

         System.out.println("w1 készlet: " + w1.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
         System.out.println("w2 készlet: " + w2.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
         */

        System.out.println("Foglalás utáni foglalt mennyiség: " + w1.getItemAmount(itemOne.getIdentifier()).getReservedAmount());
        System.out.println("Foglalás utáni szabad mennyiség: " + w1.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
        System.out.println("Foglalás utáni teljes mennyiség: " + w1.getItemAmount(itemOne.getIdentifier()).getTotalAmount());

        System.out.println("Tranziban lévő listák: " + inventoryContainer.getTransitInvertory().getBundles().size());

        System.out.println(inventoryContainer.getReservations().getWasMoving().size());

        System.out.println(inventoryContainer.getMyReservation(501).size());
    }

}
