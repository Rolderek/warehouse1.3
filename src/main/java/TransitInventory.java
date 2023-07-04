import java.util.HashMap;
/** raktárak közötti mozgás naplója/tárolója */
public class TransitInventory implements Inventory {

    private HashMap<Integer, TransitBundle> bundles;

    private GreviousGenerator counter;

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
