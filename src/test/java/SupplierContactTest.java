import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierContactTest
{

    SupplierContact scOne;
    SupplierContact scTwo;
    SupplierContact scThree;

    @BeforeEach
    public void setUp()
    {
        scOne = new SupplierContact("Feri", "asd@gmail.com", "22222222");
        scTwo = new SupplierContact("Józsi", "hvg@gmail.com", "99999999");
        scThree = new SupplierContact("Aranka", "ark@gmail.com", "55555555");
    }
    @Test
    void getName()
    {
        assertEquals("Feri", scOne.getName());
        assertEquals("Józsi", scTwo.getName());
        assertEquals("Aranka", scThree.getName());
    }

    @Test
    void getEmail()
    {
        assertEquals("asd@gmail.com", scOne.getEmail());
        assertEquals("hvg@gmail.com", scTwo.getEmail());
        assertEquals("ark@gmail.com", scThree.getEmail());
    }

    @Test
    void getNote()
    {
        assertEquals(null, scOne.getNote());
    }

    @Test
    void setNote()
    {
        scOne.setNote("Ibéria");
        assertEquals("Ibéria", scOne.getNote());
    }

    @Test
    void setPhoneNumber()
    {
        scTwo.setPhoneNumber("06909090900");
        assertEquals("06909090900", scTwo.getPhoneNumber());
    }

    @Test
    void setEmail()
    {
        scThree.setEmail("irgumburgum");
        assertEquals("irgumburgum", scThree.getEmail());
    }

    @Test
    void setName()
    {
        scOne.setName("Gizike");
        assertEquals("Gizike", scOne.getName());
    }
}