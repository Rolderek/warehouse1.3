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
