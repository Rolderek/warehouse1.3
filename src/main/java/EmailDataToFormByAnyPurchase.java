public class EmailDataToFormByAnyPurchase
{

    private Supplier supplier;

    private PurchaseOffer purchaseOffer;

    private PurchaseConfirmation purchaseConfirmation;

    private PurchaseFinal purchaseFinal;

    private String note;

    private String from;

    private String to;

    private String subject;

    private String message;

    public EmailDataToFormByAnyPurchase(Supplier supplier, PurchaseOffer purchaseOffer)
    {
        this.supplier = supplier;
        this.purchaseOffer = purchaseOffer;
        this.to = supplier.getContact().getEmail();
        this.from = "beégetett email az adott felhasználónak aki belép";
        this.subject = "Order " + "PO" + purchaseOffer.getId();
        this.message = purchaseOffer.getItems().toString();
    }

    public EmailDataToFormByAnyPurchase(Supplier supplier, PurchaseOffer purchaseOffer, String note)
    {
        this.note = note;
        this.supplier = supplier;
        this.purchaseOffer = purchaseOffer;
        this.to = supplier.getContact().getEmail();
        this.from = "beégetett email az adott felhasználónak aki belép";
        this.subject = "Order " + "PO" + purchaseOffer.getId();
        this.message = purchaseOffer.getItems().toString();
    }

    public EmailDataToFormByAnyPurchase(Supplier supplier, PurchaseConfirmation purchaseConfirmation, String note)
    {
        this.note = note;
        this.supplier = supplier;
        this.purchaseConfirmation = purchaseConfirmation;
        this.to = supplier.getContact().getEmail();
        this.from = "beégetett email az adott felhasználónak aki belép";
        this.subject = "Order " + "PC" + purchaseConfirmation.getConfirmationId();
        this.message = purchaseConfirmation.getConfirmedItems().toString();
    }

    public EmailDataToFormByAnyPurchase(Supplier supplier, PurchaseConfirmation purchaseConfirmation)
    {
        this.supplier = supplier;
        this.purchaseConfirmation = purchaseConfirmation;
        this.to = supplier.getContact().getEmail();
        this.from = "beégetett email az adott felhasználónak aki belép";
        this.subject = "Order " + "PC" + purchaseConfirmation.getConfirmationId();
        this.message = purchaseConfirmation.getConfirmedItems().toString();
    }

    public EmailDataToFormByAnyPurchase(Supplier supplier, PurchaseFinal purchaseFinal)
    {
        this.supplier = supplier;
        this.purchaseFinal = purchaseFinal;
        this.to = supplier.getContact().getEmail();
        this.from = "beégetett email az adott felhasználónak aki belép";
        this.subject = "Order " + "PF" + purchaseFinal.getPurchaseFinalId();
        this.message = purchaseFinal.getItems().toString();
    }

    public EmailDataToFormByAnyPurchase(Supplier supplier, PurchaseFinal purchaseFinal, String note)
    {
        this.note = note;
        this.supplier = supplier;
        this.purchaseFinal = purchaseFinal;
        this.to = supplier.getContact().getEmail();
        this.from = "beégetett email az adott felhasználónak aki belép";
        this.subject = "Order " + "PF" + purchaseFinal.getPurchaseFinalId();
        this.message = purchaseFinal.getItems().toString();
    }

    public PurchaseOffer getPurchaseOffer()
    {
        return purchaseOffer;
    }

    public PurchaseConfirmation getPurchaseConfirmation()
    {
        return purchaseConfirmation;
    }

    public PurchaseFinal getPurchaseFinal()
    {
        return purchaseFinal;
    }

    public Supplier getSupplier()
    {
        return supplier;
    }

    public String getNote()
    {
        return note;
    }

    public String getFrom()
    {
        return from;
    }

    public String getTo()
    {
        return to;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getMessage()
    {
        return message;
    }

    public void setNote(String newNote)
    {
        note = newNote;
    }
}
