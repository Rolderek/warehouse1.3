import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{

    Item item;

    @BeforeEach
    public void setUp()
    {
        item = new Item(5000, "Perec", "sós", "1b987", 800.0, 1250.0);
    }
    @Test
    void getIdentifier()
    {
        assertEquals(5000, item.getIdentifier());
    }

    @Test
    void setIdentifier()
    {
        item.setIdentifier(6);
        assertEquals(6, item.getIdentifier());
    }

    @Test
    void getName()
    {
        assertEquals("Perec", item.getName());
    }

    @Test
    void setName()
    {
        item.setName("@");
        assertEquals("@", item.getName());
    }

    @Test
    void getNote()
    {
        assertEquals("sós", item.getNote());
    }

    @Test
    void setNote()
    {
        item.setNote("#");
        assertEquals("#", item.getNote());
    }

    @Test
    void getSerialNumber()
    {
        assertEquals("1b987", item.getSerialNumber());
    }

    @Test
    void setSerialNumber()
    {
        item.setSerialNumber("9");
        assertEquals("9", item.getSerialNumber());
    }

    @Test
    void getPurchasePrice()
    {
        assertEquals(800.0, item.getPurchasePrice());
    }

    @Test
    void setPurchasePrice()
    {
        item.setPurchasePrice(6.0);
        assertEquals(6.0, item.getPurchasePrice());
    }

    @Test
    void getSellPrice()
    {
        assertEquals(1250.0, item.getSellPrice());
    }

    @Test
    void setSellPrice()
    {
        item.setSellPrice(970.0);
        assertEquals(970.0, item.getSellPrice());
    }
}