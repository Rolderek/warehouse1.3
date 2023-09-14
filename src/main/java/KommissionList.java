import java.util.HashMap;

/**
 * készit egy listás a még el nem küldött rendelésekről TransitBundle-ök alapján
 */

public class KommissionList
{

    private InventoryContainer inventoryContainer;

    private HashMap<Integer, TransitBundle> onlyOneWarehouseList = new HashMap<>();

    private HashMap<Integer, TransitBundle> allWarehouseList = new HashMap<>();

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
     * @param id
     * az a WarehouseId amiből küldeni akarunk
     * @return
     * TransitBundleId a TransitInventory-ból, adott TransitBundle
     */
    public HashMap<Integer, TransitBundle> makeKommissionListOfOneWarehouse(int id)
    {
        HashMap<Integer, TransitBundle> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (id == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getSenderId() && inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TransitBundleStatus.RESERVED)
            {
                resultList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId));
            }
        }
        onlyOneWarehouseList = resultList;
        return resultList;
    }

    /**
     * szűrés nélkül visszaadja az összes csak lefoglalt, de még el nem küldött tételt, az összes raktárban
     */
    public HashMap<Integer, TransitBundle> makeAllKommissionListOfAllWarehouse()
    {
        HashMap<Integer, TransitBundle> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            /**
             * itt a raktárak alapján érdemes lenne rendezni már az elején a listát, most ömlesztve jön
             */
            if (inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TransitBundleStatus.RESERVED)
            {
                resultList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId));
            }
        }
        allWarehouseList = resultList;
        return resultList;
    }



    public void refreshKommissionListOneWarehouse(int recipientWarehouseId)
    {
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (recipientWarehouseId == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getSenderId() && !onlyOneWarehouseList.containsKey(transitBundleId))
            {
                onlyOneWarehouseList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId));
            }
        }
    }

    /**
     * itt a TransitBundle sorszáma az első int érték a HashMap-ben
     */
    public void refreshKommissionListOfAllWarehouse()
    {
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (!allWarehouseList.containsKey(transitBundleId))
            {
                allWarehouseList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId));
            }
        }
    }

    public HashMap<Integer, TransitBundle> getAllWarehouseList()
    {
        return allWarehouseList;
    }

    public InventoryContainer getInventoryContainer()
    {
        return inventoryContainer;
    }

    public HashMap<Integer, TransitBundle> getOnlyOneWarehouseList()
    {
        return onlyOneWarehouseList;
    }
}
