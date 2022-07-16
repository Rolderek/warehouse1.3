import java.util.HashMap;

public class TransitInvertory {

    private HashMap<Integer, TransitBundle> bundles;

    private GreviousGenerator counter;

    public TransitInvertory(HashMap<Integer, TransitBundle> bundles) {
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


}
