import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Bálinttal átnézni kell e röviditeni
 */
class PurchaseContainerTest
{
    HashMap<Integer, PurchaseOffer> purchaseOffers;
    HashMap<Integer, PurchaseConfirmation> purchaseConfirmations;
    HashMap<Integer, PurchaseFinal> purchaseFinals;
    PurchaseOfferIdGenerator offerIdGenerator;
    PurchaseConfirmationIdGenerator confirmationIdGenerator;
    PurchaseFinalIdGenerator finalIdGenerator;
    Address address;
    PurchaseAmount aAP;
    HashMap<Integer, PurchaseAmount> items;
    PurchaseContainer pc;
    PurchaseOffer po;
    PurchaseAmount newAAP;
    HashMap<Integer, PurchaseAmount> newItems;
    PurchaseConfirmation pC;
    PurchaseFinal pF;
    PurchaseContainer purchaseContainer;

    @BeforeEach
    public void setUp()
    {
        offerIdGenerator = new PurchaseOfferIdGenerator();
        confirmationIdGenerator = new PurchaseConfirmationIdGenerator();
        finalIdGenerator = new PurchaseFinalIdGenerator();
        purchaseOffers = new HashMap<>();
        purchaseConfirmations = new HashMap<>();
        purchaseFinals = new HashMap<>();
        pc = new PurchaseContainer(purchaseOffers, purchaseConfirmations, purchaseFinals);
        address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        aAP = new PurchaseAmount(5.0, 10.0, Currency.EUR);
        items = new HashMap<>();
        items.put(9000, aAP);
        po = new PurchaseOffer(items, address, LocalDate.now(), 501);
        pc.addOffer(po);
        newAAP = new PurchaseAmount(4.0, 11.0, Currency.EUR);
        newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        pC = new PurchaseConfirmation(1, items, "Gyurikám!?", 501);
        pc.addConfirmation(pC);
        pF = new PurchaseFinal(9999, items, "Köszi", 501);
        pc.addFinal(pF);
        purchaseOffers.put(offerIdGenerator.PurchaseOfferIdGenerator(), po);
        purchaseConfirmations.put(confirmationIdGenerator.PurchaseConfirmationIdGenerator(), pC);
        purchaseFinals.put(finalIdGenerator.PurchaseFinalIdGenerator(), pF);
        purchaseContainer = new PurchaseContainer(purchaseOffers, purchaseConfirmations, purchaseFinals);
    }
    @Test
    void addOffer()
    {
        assertEquals(2, pc.getPurchaseOffers().size());
    }

    @Test
    void addConfirmation()
    {
        assertEquals(2, pc.getPurchaseConfirmations().size());
    }

    @Test
    void addFinal()
    {
        assertEquals(2, pc.getPurchaseFinals().size());
    }

    @Test
    void getPurchaseOfferById()
    {
        assertTrue(po == pc.getPurchaseOfferById(0));
    }

    @Test
    void getPurchaseConfirmationById()
    {
        assertTrue(pC == pc.getPurchaseConfirmationById(9999));
    }

    @Test
    void getPurchaseFinalById()
    {
        assertTrue(pF == pc.getPurchaseFinalById(99999));
    }

    @Test
    void isContainOffer()
    {
        assertTrue(true == pc.isContainOffer(0));
    }

    @Test
    void isContainConfirmation()
    {
        assertTrue(true == pc.isContainConfirmation(9999));
    }

    @Test
    void isContainFinal()
    {
        assertTrue(true == pc.isContainFinal(99999));
    }

    @Test
    void getAllFinishedPurchaseFinal()
    {
        purchaseFinals.get(99999).setStatusToRecived();
        assertEquals(2, purchaseContainer.getAllFinishedPurchaseFinal().size());
    }

    @Test
    void getAllNotFinishedPurchaseFinal()
    {
        assertEquals(2, purchaseContainer.getAllNotFinishedPurchaseFinal().size());
    }
}