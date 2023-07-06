import java.util.HashMap;

public class TestMain {

    public static void main(String[] args) {
    Address address1 = new Address(3903, "Bekecs", "Tűzoltó út", "28", "06901123456");
    Address address2 = new Address(4000, "Debrecen", "Fing utca", "3", "11111111111");
        Item itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        Item itemTwo = new Item(8000, "izéke", "tulajdonság", "MZ/X", 500, 680);
        Item itemThree = new Item(0050, "bigyóka", "tulajdonság", "AH64", 100, 127);

        ItemAmount itemOneAmount = new ItemAmount(10.0, 1.0);
        ItemAmount itemTwoAmount = new ItemAmount(5.0, 1.0);
        ItemAmount itemThreeAmount = new ItemAmount(4.0, 1.0);

        HashMap<Integer, ItemAmount> items = new HashMap<Integer, ItemAmount>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        items.put(itemTwo.getIdentifier(), itemTwoAmount);
        items.put(itemThree.getIdentifier(), itemThreeAmount);

        WarehouseInventory w1 = new WarehouseInventory(501, "Központ" ,address1, items);
        WarehouseInventory w2 = new WarehouseInventory(102, "Dábrechen" ,address2, items);

        HashMap<Integer, Double> itemsToSend1 = new HashMap<Integer, Double>();
        itemsToSend1.put(itemOne.getIdentifier(), 4.0);
        itemsToSend1.put(itemTwo.getIdentifier(), 1.0);
        itemsToSend1.put(itemThree.getIdentifier(), 3.0);

        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        inventories.put(501, w1);
        inventories.put(102, w2);

        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory ti = new TransitInventory(bundles);
        InventoryContainer inventoryContainer = new InventoryContainer(inventories, ti);
        /** GreviousGenerator-al van egy kis gubanc, nem generál semmit mert null a számlálója */

        ItemProvider provider = new ItemProvider(inventoryContainer);

        System.out.println(w1.getItemAmount(itemOne.getIdentifier()).getReservedAmount());
        System.out.println(w1.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
        System.out.println(w1.getItemAmount(itemOne.getIdentifier()).getTotalAmount());

        provider.reserveAllAmount(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId());
        provider.reserveAllAmount(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId());

        System.out.println(w1.getItemAmount(itemOne.getIdentifier()).getReservedAmount());
        System.out.println(w1.getItemAmount(itemOne.getIdentifier()).getFreeAmount());
        System.out.println(w1.getItemAmount(itemOne.getIdentifier()).getTotalAmount());

        System.out.println(inventoryContainer.getTransitInvertory());
        /** sajnos null-t ad vissza, valamiért nem teszi be a transitInvetory-ba a T.bundle-eket
         * nem jó az exception-öm */
    }

}
