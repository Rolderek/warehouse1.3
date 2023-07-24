import java.util.ArrayList;

/** kiváltja az ItemReservation-t
 * tárolja az összes mozgást TransitBundle listában és ami még aktív azt a TransitInventory-ból ki lehet nyerni */
public class ItemMovement {

    private ArrayList<TransitBundle> wasMoving;

    public ItemMovement(ArrayList<TransitBundle> wasMoving) {
        this.wasMoving = wasMoving;
    }

    public ArrayList<TransitBundle> getWasMoving() {
        return wasMoving;
    }

    public void addBundleToWasMovingList(TransitBundle newBundle) {
        wasMoving.add(newBundle);
    }

    public void removeBundleFromWasMoving(TransitBundle transitBundle) {
        wasMoving.remove(transitBundle);
    }
}
