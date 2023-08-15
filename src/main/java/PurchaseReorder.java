import java.time.LocalDate;

public class PurchaseReorder
{

    public PurchaseReorder(PurchaseOffer purchaseOffer)
    {
        PurchaseOffer newOffer = new PurchaseOffer(
              purchaseOffer.getItems(),
              purchaseOffer.getReceiverAddres(),
              purchaseOffer.getReceivingDate(),
              purchaseOffer.getNote(),
              purchaseOffer.getReceivingWarehouseId()
        );
    }

    public PurchaseReorder(PurchaseConfirmation purchaseConfirmation)
    {
        PurchaseConfirmation newConfirmation = new PurchaseConfirmation(
                purchaseConfirmation.getPurchaseOfferId(),
                purchaseConfirmation.getConfirmedItems(),
                purchaseConfirmation.getNote(),
                purchaseConfirmation.getReceivingWarehouseId()
        );
    }

    public PurchaseReorder(PurchaseFinal purchaseFinal)
    {
        PurchaseFinal newFinal = new PurchaseFinal(
                purchaseFinal.getPurchaseConfirmationId(),
                purchaseFinal.getItems(),
                purchaseFinal.getNote(),
                purchaseFinal.getWarehouseId()
        );
    }

    /**
    private PurchaseContainer purchaseContainer;

    public PurchaseReorder(PurchaseContainer purchaseContainer)
    {
        this.purchaseContainer = purchaseContainer;
    }

    public PurchaseContainer getPurchaseContainer()
    {
        return purchaseContainer;
    }

    public void setPurchaseContainer(PurchaseContainer newContainer)
    {
        purchaseContainer = newContainer;
    }

    public PurchaseOffer reOrderByPurchaseFinal(PurchaseFinal purchaseFinal)
    {
        int warehouseId = purchaseContainer.getPurchaseOfferById(purchaseContainer.getPurchaseConfirmationById(purchaseFinal.getPurchaseConfirmationId()).getPurchaseOfferId()).getReceivingWarehouseId();
        PurchaseOffer purchaseOffer = new PurchaseOffer(
                purchaseFinal.getItems(),
                purchaseContainer.getPurchaseOffers().get(purchaseContainer.getPurchaseConfirmations().get(purchaseFinal.getPurchaseConfirmationId()).getPurchaseOfferId()).getReceiverAddres(),
                LocalDate.now(),
                warehouseId);
        purchaseContainer.addOffer(purchaseOffer);
        return purchaseOffer;
    }

    public PurchaseOffer reOrderByPurchaseOffer(PurchaseOffer purchaseOffer)
    {
        PurchaseOffer newOffer = new PurchaseOffer(
                purchaseOffer.getItems(),
                purchaseOffer.getReceiverAddres(),
                purchaseOffer.getReceivingDate(),
                purchaseOffer.getNote(),
                purchaseOffer.getReceivingWarehouseId());
        purchaseContainer.addOffer(purchaseOffer);
        return newOffer;
    }

    public PurchaseOffer reOrderByPurchaseConfirmation(PurchaseConfirmation purchaseConfirmation)
    {
        PurchaseOffer purchaseOffer = new PurchaseOffer(
                purchaseConfirmation.getConfirmedItems(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getReceiverAddres(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getReceivingDate(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getNote(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getReceivingWarehouseId());
        purchaseContainer.addOffer(purchaseOffer);
        return purchaseOffer;
    }
     */
}
