import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseConfirmationTest
{
    PurchaseConfirmation purchaseConfirmation;
    HashMap<Integer, PurchaseAmount> items;
    HashMap<Integer, PurchaseAmount> anotherItems;
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
        items.put(1, new PurchaseAmount(5.0, 50, Currency.EUR));
        items.put(2, new PurchaseAmount(3.0, 10, Currency.EUR));
        items.put(3, new PurchaseAmount(1.0, 5, Currency.EUR));
        anotherItems = new HashMap<>();
        anotherItems.put(4, new PurchaseAmount(1.0, 100, Currency.USD));
        purchaseOffer = new PurchaseOffer( items, address, date, 501);
        purchaseConfirmation = new PurchaseConfirmation(48, items, note, 501);
    }

    @Test
    void getWarehouseId()
    {
        assertEquals(501, purchaseConfirmation.getReceivingWarehouseId());
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
        assertEquals(9999, purchaseConfirmation.getConfirmationId());
    }

    @Test
    void getConfirmedItems()
    {
        assertEquals(items, purchaseConfirmation.getConfirmedItems());
    }
}