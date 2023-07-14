import java.util.HashMap;
/** raktárak közötti mozgás naplója/tárolója */
public class TransitInventory implements Inventory {

    private HashMap<Integer, TransitBundle> bundles;

    private GreviousGenerator counter = new GreviousGenerator();

    public TransitInventory(HashMap<Integer, TransitBundle> bundles) {
        this.bundles = bundles;
    }

    public HashMap<Integer, TransitBundle> getBundles() {
        return bundles;
    }

    public int addBoundle(TransitBundle bundle) {
        int i = counter.generateBundleId();
        bundles.put(i, bundle);
        return i;
    }

    public void removeBundle(TransitBundle bundle) {
        for (int counter : bundles.keySet()) {
            if (bundles.get(counter) == bundle) {
                bundles.remove(counter);
            }
        }
    }

    @Override
    public HashMap<Integer, Double> getAllItemsOfWarehouse(int warehouseId) {
        for (TransitBundle transitBundle : bundles.values()) {
            if (transitBundle.getSenderId() == warehouseId) {
                return transitBundle.getItems();
            }
        }
        return new HashMap<Integer, Double>();
    }

}
