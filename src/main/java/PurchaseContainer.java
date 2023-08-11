import java.util.HashMap;

/**
  * Tárolja az össze Purchase-t minden stádiumában.
  */

public class PurchaseContainer
{

    private PurchaseOfferIdGenerator offerIdGenerator;

    private PurchaseConfirmationIdGenerator confirmationIdGenerator;

    private PurchaseFinalIdGenerator finalIdGenerator;

    private HashMap<Integer, PurchaseOffer> purchaseOffers;

    private HashMap<Integer, PurchaseConfirmation> purchaseConfirmations;

    private HashMap<Integer, PurchaseFinal> purchaseFinals;

    public PurchaseContainer(HashMap<Integer, PurchaseOffer> purchaseOffers, HashMap<Integer, PurchaseConfirmation> purchaseConfirmations, HashMap<Integer, PurchaseFinal> purchaseFinals)
    {
        this.offerIdGenerator = new PurchaseOfferIdGenerator();
        this.confirmationIdGenerator = new PurchaseConfirmationIdGenerator();
        this.finalIdGenerator = new PurchaseFinalIdGenerator();
        this.purchaseOffers = purchaseOffers;
        this.purchaseConfirmations = purchaseConfirmations;
        this.purchaseFinals = purchaseFinals;
    }

    public void addOffer(PurchaseOffer newOffer)
    {
        purchaseOffers.put(offerIdGenerator.PurchaseOfferIdGenerator(), newOffer);
        /**
         * int size = purchaseOffers.size();
         *         int id = newOffer.getId();
         *         purchaseOffers.put(id, newOffer);
         *         if (purchaseOffers.size() != size + 1)
         *         {
         *             System.out.println("Something went wrong!");
         *         }
         */
    }

    public void addConfirmation(PurchaseConfirmation newConfirmation)
    {
        int id = newConfirmation.getConfirmationId();
        purchaseConfirmations.put(id, newConfirmation);
        if (!purchaseConfirmations.containsKey(id))
        {
            System.out.println("Cannot put new confirmation to purchaseConfirmations HasMap");
        }
        /**
         * int size = purchaseConfirmations.size();
         *         int id = newConfirmation.getConfirmationId();
         *         purchaseConfirmations.put(id, newConfirmation);
         *         if (size != size + 1)
         *         {
         *             System.out.println("Something went wrong!");
         *         }
         */
    }

    public void addFinal(PurchaseFinal newFinal)
    {
        purchaseFinals.put(finalIdGenerator.PurchaseFinalIdGenerator(), newFinal);
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
     * ezek lehet nem fognak kelleni:
     */
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
