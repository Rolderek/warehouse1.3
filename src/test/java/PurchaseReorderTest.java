import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseReorderTest
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
        aAP = new AmountAndPrice(5.0, 10.0, Currency.EUR);
        items = new HashMap<>();
        items.put(9000, aAP);
        po = new PurchaseOffer(items, address, LocalDate.now(), "nothing",501);
        pc.addOffer(po);
        newAAP = new AmountAndPrice(4.0, 11.0, Currency.EUR);
        newItems = new HashMap<>();
        newItems.put(9000, newAAP);
        pC = new PurchaseConfirmation(po.getId(), items, "Gyurikám!?", 501);
        pc.addConfirmation(pC);
        pF = new PurchaseFinal(9999, items, "Köszi Feri!", 501);
        pc.addFinal(pF);
        purchaseReorder = new PurchaseReorder(pc);

    }
    @Test
    void getPurchaseContainer()
    {
        assertEquals(pc, purchaseReorder.getPurchaseContainer());
    }

    @Test
    void setPurchaseContainer()
    {
        PurchaseContainer anotherContainer = new PurchaseContainer(purchaseOffers, purchaseConfirmations, purchaseFinals);
        purchaseReorder.setPurchaseContainer(anotherContainer);
        assertEquals(anotherContainer, purchaseReorder.getPurchaseContainer());
    }

    @Test
    void reOrderByPurchaseFinal()
    {
        purchaseReorder.reOrderByPurchaseFinal(pF);
        assertEquals(2, purchaseReorder.getPurchaseContainer().getPurchaseOffers().size());
        //pF.getPurchaseFinalId(), purchaseReorder.getPurchaseContainer().getPurchaseOffers().get(pF.getPurchaseFinalId()).getId()
    }

    @Test
    void reOrderByPurchaseOffer()
    {
        purchaseReorder.reOrderByPurchaseOffer(po);
        assertEquals(2, purchaseReorder.getPurchaseContainer().getPurchaseOffers().size());
    }

    @Test
    void reOrderByPurchaseConfirmation()
    {
    }

}