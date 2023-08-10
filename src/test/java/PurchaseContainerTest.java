import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseContainerTest
{
    Address address;
    AmountAndPrice aAP;
    HashMap<Integer, AmountAndPrice> items;
    PurchaseContainer pc;
    PurchaseOffer po;
    AmountAndPrice newAAP;
    HashMap<Integer, AmountAndPrice> newItems;
    PurchaseConfirmation pC;
    PurchaseFinal pF;
    @BeforeEach
    public void setUp()
    {
        address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        items = new HashMap<>();
        items.put(9000, aAP);
        pc = new PurchaseContainer();
        po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        newAAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        pC = new PurchaseConfirmation(1111, 2111, items, "Gyurikám!?", 501);
        pc.addConfirmation(pC);
        pF = new PurchaseFinal(2111, 3111, items, "Köszi Feri!", 501);
        pc.addFinal(pF);
    }
    @Test
    void addOffer()
    {
        assertEquals(1, pc.getPurchaseOffers().size());
    }

    @Test
    void addConfirmation()
    {
        assertEquals(1, pc.getPurchaseConfirmations().size());
    }

    @Test
    void addFinal()
    {
        assertEquals(1, pc.getPurchaseFinals().size());
    }

    @Test
    void getPurchaseOfferById()
    {
        assertTrue(po == pc.getPurchaseOfferById(1111));
    }

    @Test
    void getPurchaseConfirmationById()
    {
        assertTrue(pC == pc.getPurchaseConfirmationById(2111));
    }

    @Test
    void getPurchaseFinalById()
    {
        assertTrue(pF == pc.getPurchaseFinalById(3111));
    }

    @Test
    void isContainOffer()
    {
        assertTrue(true == pc.isContainOffer(1111));
    }

    @Test
    void isContainConfirmation()
    {
        assertTrue(true == pc.isContainConfirmation(2111));
    }

    @Test
    void isContainFinal()
    {
        assertTrue(true == pc.isContainFinal(3111));
    }
}