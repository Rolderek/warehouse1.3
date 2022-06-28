import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;


public class InventoryTest extends TestCase {

    public void testGetId() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
                010,
                "Raktár",
                address,
                items
        );
        assertEquals(010, inventory.getId());
    }

    public void testSetId() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
                010,
                "Raktár",
                address,
                items
        );
        inventory.setId(999);
        assertEquals(999, inventory.getId());
    }

    public void testTestGetName() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
                010,
                "Raktár",
                address,
                items
        );
        assertEquals("Raktár", inventory.getName());
    }

    public void testTestSetName() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
                010,
                "Raktár",
                address,
                items
        );
        inventory.setName("Valami");
        assertEquals("Valami", inventory.getName());
    }

    public void testGetAddress() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
                010,
                "Raktár",
                address,
                items
        );
        assertEquals(address, inventory.getAddress());
    }

    public void testSetAddress() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
                010,
                "Raktár",
                address,
                items
        );
        Address addy = new Address(
                9999,
                "Sárospatak",
                "izé",
                "hozé",
                "753");
        inventory.setAddress(addy);
        assertEquals(addy, inventory.getAddress());
    }

    public void testGetAllItems() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
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
        items.put(itemOne.hashCode(), 200.0);
        items.put(itemThree.hashCode(), 5.0);
        items.put(itemTwo.hashCode(), 30.0);
        assertEquals(items.toString(), inventory.getAllItems().toString());
    }

    public void testGetItemAmount() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
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
        items.put(itemOne.hashCode(), 200.0);
        items.put(itemThree.hashCode(), 5.0);
        items.put(itemTwo.hashCode(), 30.0);
        assertEquals(200.0,inventory.getItemAmount(itemOne.getIdentifier())
        );
    }

    public void testAddItem() {
        Address address = new Address(
            1234,
            "Pest",
            "Arany utca",
            "12/A",
            "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
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
        items.put(itemOne.getIdentifier(), 50.0);
        inventory.addItem(itemOne.getIdentifier(), 10);
        assertEquals(60.0, inventory.getItemAmount(itemOne.getIdentifier()));
    }

    public void testSetItems() {
        Address address = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        HashMap<Integer, Double> items = new HashMap<>();
        Inventory inventory = new Inventory(
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
        inventory.addItem(itemOne.getIdentifier(), 10);
        HashMap<Integer, Double> stuff = new HashMap<>();
        stuff.putIfAbsent(itemTwo.getIdentifier(), 20.0);
        inventory.setItems(stuff);
        assertEquals(stuff, inventory.getAllItems());
    }
}