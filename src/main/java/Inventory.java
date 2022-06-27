import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private int id;

    private String name;

    private Address address;

    private HashMap<Integer, Double> items;

    public Inventory(int id, String name, Address address, HashMap<Integer, Double> items) {
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

    public HashMap<Integer, Double> getAllItems() {
        return items;
    }

    public double getItemAmount(int itemIdentifier) {
        return items.getOrDefault(itemIdentifier, 0.0);
        /*
        if (items.get(itemIdentifier) == null) {
            return 0;
        } else {
            return items.get(itemIdentifier);
        }
         */
    }

    public void addItem(int id, double amount) {
      double current = items.getOrDefault(id, 0.0);
      items.put(id, amount + current);
    }

    public void setItems(HashMap<Integer, Double> items) {
        this.items = items;
    }


    public static void main(String[] args) {

        Address address = new Address(
                3903,
                "Bekecs",
                "Tűzoltó út",
                "28",
                "06901123456");
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(8000, 250.0);
        map.put(4000, 3789.0);
        map.put(0004, 2.0);

        Inventory i = new Inventory(
                        001,
                        "Próba",
                address,
                map
            );
        System.out.println(map);
        System.out.println(i.getAllItems());
        System.out.println(i.getItemAmount(8000));
        i.addItem(8000, 50);
        System.out.println(i.getItemAmount(8000));

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
