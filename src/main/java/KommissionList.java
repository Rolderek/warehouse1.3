import java.util.ArrayList;
import java.util.HashMap;

public class KommissionList
{

    private InventoryContainer inventoryContainer;

    private HashMap<Integer, HashMap<Integer, Double>> dedicatedWarehouseList = new HashMap<>();

    private HashMap<Integer, HashMap<Integer, Double>> allWarehouseList = new HashMap<>();

    public KommissionList(InventoryContainer inventoryContainer)
    {
        this.inventoryContainer = inventoryContainer;
    }

    public void setInventoryContainer(InventoryContainer newInventoryContainer)
    {
        inventoryContainer = newInventoryContainer;
    }

    /**
     * egy adott raktár összes fogalat elemét visszaadja egy listában
     * (optimalizált kürölményekre van most irva)
     * @return
     * cimzett raktár kódja, küldendő elemek listája
     */
    public HashMap<Integer, HashMap<Integer, Double>> kommissionListOfOneWarehouse(int id)
    {
        int recipientIp;
        HashMap<Integer, HashMap<Integer, Double>> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            recipientIp = inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getRecipientId();
            if (id == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getSenderId() && inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TransitBundleStatus.RESERVED)
            {
                resultList.put(recipientIp, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
        dedicatedWarehouseList = resultList;
        return resultList;
    }

    /**
     * lehet hogy itt az elv rossz és TransitBundle-eket kellene visszaadnom mert azokat egyszerűbb küldeni az InventoryMover-ben
     */
    public HashMap<Integer, HashMap<Integer, Double>> kommissionListOfOneWarehouseWithTransitBundleId(int id)
    {
        HashMap<Integer, HashMap<Integer, Double>> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (id == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getRecipientId())
            {
                resultList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
        return resultList;
    }

    /**
     * szűrés nélkül visszaadja az összes csak lefoglalt, de még el nem küldött tételt, az összes raktárban
     */
    public HashMap<Integer, HashMap<Integer, Double>> allKommissionListOfAllWarehouse()
    {
        HashMap<Integer, HashMap<Integer, Double>> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            /**
             * itt a raktárak alapján érdemes lenne rendezni már az elején a listát, most ömlesztve jön
             */
            if (inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TransitBundleStatus.RESERVED)
            {
                resultList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }

        }
        allWarehouseList = resultList;
        return resultList;
    }


    /**
     * itt a fogadó kódja az első int érték a HashMap-ben
     * lehet a duplikált rendeléseknél gondot fog okozni, majd átirjuk ha igen
     */
    public void refreshAKommissionListOneWarehouse(int warehouseId)
    {
        int recipientId;
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            recipientId = inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getRecipientId();
            if (warehouseId == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getSenderId() && !dedicatedWarehouseList.containsKey(transitBundleId))
            {
                dedicatedWarehouseList.put(recipientId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
    }

    /**
     * itt a TransitBundle sorszáma az első int érték a HashMap-ben
     */
    public void refreshAKommissionListOfAllWarehouse()
    {
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (!allWarehouseList.containsKey(transitBundleId))
            {
                allWarehouseList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
    }

    public HashMap<Integer, HashMap<Integer, Double>> getAllWarehouseList()
    {
        return allWarehouseList;
    }

    public HashMap<Integer, HashMap<Integer, Double>> getDedicatedWarehouseList()
    {
        return dedicatedWarehouseList;
    }

    public InventoryContainer getInventoryContainer()
    {
        return inventoryContainer;
    }

    /**
     * TransitBundle HashMap visszatérési értékkel a lsitázások
     */
    public HashMap<Integer, TransitBundle> getOneWarehouseList(int warehoiseId)
    {

        HashMap<Integer, TransitBundle> resultList = new HashMap<>();
        for (int transitBunddleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            int bundleRecicpientId = inventoryContainer.getTransitInvertory().getBundles().get(transitBunddleId).getRecipientId();
            if (warehoiseId == bundleRecicpientId)
            {
                resultList.put(transitBunddleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBunddleId));
            }
        }

        return resultList;
    }

    /**
     * ennek lehet nem lesz létjogosultsága, de meglátjuk
     */
    public HashMap<Integer, HashMap<Integer, Double>> transitBundleToItemAndAmountList(HashMap<Integer, TransitBundle> sortedBundleList)
    {
        HashMap<Integer, HashMap<Integer, Double>> resultList = new HashMap<>();
        for (int transitBundleId : sortedBundleList.keySet())
        {
            resultList.put(transitBundleId, sortedBundleList.get(transitBundleId).getItems());
        }

        return resultList;
    }
}
