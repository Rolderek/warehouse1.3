import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierTest
{

    Address address;
    SupplierContact supplierContact;
    SupplierTermOfPayment supplierTermOfPayment;
    Supplier supplier;

    @BeforeEach
    public void setUp()
    {
        address = new Address(1, "a", "b", "0", "c");
        supplierContact = new SupplierContact("x", "e", "5", "megjegyzés");
        supplierTermOfPayment = new SupplierTermOfPayment("utalás");
        supplier = new Supplier(124, "LG", address, "megjegyzés", supplierContact, supplierTermOfPayment);
    }

    @Test
    void setTermOfPayment()
    {
        SupplierTermOfPayment newTerm = new SupplierTermOfPayment("új");
        supplier.setTermOfPayment(newTerm);
        assertEquals(newTerm, supplier.getTermOfPayment());
    }

    @Test
    void setNote()
    {
        supplier.setNote("nemtommi");
        assertEquals("nemtommi", supplier.getNote());
    }

    @Test
    void setContact()
    {
        SupplierContact newContact = new SupplierContact("Dezső", "gigachad@gmail.com", "06503332222");
        supplier.setContact(newContact);
        assertEquals(newContact, supplier.getContact());
    }

    @Test
    void setAddress()
    {
        Address anotherAddress = new Address(7, "i", "u", "z", "t");
        supplier.setAddress(anotherAddress);
        assertEquals(anotherAddress, supplier.getAddress());
    }

    @Test
    void setName()
    {
        supplier.setName("Lacesz");
        assertEquals("Lacesz", supplier.getName());
    }

    @Test
    void setId()
    {
        supplier.setId(3903);
        assertEquals(3903, supplier.getId());
    }

    @Test
    void getTermOfPayment()
    {
        assertEquals(supplierTermOfPayment, supplier.getTermOfPayment());
    }

    @Test
    void getContact()
    {
        assertEquals(supplierContact, supplier.getContact());
    }

    @Test
    void getNote()
    {
        assertEquals("megjegyzés", supplier.getNote());
    }

    @Test
    void getAddress()
    {
        assertEquals(address, supplier.getAddress());
    }

    @Test
    void getName()
    {
        assertEquals("LG", supplier.getName());
    }

    @Test
    void getId()
    {
        assertEquals(124, supplier.getId());
    }
}