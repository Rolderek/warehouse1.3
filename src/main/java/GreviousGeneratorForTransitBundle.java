/**
 * folyamatosan növekvő számokat generál a TransitInventory-nak a TransitBundle-ök tárolásához.
 * Ezt a számot nem lehet kisebbre módositani
 */
public class GreviousGeneratorForTransitBundle
{

    private int counter;
    private GreviousType type;

    public GreviousGeneratorForTransitBundle(GreviousType type)
    {
        if (type == GreviousType.OFFER)
        {
            this.counter = 1;
        }
        if (type == GreviousType.CONFIRMATION)
        {
            this.counter = 10000;
        }
        if (type == GreviousType.FINAL)
        {
            this.counter = 100000;
        }
    }

    public GreviousGeneratorForTransitBundle()
    {
        this.counter = 0;
    }

    public int generateBundleId()
    {
        counter = counter + 1;
        return counter - 1;
    }

}
