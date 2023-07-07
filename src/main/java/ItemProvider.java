import java.util.HashMap;

/** ez komunikál a felhasználókkal és az InventoryMover-nek tovább adja a feladatokat. */
public class ItemProvider {


    private InventoryContainer inventories;

    public ItemProvider(InventoryContainer inventories) {
        this.inventories = inventories;
    }

    public ItemReservation makeReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        /** ItemReservation-t csinál */
        ItemReservation newReservation = new ItemReservation(itemListCheck(inventories, itemsToReservate, senderId), senderId, recipientId);
        return newReservation;
    }

    public void putTransitBundleToTransitInventory(TransitBundle bundle) {
        inventories.getTransitInvertory()./** itt elakad a counter miatt */addBoundle(bundle);
    }

    public TransitBundle reserveAllAmount(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        /** elvégzi a piszkos munkát teljesen */
        reserveAllAmountHelper(itemsToReservate, senderId);
        makeReservation(itemsToReservate, senderId, recipientId);
        TransitBundle transitBundle = new TransitBundle(makeReservation(itemsToReservate, senderId, recipientId).getItems(), senderId, recipientId);
        putTransitBundleToTransitInventory(transitBundle);
        return transitBundle;
        }

    public void reserveAllAmountHelper(HashMap<Integer, Double> itemsToReservate, int senderId) {
        /** szóval, végigfoglalja, majd ellenőriz és ha nem jó akkor vissza állitja az eredetire a foglalt mennyiséget
         * kell e az if-ekhez és a for-hoz egyszerűsitő metódus? */
        HashMap<Integer, Double> originalList  = new HashMap<Integer, Double>();
        HashMap<Integer, Double> newList  = new HashMap<Integer, Double>();
        for (int itemId : itemsToReservate.keySet()) {
            originalList.put(itemId, inventories.getInventory(senderId).getItemAmount(itemId).getReservedAmount());
            newList.put(itemId, itemsToReservate.get(itemId) + originalList.get(itemId));
            inventories.getInventory(senderId).getItemAmount(itemId).reserveAmount(itemsToReservate.get(itemId));
            if (newList.get(itemId) != inventories.getInventory(senderId).getItemAmount(itemId).getReservedAmount()) {
                inventories.getInventory(senderId).getItemAmount(itemId).reserveAmount(0 - itemsToReservate.get(itemId));
            }
        }
    }

    public HashMap<Integer, Double> itemListCheck(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToReservate, int senderId) {
        /** ellenőrzi az szabad készletet és visszaad egy listát vagy hibát */
        HashMap<Integer, Double> gooditems  = new HashMap<Integer, Double>();
        HashMap<Integer, Double> missingItems  = new HashMap<Integer, Double>();
        for ( int key : itemsToReservate.keySet()) {
            if (!amountControlAmount(inventoryContainer.getInventory(senderId), key, itemsToReservate.get(key))) {
                missingItems.put(key, itemsToReservate.get(key));
            }
            else {
                gooditems.put(key, itemsToReservate.get(key));
            }
        }
         try {
            if (missingItems.size() >= 0 || !missingItems.isEmpty()) {
                    throw new ThereIsAMissingItem("Something went wrong!");
                }
            } catch (ThereIsAMissingItem e) {
        }
        return gooditems;
    }

    public boolean amountControlAmount(WarehouseInventory sender, int item, double amount) {
        /** segéd metódus az ellenőrzéshez */
        boolean result = false;
        if (sender.getItemAmount(item).getFreeAmount() >= amount ) {
            result = true;
        }
        return result;
    }

    public InventoryContainer getInventories() {
        return inventories;
    }

    /**
    public void sendInventoryToInventory(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToGet, int senderId, int recipientId) {
         //példa kedvéért maradt itt
        HashMap<Integer, Double> gooditems  = new HashMap<Integer, Double>();
        HashMap<Integer, Double> missingItems  = new HashMap<Integer, Double>();
        for ( int key : itemsToGet.keySet()) {
            if (!amountControlAmount(inventoryContainer.getInventory(senderId), key, itemsToGet.get(key))) {
                missingItems.put(key, itemsToGet.get(key));
            }
            else {
                gooditems.put(key, itemsToGet.get(key));
                //inventories.getInventory(senderId).getItemAmount(key).reserveAmount(10);
            }
        }
        ItemReservation newReservation = new ItemReservation(gooditems, senderId, recipientId);
        TransitBundle newBundle = new TransitBundle(newReservation.getItems(), newReservation.getSenderId(), newReservation.getReciverId());
        //külön forba kell írnom és egy külön metódusba
        inventories.getInventory(senderId).getItemAmount(5).reserveAmount(10);
    }
    */



}
