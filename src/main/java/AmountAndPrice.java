/**
  * segéd osztály a PurchaseOffer-hez
  */

public class AmountAndPrice {

    private double amount;

    private double price;

    public AmountAndPrice(double amount, double price)
    {
        this.amount = amount;
        this.price = price;
    }

    public double getAmount()
    {
        return amount;
    }

    public double getPrice()
    {
        return price;
    }

    public void setAmount(double newAmaunt)
    {
        amount = newAmaunt;
    }

    public void setPrice(double newPrice)
    {
        price = newPrice;
    }


}
