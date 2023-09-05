import java.util.HashMap;

public class KommissionList
{

    private InventoryContainer inventoryContainer;

    private HashMap<Integer, HashMap<Integer, Double>> dedicatedWarehouseList = new HashMap<>();

    private HashMap<Integer, HashMap<Integer, Double>> allwarehouseList = new HashMap<>();

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
     */
    public HashMap<Integer, HashMap<Integer, Double>> getKommissionListOfOneWarehouse(int id)
    {
        int recipientIp;
        HashMap<Integer, HashMap<Integer, Double>> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            recipientIp = inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getRecipientId();
            if (id == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getSenderId() && inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TranstiBundleStatus.RESERVED)
            {
                resultList.put(recipientIp, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
        dedicatedWarehouseList = resultList;
        return resultList;
    }

    /**
     * szűrés nélkül visszaadja az összes csak lefoglalt, de még el nem küldött tételt, az összes raktárban
     */
    public HashMap<Integer, HashMap<Integer, Double>> getAllKommissionListOfAllWarehouse()
    {
        HashMap<Integer, HashMap<Integer, Double>> resultList = new HashMap<>();
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            /**
             * itt a raktárak alapján érdemes lenne rendezni már az elején a listát, most ömlesztve jön
             */
            if (inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getStatus() == TranstiBundleStatus.RESERVED)
            {
                resultList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }

        }
        allwarehouseList = resultList;
        return resultList;
    }


    public void refreshAKommissionListOneWarehouse(int warehouseId)
    {
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (warehouseId == inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getSenderId() && !dedicatedWarehouseList.containsKey(transitBundleId))
            {
                dedicatedWarehouseList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
    }

    public void refreshAKommissionListOfAllWarehouse()
    {
        for (int transitBundleId : inventoryContainer.getTransitInvertory().getBundles().keySet())
        {
            if (!allwarehouseList.containsKey(transitBundleId))
            {
                allwarehouseList.put(transitBundleId, inventoryContainer.getTransitInvertory().getBundles().get(transitBundleId).getItems());
            }
        }
    }

    public void sendKommissionList()
    {
        /**
          * egy kommisiós lista alapján elküldi a tételeket
          */
    }

    public HashMap<Integer, HashMap<Integer, Double>> getAllwarehouseList()
    {
        return allwarehouseList;
    }

    public HashMap<Integer, HashMap<Integer, Double>> getDedicatedWarehouseList()
    {
        return dedicatedWarehouseList;
    }

    public InventoryContainer getInventoryContainer()
    {
        return inventoryContainer;
    }
}
