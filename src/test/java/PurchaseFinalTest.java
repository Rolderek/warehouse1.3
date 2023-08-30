import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseFinalTest
{

    PurchaseConfirmation purchaseConfirmation;
    PurchaseFinal purchaseFinal;
    HashMap<Integer, PurchaseAmount> items;
    PurchaseOffer purchaseOffer;
    Address address;
    LocalDate date;
    Instant time;

    @BeforeEach
    public void setUp()
    {
        time = Instant.now();
        address = new Address(5, "a", "b", "c", "d");
        date = LocalDate.of(2023, 12, 8);
        items = new HashMap<>();
        items.put(1, new PurchaseAmount(5.0, 50, Currency.EUR));
        purchaseOffer = new PurchaseOffer(items, address, date, 501);
        purchaseConfirmation = new PurchaseConfirmation(1, items, "valami", 501);


    }

    @Test
    void purchaseFinalStatusJustOrder()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        assertEquals(PurchaseFinalStatus.JUSTORDER, purchaseFinal.getStatus());
    }

    @Test
    void getWarehouseId()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        assertEquals(501, purchaseFinal.getWarehouseId());
    }

    @Test
    void getPurchaseConfirmationId()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        assertEquals(10002, purchaseFinal.getPurchaseConfirmationId());
    }

    @Test
    void getPurchaseFinalId()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        assertEquals(100004, purchaseFinal.getPurchaseFinalId());
    }

    @Test
    void getItems()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        assertEquals(items, purchaseFinal.getItems());
    }

    @Test
    void getNote()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        assertEquals("valami", purchaseFinal.getNote());
    }

    @Test
    void setNote()
    {
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        purchaseFinal.setNote("Assetto Corsa");
        assertEquals("Assetto Corsa", purchaseFinal.getNote());
    }
}