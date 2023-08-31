import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * kész 08.30
 * akkor fut le ha ezt az osztályt futtatom csak, más esetben a generátor miatt változnak a számok
 */
class PurchaseReorderTest
{

    PurchaseReorder purchaseReorder;

    @Test
    void purchaseReorderWithPurchaseOffer()
    {
        HashMap<Integer, PurchaseAmount> items = new HashMap<>();
        items.put(9000, new PurchaseAmount(5.0, 10.0, Currency.USD));
        PurchaseOffer po = new PurchaseOffer(items, new Address(2, "2", "2", "2", "2"), LocalDate.now(), 501);
        purchaseReorder = new PurchaseReorder();
        assertEquals(4, purchaseReorder.reorderByPurchaseOffer(po).getId());
    }

    @Test
    void purchaseReorderWithPurchaseConfirmation()
    {
        HashMap<Integer, PurchaseAmount> items = new HashMap<>();
        items.put(9000, new PurchaseAmount(5.0, 10.0, Currency.USD));
        PurchaseOffer po = new PurchaseOffer(items, new Address(2, "2", "2", "2", "2"), LocalDate.now(), 501);
        PurchaseConfirmation pC = new PurchaseConfirmation(po);
        purchaseReorder = new PurchaseReorder();
        purchaseReorder.reorderByPurchaseConfirmation(pC);
        assertEquals(7, purchaseReorder.reorderByPurchaseConfirmation(pC).getId());
    }

    @Test
    void purchaseReorderWithPurchaseFinal()
    {
        HashMap<Integer, PurchaseAmount> items = new HashMap<>();
        items.put(9000, new PurchaseAmount(5.0, 10.0, Currency.USD));
        PurchaseOffer po = new PurchaseOffer(items, new Address(2, "2", "2", "2", "2"), LocalDate.now(), 501);
        PurchaseConfirmation pC = new PurchaseConfirmation(po);
        PurchaseFinal pF = new PurchaseFinal(pC);
        purchaseReorder = new PurchaseReorder();
        purchaseReorder.reorderByPurchaseFinal(pF);
        assertEquals(2, purchaseReorder.reorderByPurchaseFinal(pF).getId());
    }

}