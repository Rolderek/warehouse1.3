/**
  * segéd osztály a PurchaseOffer-hez
  */

public class AmountAndPrice
{

    private double amount;

    private double price;

    private Currency currency;

    public AmountAndPrice(double amount, double price, Currency currency)
    {
        this.amount = amount;
        this.price = price;
        this.currency = currency;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public void setCurrency(Currency newCurrency)
    {
        currency = newCurrency;
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
