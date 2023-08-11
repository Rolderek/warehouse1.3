public class PurchaseFinalIdGenerator {

    private int counter;

    public PurchaseFinalIdGenerator()
    {
        this.counter = 99999;
    }

    public int PurchaseFinalIdGenerator()
    {
        counter = counter + 1;
        return counter - 1;
    }
}
