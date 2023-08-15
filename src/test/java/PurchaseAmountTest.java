import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest
{

    Currency currency;
    PurchaseAmount purchaseAmount;

    @BeforeEach
    public void setUp()
    {
    currency = Currency.EUR;
    purchaseAmount = new PurchaseAmount(10.0, 20.0, currency);
    }

    @Test
    void getCurrency()
    {
        assertEquals(Currency.EUR, purchaseAmount.getCurrency());
    }

    @Test
    void setCurrency()
    {
        purchaseAmount.setCurrency(Currency.AUD);
        assertEquals(Currency.AUD, purchaseAmount.getCurrency());
    }

    @Test
    void getAmount()
    {
        assertEquals(10.0, purchaseAmount.getAmount());
    }

    @Test
    void getPrice()
    {
        assertEquals(20.0, purchaseAmount.getPrice());
    }

    @Test
    void setAmount()
    {
        purchaseAmount.setAmount(30.0);
        assertEquals(30.0, purchaseAmount.getAmount());
    }

    @Test
    void setPrice()
    {
        purchaseAmount.setPrice(40.0);
        assertEquals(40.0, purchaseAmount.getPrice());
    }
}