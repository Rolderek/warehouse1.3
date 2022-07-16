import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private int id;

    private String name;

    private Address address;

    /** This stores Item Identifier, amount pairs.*/
    private HashMap<Integer, ItemAmount> items;

    public Inventory(int id, String name, Address address, HashMap<Integer, ItemAmount> items) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public Inventory(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Inventory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public HashMap<Integer, ItemAmount> getAllItems() {
        return items;
    }

    public ItemAmount getItemAmount(int itemIdentifier) {
        return items.getOrDefault(itemIdentifier, new ItemAmount(0.0, 0.0));
    }

    public void addItem(int id, double amount) {
      ItemAmount current = items.getOrDefault(id, new ItemAmount(0.0, 0.0));
      items.put(id, new ItemAmount(
              amount + current.getTotalAmount(),
              current.getReservedAmount())
      );
    }

    /* ezt majd a logikába kell betenni */
    public void setItems(HashMap<Integer, ItemAmount> items) {
        this.items = items;
    }

    /*
    Address address = new Address(
                3903,
                "Bekecs",
                "Tűzoltó út",
                "28",
                "06901123456");
        Item itemOne = new Item(
                9000,
                "Toll",
                "sima kék",
                "XZ789",
                700.50,
                900.50);
        Item itemTwo = new Item(
                8000,
                "izéke",
                "tulajdonság",
                "MZ/X",
                500,
                680);
        Item itemThree = new Item(
                0050,
                "bigyóka",
                "tulajdonság",
                "AH64",
                100,
                127);
     */

}
