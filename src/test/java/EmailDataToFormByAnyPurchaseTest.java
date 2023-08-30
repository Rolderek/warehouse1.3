import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EmailDataToFormByAnyPurchaseTest
{

    PurchaseOffer purchaseOffer;
    PurchaseConfirmation purchaseConfirmation;
    PurchaseFinal purchaseFinal;
    Supplier supplier;
    Address address;
    SupplierContact supplierContact;

    @Test
    void getPurchaseOffer()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);

        assertEquals(purchaseOffer, emailDataToFormByAnyPurchase.getPurchaseOffer());
    }

    @Test
    void getPurchaseOfferIfNull()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseConfirmation, "y");

        assertNull(emailDataToFormByAnyPurchase.getPurchaseOffer());
    }

    @Test
    void getPurchaseConfirmation()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseConfirmation, "y");

        assertEquals(purchaseConfirmation, emailDataToFormByAnyPurchase.getPurchaseConfirmation());
    }

    @Test
    void getPurchaseConfirmationIfNull()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseFinal);

        assertNull(emailDataToFormByAnyPurchase.getPurchaseConfirmation());
    }

    @Test
    void getPurchaseFinal()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseFinal, "y");

        assertEquals(purchaseFinal, emailDataToFormByAnyPurchase.getPurchaseFinal());
    }

    @Test
    void getPurchaseFinalIfNull()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseConfirmation, "y");

        assertNull(emailDataToFormByAnyPurchase.getPurchaseFinal());
    }

    @Test
    void getSupplier()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);

        assertEquals(supplier, emailDataToFormByAnyPurchase.getSupplier());
    }

    @Test
    void getNote()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer, "y");

        assertEquals("y", emailDataToFormByAnyPurchase.getNote());
    }

    @Test
    void getFrom()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);

        assertEquals("beégetett email az adott felhasználónak aki belép", emailDataToFormByAnyPurchase.getFrom());
    }

    @Test
    void getTo()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);

        assertEquals("b", emailDataToFormByAnyPurchase.getTo());
    }

    @Test
    void getSubject()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);

        assertEquals("Order PO2", emailDataToFormByAnyPurchase.getSubject());
    }

    @Test
    void getMessage()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);

        assertEquals("{}", emailDataToFormByAnyPurchase.getMessage());
    }

    @Test
    void setNote()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailDataToFormByAnyPurchase emailDataToFormByAnyPurchase = new EmailDataToFormByAnyPurchase(supplier, purchaseOffer);
        emailDataToFormByAnyPurchase.setNote("asd");

        assertEquals("asd", emailDataToFormByAnyPurchase.getNote());
    }
}