import java.time.Instant;
import java.util.HashMap;

/**
 * ez komunikál a felhasználókkal és az InventoryMover-nek továbbadja a feladatokat.
 */
public class ItemProvider
{


    private InventoryContainer inventories;

    public ItemProvider(InventoryContainer inventories)
    {
        this.inventories = inventories;
    }

    /**
     * TransitBundle-t csinál
     * @return egy TransitBundle-t az adott foglalással ha sikeres volt, egyébként null
     */
    public TransitBundle makeReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId)
    {
        if (itemListCheck(inventories, itemsToReservate, senderId) != true)
        {
            System.out.println("There is not enough free amount of some item!");
            return null;
        }
        TransitBundle tb = new TransitBundle(itemsToReservate, senderId, recipientId);
        inventories.getReservations().addBundleToWasMovingList(tb);
        return tb;
    }

    /**
      * TransitBundle-t csinál és le is foglalja,
      * @return TransitBundle ha sikerült, null amennyiben nem.
      */
    public TransitBundle reserveAllAmountAndMakeTransitBundle(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId)
    {
        if (itemListCheck(inventories, itemsToReservate, senderId) != true)
        {
            System.out.println("There is no enough free amount of some item/items");
            return null;
        }
        reserveAllAmountHelper(itemsToReservate, senderId);
        return makeReservation(itemsToReservate, senderId, recipientId);
    }

    /** szóval, végigfoglalja, majd ellenőriz és ha nem jó akkor visszaállitja az eredetire a foglalt mennyiséget
      * kell e az if-ekhez és a for-hoz egyszerűsitő metódus?
      */
    public void reserveAllAmountHelper(HashMap<Integer, Double> itemsToReservate, int senderId)
    {
        HashMap<Integer, Double> originalList = new HashMap<Integer, Double>();
        HashMap<Integer, Double> newList = new HashMap<Integer, Double>();
        for (int itemId : itemsToReservate.keySet())
        {
            /** innen minden sornak lehet saját metódusa ami kiváltja */
            originalList.put(itemId, inventories.getInventory(senderId).getItemAmount(itemId).getReservedAmount());
            newList.put(itemId, itemsToReservate.get(itemId) + originalList.get(itemId));
            inventories.getInventory(senderId).getItemAmount(itemId).reserveAmount(itemsToReservate.get(itemId));
            if (newList.get(itemId) != inventories.getInventory(senderId).getItemAmount(itemId).getReservedAmount())
            {
                inventories.getInventory(senderId).getItemAmount(itemId).reserveAmount(0 - itemsToReservate.get(itemId));
            }
        }
    }

    public Boolean itemListCheck(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToReservate, int senderId)
    {
        /** ellenőrzi az szabad készletet és visszaad egy listát vagy hibát */
        HashMap<Integer, Double> gooditems = new HashMap<Integer, Double>();
        HashMap<Integer, Double> missingItems = new HashMap<Integer, Double>();
        for (int key : itemsToReservate.keySet())
        {
            if (amountControlAmount(inventoryContainer.getInventory(senderId), key, itemsToReservate.get(key)) == true)
            {
                gooditems.put(key, itemsToReservate.get(key));
            }
            else
            {
                missingItems.put(key, itemsToReservate.get(key));
            }
        }
        if (missingItems.isEmpty() || missingItems.size() < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean amountControlAmount(WarehouseInventory sender, int item, double amount)
    {
        /** segéd metódus az ellenőrzéshez */
        boolean result = false;
        if (sender.getItemAmount(item).getFreeAmount() >= amount)
        {
            result = true;
        }
        return result;
    }

    public InventoryContainer getInventories()
    {
        return inventories;
    }

}
