import junit.framework.TestCase;


public class ItemTest extends TestCase {

    public void testGetIdentifier() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag");
        assertEquals(100100100, pen.getIdentifier());
    }

    public void testSetIdentifier() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag");
        pen.setIdentifier(111111111);
        assertEquals(111111111, pen.getIdentifier());
    }

    public void testTestGetName() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag");
        assertEquals("Toll fekete, STABILO", pen.getName());
    }

    public void testTestSetName() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag");
        pen.setName("Fehér toll");
        assertEquals("Fehér toll", pen.getName());
    }

    public void testGetNote() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag");
        assertEquals("fekte műanyag stabilo toll 12db/csomag", pen.getNote());
    }

    public void testSetNote() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag");
        pen.setNote("lila");
        assertEquals("lila", pen.getNote());
    }

    public void testGetSerialNumber() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag",
                "QW1234Z6");
        assertEquals("QW1234Z6", pen.getSerialNumber());
    }

    public void testSetSerialNumber() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag",
                "QW1234Z6");
        pen.setSerialNumber("ABC7894");
        assertEquals("ABC7894", pen.getSerialNumber());
    }

    public void testGetPurchasePrice() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag",
                "QW1234Z6",
                5744.65,
                7891.70);
        assertEquals(5744.65, pen.getPurchasePrice());
    }

    public void testSetPurchasePrice() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag",
                "QW1234Z6",
                5744.65,
                7891.70);
        pen.setPurchasePrice(510.05);
        assertEquals(510.05, pen.getPurchasePrice());
    }

    public void testGetSellPrice() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag",
                "QW1234Z6",
                5744.65,
                7891.70);
        assertEquals(7891.70, pen.getSellPrice());
    }

    public void testSetSellPrice() {
        Item pen = new Item(100100100,
                "Toll fekete, STABILO",
                "fekte műanyag stabilo toll 12db/csomag",
                "QW1234Z6",
                5744.65,
                7891.70);
        pen.setSellPrice(700.20);
        assertEquals(700.20, pen.getSellPrice());
    }
}