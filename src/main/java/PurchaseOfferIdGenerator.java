public class PurchaseOfferIdGenerator {

    private int counter;

    public PurchaseOfferIdGenerator()
    {
        this.counter = 0;
    }

    public int PurchaseOfferIdGenerator()
    {
        counter = counter + 1;
        return counter - 1;
    }

}