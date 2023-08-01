import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseContainerTest
{

    @Test
    void addOffer()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        assertEquals(1, pc.getPurchaseOffers().size());
    }

    @Test
    void addConfirmation()
    {
        AmountAndPrice aAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseConfirmation pC = new PurchaseConfirmation(1111, 2111, items, "Gyurikám!?");
        pc.addConfirmation(pC);
        assertEquals(1, pc.getPurchaseConfirmations().size());
    }

    @Test
    void addFinal()
    {
        AmountAndPrice aAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseFinal pF = new PurchaseFinal(2111, 3111, items, "Köszi Feri!");
        pc.addFinal(pF);
        assertEquals(1, pc.getPurchaseFinals().size());
    }

    @Test
    void getPurchaseOfferById()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        assertTrue(po == pc.getPurchaseOfferById(1111));
        assertTrue(po == pc.getPurchaseOfferById(1112));

    }

    @Test
    void getPurchaseConfirmationById()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        AmountAndPrice newAAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        PurchaseConfirmation pC = new PurchaseConfirmation(1111, 2111, items, "Gyurikám!?");
        pc.addConfirmation(pC);
        assertTrue(pC == pc.getPurchaseConfirmationById(2111));
        assertTrue(pC == pc.getPurchaseConfirmationById(2112));
    }

    @Test
    void getPurchaseFinalById()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        AmountAndPrice newAAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        PurchaseConfirmation pC = new PurchaseConfirmation(1111, 2111, items, "Gyurikám!?");
        pc.addConfirmation(pC);
        PurchaseFinal pF = new PurchaseFinal(2111, 3111, items, "Köszi Feri!");
        pc.addFinal(pF);
        assertTrue(pF == pc.getPurchaseFinalById(3111));
        assertFalse(pF == pc.getPurchaseFinalById(3112));
    }

    @Test
    void isContainOffer()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        assertTrue(true == pc.isContainOffer(1111));
    }

    @Test
    void isContainConfirmation()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        AmountAndPrice newAAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        PurchaseConfirmation pC = new PurchaseConfirmation(1111, 2111, items, "Gyurikám!?");
        pc.addConfirmation(pC);
        assertTrue(true == pc.isContainConfirmation(2111));
        assertFalse(true == pc.isContainConfirmation(2112));
    }

    @Test
    void isContainFinal()
    {
        Address address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        AmountAndPrice aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> items = new HashMap<>();
        items.put(9000, aAP);
        PurchaseContainer pc = new PurchaseContainer();
        PurchaseOffer po = new PurchaseOffer(1111,  items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        AmountAndPrice newAAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        HashMap<Integer, AmountAndPrice> newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        PurchaseConfirmation pC = new PurchaseConfirmation(1111, 2111, items, "Gyurikám!?");
        pc.addConfirmation(pC);
        PurchaseFinal pF = new PurchaseFinal(2111, 3111, items, "Köszi Feri!");
        pc.addFinal(pF);
        assertTrue(true == pc.isContainFinal(3111));
        assertFalse(false == pc.isContainFinal(3111));
        assertEquals(true, pc.isContainFinal(3111));
    }
}