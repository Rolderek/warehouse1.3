import java.util.ArrayList;
import java.util.HashMap;

/**
  * Tárolja az össze Purchase-t minden stádiumában.
  * Bármikor le lehet kérdezni melyik purchase hogy áll.
  */

public class PurchaseContainer
{

    /**
      * Purchase id és class kulcs/érték párokat tartalmaznak
      */

    private HashMap<Integer, PurchaseOffer> purchaseOffers;

    private HashMap<Integer, PurchaseConfirmation> purchaseConfirmations;

    private HashMap<Integer, PurchaseFinal> purchaseFinals;

    private PurchaseReorder purchaseReorder;

    public PurchaseContainer(HashMap<Integer, PurchaseOffer> purchaseOffers, HashMap<Integer, PurchaseConfirmation> purchaseConfirmations, HashMap<Integer, PurchaseFinal> purchaseFinals)
    {
        this.purchaseOffers = purchaseOffers;
        this.purchaseConfirmations = purchaseConfirmations;
        this.purchaseFinals = purchaseFinals;
    }

    public PurchaseReorder getPurchaseReorder()
    {
        return purchaseReorder;
    }

    public void addOffer(PurchaseOffer newOffer)
    {
        purchaseOffers.put(newOffer.getId(), newOffer);
    }

    public void addConfirmation(PurchaseConfirmation newConfirmation)
    {
        purchaseConfirmations.put(newConfirmation.getConfirmationId(), newConfirmation);
    }

    public void addFinal(PurchaseFinal newFinal)
    {
        purchaseFinals.put(newFinal.getPurchaseFinalId(), newFinal);
    }

    public PurchaseOffer getPurchaseOfferById(int id)
    {
        return purchaseOffers.get(id);
    }

    public PurchaseConfirmation getPurchaseConfirmationById(int id)
    {
        return purchaseConfirmations.get(id);
    }

    public PurchaseFinal getPurchaseFinalById(int id)
    {
        return purchaseFinals.get(id);
    }

    public HashMap<Integer, PurchaseOffer> getPurchaseOffers()
    {
        return purchaseOffers;
    }

    public HashMap<Integer, PurchaseConfirmation> getPurchaseConfirmations()
    {
        return purchaseConfirmations;
    }

    public HashMap<Integer, PurchaseFinal> getPurchaseFinals()
    {
        return purchaseFinals;
    }

    /**
      * itt lehet a HashMap jobb mivel nem indokolt az ArrayList
      * Bálintot megkérdezni!
      */
    public ArrayList<PurchaseFinal> getAllFinishedPurchaseFinal()
    {
        ArrayList<PurchaseFinal> finals = new ArrayList<>();
        for (int i : purchaseFinals.keySet())
        {
            if (purchaseFinals.get(i).getStatus() == PurchaseFinalStatus.RECIVED)
            {
                finals.add(purchaseFinals.get(i));
            }
        }
        return finals;
    }

    public ArrayList<PurchaseFinal> getAllNotFinishedPurchaseFinal()
    {
        ArrayList<PurchaseFinal> finals = new ArrayList<>();
        for (int i : purchaseFinals.keySet())
        {
            if (purchaseFinals.get(i).getStatus() == PurchaseFinalStatus.JUSTORDER)
            {
                finals.add(purchaseFinals.get(i));
            }
        }
        return finals;
    }

    public boolean isContainOffer(int id)
    {
        if (purchaseOffers.containsKey(id) == true)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public boolean isContainConfirmation(int id)
    {
        if (purchaseConfirmations.containsKey(id) == true)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public boolean isContainFinal(int id)
    {
        if (purchaseFinals.containsKey(id) == true)
        {
            return true;
        } else
        {
            return false;
        }
    }

}
