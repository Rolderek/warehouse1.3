import java.util.HashMap;

/** ez komunikál a felhasználókkal és az InventoryMover-nek tovább adja a feladatokat. */
public class ItemProvider {


    private InventoryContainer inventories;

    public ItemProvider(InventoryContainer inventories) {
        this.inventories = inventories;
    }

    public void makeReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        /** ItemReservation-t csinál */
        if (itemListCheck(inventories, itemsToReservate, senderId) == true) {
            inventories.addReservation(itemsToReservate, senderId, recipientId);
        } else {
            System.out.println("There is not enough free maount of some item!");
        }
    }

    public void putTransitBundleToTransitInventory(TransitBundle bundle) {
        inventories.getTransitInvertory().addBoundle(bundle);
    }

    public void reserveAllAmount(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
        /** elvégzi a piszkos munkát teljesen */
        if (itemListCheck(inventories, itemsToReservate, senderId) == true) {
            reserveAllAmountHelper(itemsToReservate, senderId);
            makeReservation(itemsToReservate, senderId, recipientId);
            //TransitBundle transitBundle = new TransitBundle(itemsToReservate, senderId, recipientId);
            //putTransitBundleToTransitInventory(transitBundle); - ezt másnak kell csinálnia!
        } else {
           try  {
                throw new ThereIsAMissingItem("There is no enough free amount of some item/items");
            } catch (ThereIsAMissingItem e) {
               System.out.println(e);
           }
        }
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

Átdolgozni!
     public HashMap<Integer, Double> itemListCheck(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToReservate, int senderId) {
     /** ellenőrzi az szabad készletet és visszaad egy listát vagy hibát
     * foglal minuszba, de miért?
    HashMap<Integer, Double> gooditems = new HashMap<Integer, Double>();
    HashMap<Integer, Double> missingItems = new HashMap<Integer, Double>();
        for (int key : itemsToReservate.keySet()) {
        if (amountControlAmount(inventoryContainer.getInventory(senderId), key, itemsToReservate.get(key)) == true) {
            gooditems.put(key, itemsToReservate.get(key));
        } else {
            missingItems.put(key, itemsToReservate.get(key));
        }
    }
        try {
        if (missingItems.size() < 1 || missingItems.isEmpty()) {
            return gooditems;
        } else {
            throw new ThereIsAMissingItem("Something went wrong!");
        }
    } catch (ThereIsAMissingItem e) {
    }
        if (missingItems.isEmpty()) {
        return gooditems;
    } else {
        return missingItems;
    }
}

     public HashMap<Integer, Double> itemListCheck(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToReservate, int senderId) {
     /** ellenőrzi az szabad készletet és visszaad egy listát vagy hibát
     * foglal minuszba, de miért?
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
        return gooditems;
    } else {
        return new HashMap<Integer, Double>();
    }
}


     public TransitBundle reserveAllAmount(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
     /** elvégzi a piszkos munkát teljesen
    reserveAllAmountHelper(itemsToReservate, senderId);
    makeReservation(itemsToReservate, senderId, recipientId);
    TransitBundle transitBundle = new TransitBundle(itemsToReservate, senderId, recipientId);
    putTransitBundleToTransitInventory(transitBundle);
        return transitBundle;
}


     */



}
