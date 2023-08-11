public class PurchaseConfirmationIdGenerator {

    private int counter;

    public PurchaseConfirmationIdGenerator()
    {
        this.counter = 9999;
    }

    public int PurchaseConfirmationIdGenerator()
    {
        counter = counter + 1;
        return counter - 1;
    }

}