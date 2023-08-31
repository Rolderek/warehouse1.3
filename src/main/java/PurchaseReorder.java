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

}
