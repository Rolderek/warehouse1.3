import java.util.HashMap;

/**
  * Tárolja az össze Purchase-t minden stádiumában.
  */
public class PurchaseContainer {
    private HashMap<Integer, PurchaseOffer> purchaseOffers = new HashMap<>();

    private HashMap<Integer, PurchaseConfirmation> purchaseConfirmations = new HashMap<>();

    private HashMap<Integer, PurchaseFinal> purchaseFinals = new HashMap<>();

    public void addOffer(PurchaseOffer newOffer) {
        int id = newOffer.getId();
        purchaseOffers.put(id, newOffer);
    }

    public void addConfirmation(PurchaseConfirmation newConfirmation) {
        int id = newConfirmation.getConfirmationId();
        purchaseConfirmations.put(id, newConfirmation);
    }

    public void addFinal(PurchaseFinal newFinal) {
        int id = newFinal.getPurchaseFinalId();
        purchaseFinals.put(id, newFinal);
    }

    public PurchaseOffer getPurchaseOfferById(int id) {
        return purchaseOffers.get(id);
    }

    public PurchaseConfirmation getPurchaseConfirmationById(int id) {
        return purchaseConfirmations.get(id);
    }

    public PurchaseFinal getPurchaseFinalById(int id) {
        return purchaseFinals.get(id);
    }

    public HashMap<Integer, PurchaseOffer> getPurchaseOffers() {
        return purchaseOffers;
    }

    public HashMap<Integer, PurchaseConfirmation> getPurchaseConfirmations() {
        return purchaseConfirmations;
    }

    public HashMap<Integer, PurchaseFinal> getPurchaseFinals() {
        return purchaseFinals;
    }

    /**
     * ezek lehet nem fognak kelleni:
     */
    public boolean isContainOffer(int id) {
        if (purchaseOffers.containsKey(id) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isContainConfirmation(int id) {
        if (purchaseConfirmations.containsKey(id) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isContainFinal(int id) {
        if (purchaseFinals.containsKey(id) == true) {
            return true;
        } else {
            return false;
        }
    }

}
