import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SupplierContainerTest
{
    SupplierContainer sc;
    Supplier supplierOne;
    Supplier supplierTwo;
    Supplier supplierThree;
    Address addressOne;
    Address addressTwo;
    SupplierTermOfPayment stopOne;
    SupplierTermOfPayment stopTwo;
    SupplierContact scOne;
    SupplierContact scTwo;
    HashMap<Integer, Supplier> suppliers;

    @BeforeEach
    public void setUp()
    {
        stopOne = new SupplierTermOfPayment("mordor");
        stopTwo = new SupplierTermOfPayment("gondor");
        scOne = new SupplierContact("Józis", "abraka@darbra.hu", "3");
        scTwo = new SupplierContact("Gizi", "dzson@malkovics.hu", "4");
        addressOne = new Address(1111, "Mygeto", "valami", "10", "2");
        addressTwo = new Address(2222, "Tatooine", "akármi", "20", "4");
        supplierOne = new Supplier(101, "LG", addressOne, scOne, stopOne);
        supplierTwo = new Supplier(303, "Samsung", addressTwo, scTwo, stopTwo);
        supplierThree = new Supplier(202, "izéke", addressTwo, scOne, stopTwo);
        suppliers = new HashMap<>();
        suppliers.put(101, supplierOne);
        suppliers.put(303, supplierTwo);
        sc = new SupplierContainer(suppliers);

    }
    @Test
    void getSuppliers()
    {
        assertEquals(suppliers, sc.getSuppliers());
    }

    @Test
    void addSuplier()
    {
        sc.addSuplier(supplierThree);
        assertEquals(3, sc.getSuppliers().size());
    }

    @Test
    void removeSupplier()
    {
        sc.removeSupplier(supplierOne);
        assertEquals(1, sc.getSuppliers().size());
    }
}