import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * egyszerűsitve
 */

class ItemMovementTest
{

    @Test
    void getWasMoving()
    {
        ArrayList<TransitBundle> list = new ArrayList<>();
        ItemMovement itemMovement = new ItemMovement(list);
        assertEquals(list, itemMovement.getWasMoving());
    }

    @Test
    void addBundleToWasMovingList()
    {
        ArrayList<TransitBundle> list = new ArrayList<>();
        ItemMovement itemMovement = new ItemMovement(list);
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 5.0);
        TransitBundle bundle = new TransitBundle(items, 501, 102);
        itemMovement.addBundleToWasMovingList(bundle);
        assertEquals(bundle, itemMovement.getWasMoving().get(0));
    }

    @Test
    void removeBundleFromWasMoving()
    {
        ArrayList<TransitBundle> list = new ArrayList<>();
        ItemMovement itemMovement = new ItemMovement(list);
        HashMap<Integer, Double> items = new HashMap<>();
        items.put(9000, 5.0);
        TransitBundle bundle = new TransitBundle(items, 501, 102);
        itemMovement.addBundleToWasMovingList(bundle);
        itemMovement.removeBundleFromWasMoving(bundle);
        assertTrue(itemMovement.getWasMoving().isEmpty());
    }
}