import java.util.ArrayList;
import java.util.HashMap;

/**
 * Szűrt listákat csinál a mindenkori mozgásokról, még nem biztos hogy kelleni fog, Mr.Architect majd megmondja
 *
 * tesztet meg kell majd csinálni hozzá
 */

public class MovementLister
{
    private InventoryContainer inventoryContainer;

    public MovementLister(InventoryContainer inventoryContainer)
    {
        this.inventoryContainer = inventoryContainer;
    }

    public InventoryContainer getInventoryContainer()
    {
        return inventoryContainer;
    }


/**
* egy adott elem mozgását listázza ki
*/
    public HashMap<Integer, Double> listOneItemMovement(int itemId)
    {
        /**
         * a HashMap-et lehet le kell cserélni ArrayList-re a duplikációk miatt
         */
        HashMap<Integer, Double> resultHashMap = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems().containsKey(itemId) &&
                inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TransitBundleStatus.RESERVED)
            {
                resultHashMap.put(
                  itemId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems().get(itemId)
                );
            }
        }
        if (resultHashMap.isEmpty())
        {
            System.out.println("There is no movement of this item: " + itemId);
        }
        return resultHashMap;
    }

    public boolean warehouseIdCheck(int warehouseId)
    {
        boolean result = false;
        if (inventoryContainer.getAllInventories().containsValue(warehouseId))
        {
            result = true;
        }
        return result;
    }

/**
* segit csinálni egy egyszerű listát ahol csak a cikkek és a mennyiségek vannak a transitBundle listából
*/
    public ArrayList<MovementHelper> transitBundleSorter(ArrayList<TransitBundle> listToSort)
    {
        ArrayList<MovementHelper> resultList = new ArrayList<>();

        return resultList;
    }

/**
* egy adott raktár befelé irányuló teljes mozgásást listázza ki
*/
    public ArrayList<TransitBundle> listOneWarehouseMovementIn(int warehouseId)
    {
        ArrayList<TransitBundle> resultList = new ArrayList<>();
        if (warehouseIdCheck(warehouseId) == true)
        {
            for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
            {
                if (inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getRecipientId() == warehouseId)
                {
                    resultList.add(inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId));
                }
            }
        } else
        {
            System.out.println("There is no warehouse with this id: " + warehouseId);
        }
        return resultList;
    }

/**
* egy adott raktár kifelé irányuló teljes mozgásást listázza ki
*/
    public void listOneWarehouseMovementOut()
    {

    }

/**
* egy adott raktár teljes mozgásást listázza ki
* (ki és be oldal)
*/
    public void listOneWarehouseMovement()
    {

    }

}
