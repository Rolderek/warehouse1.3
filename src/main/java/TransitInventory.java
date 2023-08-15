import java.util.HashMap;

/**
 * raktárak közötti elindított/feladott mozgás tárolója TransitBundle alapján
 * Itt a foglalt és küldés alatt lévő tételek vannak.
 */
public class TransitInventory implements Inventory
{

    private HashMap<Integer, TransitBundle> bundles;

    private GreviousGeneratorForTransitBundle counter = new GreviousGeneratorForTransitBundle();

    public TransitInventory(HashMap<Integer, TransitBundle> bundles)
    {
        this.bundles = bundles;
    }

    public HashMap<Integer, TransitBundle> getBundles()
    {
        return bundles;
    }

    public int addBoundle(TransitBundle bundle)
    {
        int i = counter.generateBundleId();
        bundles.put(i, bundle);
        return i;
    }

    public void removeBundle(TransitBundle bundle)
    {
        int i = 0;
        for (; bundles.get(i) == bundle; i++)
        {
        }
        if (i != -1)
        {
            bundles.remove(i);
        }
    }

    @Override
    public HashMap<Integer, Double> getAllItemsOfWarehouse(int warehouseId)
    {
        for (TransitBundle transitBundle : bundles.values())
        {
            if (transitBundle.getSenderId() == warehouseId)
            {
                return transitBundle.getItems();
            }
        }
        return new HashMap<Integer, Double>();
    }

}
