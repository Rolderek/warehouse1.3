import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ItemMovementTest {

    ItemMovement itemMovement;
    TransitBundle tb1;
    TransitBundle tb2;
    TransitBundle tb3;
    TransitBundle tb4;
    Item itemOne;
    Item itemTwo;
    Item itemThree;
    ItemAmount itemThreeAmountW3;
    ItemAmount itemThreeAmountW2;
    ItemAmount itemTwoAmountW3;
    ItemAmount itemTwoAmountW2;
    ItemAmount itemOneAmountW3;
    ItemAmount itemOneAmountW2;
    ItemAmount itemOneAmount;
    ItemAmount itemTwoAmount;
    ItemAmount itemThreeAmount;
    HashMap<Integer, ItemAmount> items;
    HashMap<Integer, ItemAmount> itemsW2;
    HashMap<Integer, ItemAmount> itemsW3;
    HashMap<Integer, Double> itemsToSend1;
    ArrayList<TransitBundle> tbList = new ArrayList<>();

    @BeforeEach
    public void setUp()
    {
        /** address készités */
        Address address1 = new Address(3903, "Bekecs", "Tűzoltó út", "28", "06901123456");
        Address address2 = new Address(4000, "Debrecen", "Fing utca", "3", "11111111111");

        itemOne = new Item(9000, "Toll", "sima kék", "XZ789", 700.50, 900.50);
        itemTwo = new Item(8000, "izéke", "tulajdonság", "MZ/X", 500, 680);
        itemThree = new Item(50, "bigyóka", "tulajdonság", "AH64", 100, 127);
        /**
         * itemAmount készités
         */
        itemOneAmount = new ItemAmount(10.0, 0.0);
        itemOneAmountW3 = new ItemAmount(1.0, 0.0);
        itemTwoAmount = new ItemAmount(9.0, 0.0);
        itemTwoAmountW3 = new ItemAmount(1.0, 0.0);
        itemThreeAmount = new ItemAmount(8.0, 0.0);
        itemThreeAmountW3 = new ItemAmount(1.0, 0.0);
        itemOneAmountW2 = new ItemAmount(5.0, 0.0);
        itemTwoAmountW2 = new ItemAmount(5.0, 0.0);
        itemThreeAmountW2 = new ItemAmount(5.0, 0.0);
        /**
         * item itemAmount párok bepakolása a raktárakba
         */
        items = new HashMap<Integer, ItemAmount>();
        items.put(itemOne.getIdentifier(), itemOneAmount);
        items.put(itemTwo.getIdentifier(), itemTwoAmount);
        items.put(itemThree.getIdentifier(), itemThreeAmount);

        itemsW2 = new HashMap<Integer, ItemAmount>();
        itemsW2.put(itemOne.getIdentifier(), itemOneAmountW2);
        itemsW2.put(itemTwo.getIdentifier(), itemTwoAmountW2);
        itemsW2.put(itemThree.getIdentifier(), itemThreeAmountW2);

        itemsW3 = new HashMap<Integer, ItemAmount>();
        itemsW3.put(itemOne.getIdentifier(), itemOneAmountW3);
        itemsW3.put(itemTwo.getIdentifier(), itemTwoAmountW3);
        itemsW3.put(itemThree.getIdentifier(), itemThreeAmountW3);

        /** raktárak létrehozása */
        WarehouseInventory w1 = new WarehouseInventory(501, "Központ", address1, items);
        WarehouseInventory w2 = new WarehouseInventory(102, "Dábrechen", address2, itemsW2);

        itemsToSend1 = new HashMap<Integer, Double>();
        itemsToSend1.put(itemOne.getIdentifier(), 3.0);
        itemsToSend1.put(itemTwo.getIdentifier(), 2.0);
        itemsToSend1.put(itemThree.getIdentifier(), 1.0);

        tb1 = new TransitBundle(itemsToSend1, 501, 102);
        tb2 = new TransitBundle(itemsToSend1, 102, 501);
        tb3 = new TransitBundle(itemsToSend1, 501, 102);

        tbList.add(tb1);
        tbList.add(tb2);
        tbList.add(tb3);

        itemMovement = new ItemMovement(tbList);
    }

    @Test
    void getWasMoving()
    {
       assertEquals(3, itemMovement.getWasMoving().size());
    }

    @Test
    void addBundleToWasMovingList()
    {
        itemMovement.addBundleToWasMovingList(tb3);
        assertEquals(4, itemMovement.getWasMoving().size());
    }

    @Test
    void removeBundleFromWasMoving()
    {
        itemMovement.removeBundleFromWasMoving(tb2);
        assertEquals(2, itemMovement.getWasMoving().size());
    }
}