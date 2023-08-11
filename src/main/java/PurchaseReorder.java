import java.time.LocalDate;

public class PurchaseReorder
{

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
        int warehouseId = purchaseContainer.getPurchaseOfferById(purchaseContainer.getPurchaseConfirmationById(purchaseFinal.getPurchaseConfirmationId()).getPurchaseOfferId()).getWarehouseId();
        PurchaseOffer purchaseOffer = new PurchaseOffer(
                purchaseFinal.getItems(),
                purchaseContainer.getPurchaseOffers().get(purchaseContainer.getPurchaseConfirmations().get(purchaseFinal.getPurchaseConfirmationId()).getPurchaseOfferId()).getReciverAddres(),
                LocalDate.now(),
                warehouseId);
        purchaseContainer.addOffer(purchaseOffer);
        return purchaseOffer;
    }

    public PurchaseOffer reOrderByPurchaseOffer(PurchaseOffer purchaseOffer)
    {
        PurchaseOffer newOffer = new PurchaseOffer(
                purchaseOffer.getItems(),
                purchaseOffer.getReciverAddres(),
                purchaseOffer.getRecivingDate(),
                purchaseOffer.getNote(),
                purchaseOffer.getWarehouseId());
        purchaseContainer.addOffer(purchaseOffer);
        return newOffer;
    }

    public PurchaseOffer reOrderByPurchaseConfirmation(PurchaseConfirmation purchaseConfirmation)
    {
        PurchaseOffer purchaseOffer = new PurchaseOffer(
                purchaseConfirmation.getConfirmedItems(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getReciverAddres(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getRecivingDate(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getNote(),
                purchaseContainer.getPurchaseOfferById(purchaseConfirmation.getPurchaseOfferId()).getWarehouseId());
        purchaseContainer.addOffer(purchaseOffer);
        return purchaseOffer;
    }
}
