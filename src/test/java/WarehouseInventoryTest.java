import junit.framework.TestCase;

import java.util.HashMap;


public class WarehouseInventoryTest extends TestCase {


    public void testGetId() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address

        );
        assertEquals(010, warehouseInventory.getWarehouseId());
    }

    public void testSetId() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address
        );
        warehouseInventory.setWarehouseId(999);
        assertEquals(999, warehouseInventory.getWarehouseId());
    }

    public void testTestGetName() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address
        );
        assertEquals("Raktár", warehouseInventory.getName());
    }

    public void testTestSetName() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address
        );
        warehouseInventory.setName("Valami");
        assertEquals("Valami", warehouseInventory.getName());
    }

    public void testGetAddress() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address
        );
        assertEquals(address, warehouseInventory.getAddress());
    }

    public void testSetAddress() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address
        );
        Address addy = new Address(
                9999,
                "Sárospatak",
                "izé",
                "hozé",
                "753");
        warehouseInventory.setAddress(addy);
        assertEquals(addy, warehouseInventory.getAddress());
    }

    public void testGetAllItems() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        Item itemOne = new Item(
                9000,
                "Toll",
                "sima kék",
                "XZ789",
                700.50,
                900.50
        );
        Item itemTwo = new Item(
                8000,
                "izéke",
                "tulajdonság",
                "MZ/X",
                500,
                680
        );
        Item itemThree = new Item(
                0050,
                "bigyóka",
                "tulajdonság",
                "AH64",
                100,
                127
        );

        HashMap<Integer, ItemAmount> items = new HashMap<>();

        items.put(itemOne.hashCode(), new ItemAmount(200.0));
        items.put(itemThree.hashCode(), new ItemAmount(5.0));
        items.put(itemTwo.hashCode(), new ItemAmount(30.0));
        WarehouseInventory warehouseInventory = new WarehouseInventory(010, "Raktár", address, items);
        assertEquals(items.toString(), warehouseInventory.getAllItems().toString());
    }

    public void testGetItemAmount() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, ItemAmount> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address,
                items
        );
        Item itemOne = new Item(
                9000,
                "Toll",
                "sima kék",
                "XZ789",
                700.50,
                900.50
        );
        Item itemTwo = new Item(
                8000,
                "izéke",
                "tulajdonság",
                "MZ/X",
                500,
                680
        );
        Item itemThree = new Item(
                0050,
                "bigyóka",
                "tulajdonság",
                "AH64",
                100,
                127
        );
        items.put(itemOne.hashCode(), new ItemAmount(200.0));
        items.put(itemThree.hashCode(), new ItemAmount(5.0));
        items.put(itemTwo.hashCode(), new ItemAmount(30.0));
        assertEquals(200.0, warehouseInventory.getItemAmount(itemOne.getIdentifier()).getTotalAmount());
    }

    public void testAddItem() {
        Address address = new Address(
            1234,
            "Pest",
            "Arany utca",
            "12/A",
            "+3645123456");
        HashMap<Integer, ItemAmount> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address,
                items
        );
        Item itemOne = new Item(
                9000,
                "Toll",
                "sima kék",
                "XZ789",
                700.50,
                900.50
        );
        items.put(itemOne.getIdentifier(), new ItemAmount(50.0));
        warehouseInventory.addItem(itemOne.getIdentifier(), 10);
        assertEquals(60.0, warehouseInventory.getItemAmount(itemOne.getIdentifier()).getTotalAmount());
    }

    public void testSetItems() {
        /**
        ez még nem biztos hogy jó, mert önmagát hasonlitja magához
         */
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, ItemAmount> items = new HashMap<>();
        WarehouseInventory warehouseInventory = new WarehouseInventory(
                010,
                "Raktár",
                address,
                items
        );
        Item itemOne = new Item(
                9000,
                "Toll",
                "sima kék",
                "XZ789",
                700.50,
                900.50
        );
        Item itemTwo = new Item(
                8000,
                "izéke",
                "tulajdonság",
                "MZ/X",
                500,
                680
        );
        warehouseInventory.addItem(itemOne.getIdentifier(), 10);
        HashMap<Integer, ItemAmount> stuff = new HashMap<>();
        stuff.putIfAbsent(itemTwo.getIdentifier(), new ItemAmount(20.0));
        warehouseInventory.setItems(stuff);
        assertEquals(stuff, warehouseInventory.getAllItems());
    }
}