import java.util.ArrayList;

/**
 * History a korábbi raktárak közötti mozgásokról.
 * megjegyzés: nem aktív mozgások itt elérhetőek, a még aktívak a TransitInventory-ban vannak.
 */
public class ItemMovement
{

    private ArrayList<TransitBundle> wasMoving;

    public ItemMovement(ArrayList<TransitBundle> wasMoving)
    {
        this.wasMoving = wasMoving;
    }

    public ArrayList<TransitBundle> getWasMoving()
    {
        return wasMoving;
    }

    public void addBundleToWasMovingList(TransitBundle newBundle)
    {
        wasMoving.add(newBundle);
    }

    public void removeBundleFromWasMoving(TransitBundle transitBundle)
    {
        wasMoving.remove(transitBundle);
    }
}
