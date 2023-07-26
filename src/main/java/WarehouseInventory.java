import org.apache.camel.InOnly;
import java.util.HashMap;

/**
 * Egy adott raktár készleteit tárolja. Elérhető és foglalt készletek.
 */
public class WarehouseInventory implements Inventory
{

    private int WarehouseId;

    private String name;

    private Address address;

    /** This stores Item Identifier, amount pairs.*/
    private HashMap<Integer, ItemAmount> items;

    public WarehouseInventory(int WarehouseId, String name, Address address, HashMap<Integer, ItemAmount> items)
    {
        this.WarehouseId = WarehouseId;
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public WarehouseInventory(int WarehouseId, String name, Address address)
    {
        this.WarehouseId = WarehouseId;
        this.name = name;
        this.address = address;
    }

    public WarehouseInventory(int WarehouseId, String name)
    {
        this.WarehouseId = WarehouseId;
        this.name = name;
    }

    public int getWarehouseId()
    {
        return WarehouseId;
    }

    public void setWarehouseId(int warehouseId)
    {
        this.WarehouseId = warehouseId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public HashMap<Integer, ItemAmount> getAllItems()
    {
        return items;
    }

    @Override
    public HashMap<Integer, Double> getAllItemsOfWarehouse(int warehouseId)
    {
        HashMap<Integer, Double> warehouseItems = new HashMap<>();
        if (warehouseId == this.WarehouseId)
        {
            for (int key : items.keySet())
            {
                warehouseItems.put(key, items.get(key).getFreeAmount());
            }
        }
        return warehouseItems;
    }

    public ItemAmount getItemAmount(int itemIdentifier)
    {
        return items.getOrDefault(itemIdentifier, new ItemAmount(0.0, 0.0));
    }

    public void addItem(int id, double amount)
    {
        ItemAmount current = items.getOrDefault(id, new ItemAmount(0.0, 0.0));
        items.put(id, new ItemAmount(
                amount + current.getTotalAmount(),
                current.getReservedAmount())
        );
    }

    /** ezt majd a logikába kell betenni */
    public void setItems(HashMap<Integer, ItemAmount> items)
    {
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
