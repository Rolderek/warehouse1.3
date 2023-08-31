import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * kommissiós listát készit (lehet hogy tárolja is azt)
 * a foglalásokból kiszűri a még nem elküldött tételeket és visszadja egy értelmezhető listában referenciával a foglalásra
 */

public class ListOfItems
{

    private InventoryContainer inventoryContainer; // ez sem kell még neki egyenlőre?!

    private TransitInventory transitInventory;

    private ArrayList<TransitBundle> savedList = new ArrayList<>();

    public ListOfItems(InventoryContainer  inventoryContainer, TransitInventory transitInventory)
    {
        this.inventoryContainer = inventoryContainer;
        this.transitInventory = transitInventory;
    }

    public InventoryContainer getInventoryContainer()
    {
        return inventoryContainer;
    }

    public TransitInventory getTransitInventory()
    {
        return transitInventory;
    }

    /**
     * egy adott raktárnak az összeszedhető rendeléseit adja vissza
     */
    public ArrayList<TransitBundle> makeListOfAWarehouse(int warehouseId)
    {
        ArrayList<TransitBundle> actualList = new ArrayList<>();
        for (int id : transitInventory.getBundles().keySet())
        {
            /**
             * végigmászik a tranzitban lévő TransitBundle-eken és aminek megegyezik a küldő raktárID-ja + csak foglalva van azokat beteszi egy listába.
             * igy elérhető lesz később a cimzett paraméter is [transitBundle.getSenderId()]
             */
            if (warehouseId == transitInventory.getBundles().get(id).getSenderId() && transitInventory.getBundles().get(id).getStatus() == TranstiBundleStatus.RESERVED)
            {
                actualList.add(transitInventory.getBundles().get(id));
                savedList.add(transitInventory.getBundles().get(id));
            }
        }
        return actualList;
    }

    /**
     * az összes raktár összeszedhető rendeléseit adja vissza
     */
    public ArrayList<TransitBundle> makeListOfAllWarehouse()
    {
        ArrayList<TransitBundle> actualList = new ArrayList<>();
        for (int id : transitInventory.getBundles().keySet())
        {
            if (transitInventory.getBundles().get(id).getStatus() == TranstiBundleStatus.RESERVED)
            {
                actualList.add(transitInventory.getBundles().get(id));
            }
        }
        return actualList;
    }

    /**
     * frissiti a listát
     * vagy csak a frissitettet adja ki az előző függvényében
     */
    public ArrayList<TransitBundle> makeListOfAWarehouseRefresh(int warehouseId)
    {
        for (int id : transitInventory.getBundles().keySet())
        {
            if (warehouseId == transitInventory.getBundles().get(id).getSenderId() && transitInventory.getBundles().get(id).getStatus() == TranstiBundleStatus.RESERVED)
            {
                if (!savedList.contains(transitInventory.getBundles().get(id)))
                {
                    savedList.add(transitInventory.getBundles().get(id));
                }
            }
        }
        return savedList;
    }

    /**
     * elküldi a listát
     */
    public void sendTheList()
    {

    }
}
