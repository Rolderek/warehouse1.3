import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ItemPackageTest
{
    HashMap<Integer, Double> items;
    ItemPackage itemPackage;
    Instant time;

    @BeforeEach
    public void setUp()
    {
        items = new HashMap<>();
        items.put(1, 5.0);
        items.put(2, 4.0);
        items.put(3, 3.0);
        time = Instant.now();
        itemPackage = new ItemPackage(items);
    }

    @Test
    void getTime()
    {
        assertEquals(time, itemPackage.getTime());
    }

    @Test
    void getItems()
    {
        assertEquals(items, itemPackage.getItems());
    }

    @Test
    void setItems()
    {
        HashMap<Integer, Double> anotherItems = new HashMap<>();
        anotherItems.put(9, 400.0);
        itemPackage.setItems(anotherItems);
        assertEquals(anotherItems, itemPackage.getItems());
    }
}