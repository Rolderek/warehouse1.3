import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountAndPriceTest
{

    Currency currency;
    AmountAndPrice amountAndPrice;

    @BeforeEach
    public void setUp()
    {
    currency = Currency.EUR;
    amountAndPrice = new AmountAndPrice(10.0, 20.0, currency);
    }

    @Test
    void getCurrency()
    {
        assertEquals(Currency.EUR, amountAndPrice.getCurrency());
    }

    @Test
    void setCurrency()
    {
        amountAndPrice.setCurrency(Currency.AUD);
        assertEquals(Currency.AUD, amountAndPrice.getCurrency());
    }

    @Test
    void getAmount()
    {
        assertEquals(10.0, amountAndPrice.getAmount());
    }

    @Test
    void getPrice()
    {
        assertEquals(20.0, amountAndPrice.getPrice());
    }

    @Test
    void setAmount()
    {
        amountAndPrice.setAmount(30.0);
        assertEquals(30.0, amountAndPrice.getAmount());
    }

    @Test
    void setPrice()
    {
        amountAndPrice.setPrice(40.0);
        assertEquals(40.0, amountAndPrice.getPrice());
    }
}