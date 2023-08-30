import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOfferTest
{
    HashMap<Integer, PurchaseAmount> items;
    Address addressOne;
    PurchaseOffer purchaseOffer;
    LocalDate date;
    Instant now;

    @BeforeEach
    public void setUp()
    {
        addressOne = new Address(1111, "Mygeto", "valami", "10", "2");
        items = new HashMap<>();
        date = LocalDate.of(2023, 12, 8);
        now = Instant.now();
        purchaseOffer = new PurchaseOffer( items, addressOne, date, 501);

    }

    @Test
    void getWarehouseId()
    {
        assertEquals(501, purchaseOffer.getReceivingWarehouseId());
    }

    @Test
    void getItems()
    {
        assertEquals(items, purchaseOffer.getItems());
    }

    @Test
    void getReciverAddres()
    {
        assertEquals(addressOne, purchaseOffer.getReceiverAddres());
    }

    @Test
    void getRecivingDate()
    {
        assertEquals(date, purchaseOffer.getReceivingDate());
    }

    @Test
    void getMakingDate()
    {
        assertEquals(now, purchaseOffer.getCreationDate());
    }


}