/**
 * folyamatosan növekvő számokat generál a TransitInventory-nak a TransitBundle-ök tárolásához.
 * Ezt a számot nem lehet kisebbre módositani
 */
public class GreviousGenerator {

    private int counter;

    public GreviousGenerator() {
        this.counter = 0;
    }

    public int generateBundleId() {
        counter = counter + 1;
        return counter - 1;
    }

}
