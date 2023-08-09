import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseConfirmationTest
{
    PurchaseConfirmation purchaseConfirmation;
    HashMap<Integer, AmountAndPrice> items;
    HashMap<Integer, AmountAndPrice> anotherItems;
    PurchaseOffer purchaseOffer;
    Address address;
    LocalDate date;
    Instant time;
    String note;

    @BeforeEach
    public void setUp()
    {
        note = "valami";
        time = Instant.now();
        address = new Address(5, "a", "b", "c", "d");
        date = LocalDate.of(2023, 12, 8);
        items = new HashMap<>();
        items.put(1, new AmountAndPrice(5.0, 50, Currency.EUR));
        items.put(2, new AmountAndPrice(3.0, 10, Currency.EUR));
        items.put(3, new AmountAndPrice(1.0, 5, Currency.EUR));
        anotherItems = new HashMap<>();
        anotherItems.put(4, new AmountAndPrice(1.0, 100, Currency.USD));
        purchaseOffer = new PurchaseOffer(48, items, address, date, 501);
        purchaseConfirmation = new PurchaseConfirmation(48, 31, items, note);
    }

    @Test
    void getNote()
    {
        assertEquals(note, purchaseConfirmation.getNote());
    }

    @Test
    void setNote()
    {
        purchaseConfirmation.setNote("a");
        assertEquals("a", purchaseConfirmation.getNote());
    }

    @Test
    void getPurchaseOfferId()
    {
        assertEquals(48, purchaseConfirmation.getPurchaseOfferId());
    }

    @Test
    void getConfirmationId()
    {
        assertEquals(31, purchaseConfirmation.getConfirmationId());
    }

    @Test
    void setConfirmationId()
    {
        purchaseConfirmation.setConfirmationId(2);
        assertEquals(2, purchaseConfirmation.getConfirmationId());
    }

    @Test
    void getConfirmedItems()
    {
        assertEquals(items, purchaseConfirmation.getConfirmedItems());
    }

    @Test
    void setConfirmedItems()
    {
        purchaseConfirmation.setConfirmedItems(anotherItems);
        assertEquals(anotherItems, purchaseConfirmation.getConfirmedItems());
    }
}