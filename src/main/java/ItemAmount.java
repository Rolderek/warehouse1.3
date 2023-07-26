import java.util.InputMismatchException;

/**
 * foglalt/szabad készlet mennyiségének a kezelése
 */
public class ItemAmount
{

    private double totalAmount;

    private double reservedAmount;

    public ItemAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public ItemAmount(double totalAmount, double reservedAmount)
    {
        this.totalAmount = totalAmount;
        this.reservedAmount = reservedAmount;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public double getReservedAmount()
    {
        return reservedAmount;
    }

    public void addAmount(double amount)
    {
        if (amount <= 0)
        {
            throw new InputMismatchException("amount must be positive");
        }
        totalAmount = totalAmount + amount;
    }

    public void reserveAmount(double amount)
    {
        if (amount <= 0)
        {
            throw new InputMismatchException("amount must be positive");
        }
        reservedAmount = reservedAmount + amount;
    }

    public double getFreeAmount()
    {
        return totalAmount - reservedAmount;
    }

    public void removeReservedAmount(double amount)
    {
        if (amount <= 0)
        {
            throw new InputMismatchException("amount must be positive");
        }
        if (reservedAmount < amount)
        {
            throw new InputMismatchException("maximum reserved amount can be removed");
        }
        reservedAmount = reservedAmount - amount;
    }

    public void sendAmount(double amount)
    {
        if (amount > getTotalAmount())
        {
            throw new InputMismatchException("There is not enough amount of that item.");
        }
        if (amount <= 0)
        {
            throw new InputMismatchException("amount must be positive");
        }
        totalAmount = totalAmount - amount;
        removeReservedAmount(amount);
    }


}
