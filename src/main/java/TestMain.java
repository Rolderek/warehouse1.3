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
        itemsToSend1.put(itemThree.getIdentifier(), 4.0);

        HashMap<Integer, WarehouseInventory> inventories = new HashMap<>();
        inventories.put(501, w1);
        inventories.put(102, w2);

        HashMap<Integer, TransitBundle> bundles = new HashMap<>();
        TransitInventory ti = new TransitInventory(bundles);
        InventoryContainer inventoryContainer = new InventoryContainer(inventories, ti);

        ItemProvider provider = new ItemProvider(inventoryContainer);

        System.out.println("Foglalás előtti foglalt készlet: " + w1.getItemAmount(itemThree.getIdentifier()).getReservedAmount());
        System.out.println("Foglalás előtto szabad készlet: " + w1.getItemAmount(itemThree.getIdentifier()).getFreeAmount());
        System.out.println("Foglalás előtti teljes készlet: " + w1.getItemAmount(itemThree.getIdentifier()).getTotalAmount());

        provider.reserveAllAmount(itemsToSend1, w1.getWarehouseId(), w2.getWarehouseId());

        System.out.println("Foglalás utáni foglalt mennyiség: " + w1.getItemAmount(itemThree.getIdentifier()).getReservedAmount());
        System.out.println("Foglalás utáni szabad mennyiség: " + w1.getItemAmount(itemThree.getIdentifier()).getFreeAmount());
        System.out.println("Foglalás utáni teljes mennyiség: " + w1.getItemAmount(itemThree.getIdentifier()).getTotalAmount());
    }

}
