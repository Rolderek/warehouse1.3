/** termék/cikk */
public class Item {

    private int identifier;

    private String name;

    private String note;

    private String serialNumber;

    private double purchasePrice;

    private double sellPrice;

    public Item(int identifier, String name, String note) {
        this.identifier = identifier;
        this.name = name;
        this.note = note;
    }

    public Item(int identifier, String name, String note, String serialNumber) {
        this.identifier = identifier;
        this.name = name;
        this.note = note;
        this.serialNumber = serialNumber;
    }

    public Item(int identifier, String name, String note, String serialNumber, double purchasePrice, double sellPrice) {
        this.identifier = identifier;
        this.name = name;
        this.note = note;
        this.serialNumber = serialNumber;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }


    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return  "(" + "id: " + this.identifier + " ,"
                + "name: " + this.name + " ,"
                + "note: " +this.note +" ,"
                + "S/N: " +this.serialNumber + " ,"
                + "P.P: " +this.purchasePrice + " ,"
                + "S.P: " +this.sellPrice + ")";
    }

    @Override
    public int hashCode() {
        return this.identifier;
    }
}
