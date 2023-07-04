import java.util.HashMap;

/** ellenőrzi a küldeni kívánt item-ek készletét és csinál belőle egy transitInventoryn-t */
public class ItemProvider {


    private InventoryContainer inventories;
/** ellenőrzi a rendelni kivűnt termékeket és visszajelez a transitBundle-nek */
    public ItemProvider(InventoryContainer inventories) {
        this.inventories = inventories;
    }

    public void sendInventoryToInventory(InventoryContainer inventoryContainer, HashMap<Integer, Double> itemsToGet, int senderId, int recipientId) {
        // létrehoz egy foglalást a küldő raktárában, nem mehetsz minuszba ebben az esetben
        //beteszi a TransitInventoryba

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
        /** küldön forba kell írnom és egy külön metódusba */
        inventories.getInventory(senderId).getItemAmount(5).reserveAmount(10);
    }

    public boolean amountControlAmount(WarehouseInventory sender, int item, double amount) {
        boolean result = false;
        if (sender.getItemAmount(item).getFreeAmount() >= amount ) {
            result = true;
        }
        return result;
    }

}
