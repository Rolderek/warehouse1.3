/** ez komunikál a felhasználókkal és az InventoryMover-nek tovább adja a feladatokat. */
import java.time.Instant;
import java.util.HashMap;

public class ItemProvider {


    private InventoryContainer inventories;

    public ItemProvider(InventoryContainer inventories) {
        this.inventories = inventories;
    }

    public TransitBundle makeReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        /** ItemReservation-t csinál */
        if (itemListCheck(inventories, itemsToReservate, senderId) != true) {
            System.out.println("There is not enough free maount of some item!");
        }
        TransitBundle tb = new TransitBundle(itemsToReservate, senderId, recipientId);
        return tb;
    }

    public TransitBundle reserveAllAmountAndMakeTransitBundle(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        try  {
        if (itemListCheck(inventories, itemsToReservate, senderId) != true) {
            throw new ThereIsAMissingItem("There is no enough free amount of some item/items");
        }
        } catch (ThereIsAMissingItem e) {
            System.out.println(e);
            }
        reserveAllAmountHelper(itemsToReservate, senderId);
        return makeReservation(itemsToReservate, senderId, recipientId);
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

    public Boolean itemListCheck(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToReservate, int senderId) {
        /** ellenőrzi az szabad készletet és visszaad egy listát vagy hibát
         * foglal minuszba, de miért? */
        HashMap<Integer, Double> gooditems = new HashMap<Integer, Double>();
        HashMap<Integer, Double> missingItems = new HashMap<Integer, Double>();
        for (int key : itemsToReservate.keySet()) {
            if (amountControlAmount(inventoryContainer.getInventory(senderId), key, itemsToReservate.get(key)) == true) {
                gooditems.put(key, itemsToReservate.get(key));
            } else {
                missingItems.put(key, itemsToReservate.get(key));
            }
        }
        if (missingItems.isEmpty() || missingItems.size() < 0) {
            return true;
        } else {
            return false;
        }
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

}
