/** ezt kell használnom a WarehouseInventory-knál */
import java.util.HashMap;

public class ItemPackage {

    /** tárolja foglalásonként milyen cikkek kerültek a csomagba  */
    private HashMap<ItemReservation, HashMap<Integer, Double>> itemsByReservations;


public ItemPackage(HashMap<ItemReservation, HashMap<Integer, Double>> itemsByReservations) {
    this.itemsByReservations = itemsByReservations;
}

public HashMap<ItemReservation, HashMap<Integer, Double>> getItemsByReservations() {
    return itemsByReservations;
}

public void setItemsByReservations(HashMap<ItemReservation, HashMap<Integer, Double>> newItemsByReservations) {
    itemsByReservations = newItemsByReservations;
}

}
