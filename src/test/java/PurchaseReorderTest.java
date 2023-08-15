import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseReorderTest
{
    Address address;
    PurchaseAmount aAP;
    HashMap<Integer, PurchaseAmount> items;
    PurchaseContainer pc;
    PurchaseOffer po;
    PurchaseAmount newAAP;
    HashMap<Integer, PurchaseAmount> newItems;
    PurchaseConfirmation pC;
    PurchaseFinal pF;
    PurchaseReorder purchaseReorder;
    HashMap<Integer, PurchaseOffer> purchaseOffers;
    HashMap<Integer, PurchaseConfirmation> purchaseConfirmations;
    HashMap<Integer, PurchaseFinal> purchaseFinals;
    @BeforeEach
    public void setUp()
    {

        purchaseOffers = new HashMap<>();
        purchaseConfirmations = new HashMap<>();
        purchaseFinals = new HashMap<>();
        pc = new PurchaseContainer(purchaseOffers, purchaseConfirmations, purchaseFinals);
        address = new Address(3903, "Pososványoslép", "Kikötő utca", "01", "+36909999999");
        aAP = new PurchaseAmount(5.0, 10.0, Currency.EUR);
        items = new HashMap<>();
        items.put(9000, aAP);
        po = new PurchaseOffer(items, address, LocalDate.now(), "nothing",501);
        pc.addOffer(po);
        newAAP = new PurchaseAmount(4.0, 11.0, Currency.EUR);
        newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        pC = new PurchaseConfirmation(po.getId(), items, "Gyurikám!?", 501);
        pc.addConfirmation(pC);
        pF = new PurchaseFinal(10000, items, "Köszi Feri!", 501);
        pc.addFinal(pF);

    }

    @Test
    void purchaseReorderWithPurchaseOffer()
    {

    }

    @Test
    void purchaseReorderWithPurchaseConfirmation()
    {

    }

    @Test
    void purchaseReorderWithPurchaseFinal()
    {

    }

}