import java.time.LocalDate;

public class PurchaseReorder
{

    public PurchaseOffer reorderByPurchaseOffer(PurchaseOffer purchaseOffer)
    {
        PurchaseOffer newOffer = new PurchaseOffer(
              purchaseOffer.getItems(),
              purchaseOffer.getReceiverAddres(),
              purchaseOffer.getReceivingDate(),
              purchaseOffer.getNote(),
              purchaseOffer.getReceivingWarehouseId()
        );
        return newOffer;
    }

    public PurchaseOffer reorderByPurchaseConfirmation(PurchaseConfirmation purchaseConfirmation)
    {
        PurchaseOffer newOffer = new PurchaseOffer(
                purchaseConfirmation.getConfirmedItems(),
                purchaseConfirmation.getPurchaseOffer().getReceiverAddres(),
                purchaseConfirmation.getPurchaseOffer().getReceivingDate(),
                purchaseConfirmation.getNote(),
                purchaseConfirmation.getReceivingWarehouseId()
        );
        return newOffer;
    }

    public PurchaseOffer reorderByPurchaseFinal(PurchaseFinal purchaseFinal)
    {
        PurchaseOffer newOffer = new PurchaseOffer(
                purchaseFinal.getItems(),
                purchaseFinal.getPurchaseConfirmation().getPurchaseOffer().getReceiverAddres(),
                purchaseFinal.getPurchaseConfirmation().getPurchaseOffer().getReceivingDate(),
                purchaseFinal.getNote(),
                purchaseFinal.getWarehouseId()
        );
        return newOffer;
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
