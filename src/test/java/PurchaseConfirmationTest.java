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

    @Test
    void getPurchaseOffer()
    {
        PurchaseConfirmation newConfirmation = new PurchaseConfirmation(purchaseOffer);
        assertEquals(purchaseOffer, newConfirmation.getPurchaseOffer());
    }
}