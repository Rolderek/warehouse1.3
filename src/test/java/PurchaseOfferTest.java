import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOfferTest
{
    HashMap<Integer, AmountAndPrice> items;
    Address addressOne;
    AmountAndPrice amountAndPriceOne;
    AmountAndPrice amountAndPriceTwo;
    PurchaseOffer purchaseOffer;
    LocalDate date;
    Instant now;

    @BeforeEach
    public void setUp()
    {
        addressOne = new Address(1111, "Mygeto", "valami", "10", "2");
        amountAndPriceOne = new AmountAndPrice(5.0, 500.0, Currency.USD);
        amountAndPriceTwo = new AmountAndPrice(3.0, 120, Currency.USD);
        items = new HashMap<>();
        date = LocalDate.of(2023, 12, 8);
        items.put(0, amountAndPriceOne);
        items.put(1, amountAndPriceTwo);
        now = Instant.now();
        purchaseOffer = new PurchaseOffer(54321, items, addressOne, date, 501);

    }

    @Test
    void getWarehouseId()
    {
        assertEquals(501, purchaseOffer.getWarehouseId());
    }

    @Test
    void setWarehouseId()
    {
        purchaseOffer.setWarehouseId(6);
        assertEquals(6, purchaseOffer.getWarehouseId());
    }

    @Test
    void getId()
    {
        assertEquals(54321, purchaseOffer.getId());
    }

    @Test
    void getItems()
    {
        assertEquals(items, purchaseOffer.getItems());
    }

    @Test
    void getReciverAddres()
    {
        assertEquals(addressOne, purchaseOffer.getReciverAddres());
    }

    @Test
    void getRecivingDate()
    {
        assertEquals(date, purchaseOffer.getRecivingDate());
    }

    @Test
    void getMakingDate()
    {
        assertEquals(now, purchaseOffer.getMakingDate());
    }
}