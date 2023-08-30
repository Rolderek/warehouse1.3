import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EmailFormPurchaseTest
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
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);

        assertEquals(purchaseOffer, emailFormPurchase.getPurchaseOffer());
    }

    @Test
    void getPurchaseOfferIfNull()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseConfirmation, "y");

        assertNull(emailFormPurchase.getPurchaseOffer());
    }

    @Test
    void getPurchaseConfirmation()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseConfirmation, "y");

        assertEquals(purchaseConfirmation, emailFormPurchase.getPurchaseConfirmation());
    }

    @Test
    void getPurchaseConfirmationIfNull()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseFinal);

        assertNull(emailFormPurchase.getPurchaseConfirmation());
    }

    @Test
    void getPurchaseFinal()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        purchaseFinal = new PurchaseFinal(purchaseConfirmation);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseFinal, "y");

        assertEquals(purchaseFinal, emailFormPurchase.getPurchaseFinal());
    }

    @Test
    void getPurchaseFinalIfNull()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        purchaseConfirmation = new PurchaseConfirmation(purchaseOffer);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseConfirmation, "y");

        assertNull(emailFormPurchase.getPurchaseFinal());
    }

    @Test
    void getSupplier()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);

        assertEquals(supplier, emailFormPurchase.getSupplier());
    }

    @Test
    void getNote()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer, "y");

        assertEquals("y", emailFormPurchase.getNote());
    }

    @Test
    void getFrom()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);

        assertEquals("beégetett email az adott felhasználónak aki belép", emailFormPurchase.getFrom());
    }

    @Test
    void getTo()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);

        assertEquals("b", emailFormPurchase.getTo());
    }

    @Test
    void getSubject()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);

        assertEquals("Order PO2", emailFormPurchase.getSubject());
    }

    @Test
    void getMessage()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);

        assertEquals("{}", emailFormPurchase.getMessage());
    }

    @Test
    void setNote()
    {
        supplierContact = new SupplierContact("a", "b", "c");
        supplier = new Supplier(1, "a", address ,"c" ,supplierContact, new SupplierTermOfPayment("a"));
        purchaseOffer = new PurchaseOffer(new HashMap<>(), address, LocalDate.now(), "x", 501);
        EmailFormPurchase emailFormPurchase = new EmailFormPurchase(supplier, purchaseOffer);
        emailFormPurchase.setNote("asd");

        assertEquals("asd", emailFormPurchase.getNote());
    }
}