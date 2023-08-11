import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseFinalTest {

    PurchaseConfirmation purchaseConfirmation;
    PurchaseFinal purchaseFinal;
    HashMap<Integer, AmountAndPrice> items;
    PurchaseOffer purchaseOffer;
    Address address;
    LocalDate date;
    Instant time;

    @BeforeEach
    public void setUp() {
        time = Instant.now();
        address = new Address(5, "a", "b", "c", "d");
        date = LocalDate.of(2023, 12, 8);
        items = new HashMap<>();
        items.put(1, new AmountAndPrice(5.0, 50, Currency.EUR));
        items.put(2, new AmountAndPrice(3.0, 10, Currency.EUR));
        items.put(3, new AmountAndPrice(1.0, 5, Currency.EUR));
        purchaseOffer = new PurchaseOffer(items, address, date, 501);
        purchaseConfirmation = new PurchaseConfirmation(1, items, "valami", 501);
        purchaseFinal = new PurchaseFinal(9999, items, "bombajó a duma", 501);

    }

    @Test
    void purchaseFinalStatusJustOrder()
    {
        assertEquals(PurchaseFinalStatus.JUSTORDER, purchaseFinal.getStatus());
    }

    @Test
    void getWarehouseId() {
        assertEquals(501, purchaseFinal.getWarehouseId());
    }

    @Test
    void setWarehouseId()
    {
        purchaseFinal.setWarehouseId(600);
        assertEquals(600, purchaseFinal.getWarehouseId());
    }

    @Test
    void getPurchaseConfirmationId()
    {
        assertEquals(48, purchaseFinal.getPurchaseConfirmationId());
    }

    @Test
    void getPurchaseFinalId()
    {
        assertEquals(26, purchaseFinal.getPurchaseFinalId());
    }

    @Test
    void setPurchaseFinalId()
    {
        purchaseFinal.setPurchaseFinalId(7);
        assertEquals(7, purchaseFinal.getPurchaseFinalId());
    }

    @Test
    void getItems()
    {
        assertEquals(items, purchaseFinal.getItems());
    }

    @Test
    void setItems()
    {
        HashMap<Integer, AmountAndPrice> anotherItems = new HashMap<>();
        anotherItems.put(2, new AmountAndPrice(3.0, 10, Currency.EUR));
        purchaseFinal.setItems(anotherItems);
        assertEquals(1, purchaseFinal.getItems().size());
    }

    @Test
    void getNote()
    {
        assertEquals("bombajó a duma", purchaseFinal.getNote());
    }

    @Test
    void setNote()
    {
        purchaseFinal.setNote("Assetto Corsa");
        assertEquals("Assetto Corsa", purchaseFinal.getNote());
    }
}