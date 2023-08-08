import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TransitBundleTest
{

    HashMap<Integer, Double> items;
    HashMap<Integer, Double> anotherItems;
    TransitBundle tbOne;
    TransitBundle tbTwo;
    String note;
    String newNote;


    @BeforeEach
    public void setUp()
    {
        items = new HashMap<>();
        items.put(9000, 2.0);
        items.put(8000, 2.0);
        items.put(50, 2.0);
        anotherItems = new HashMap<>();
        anotherItems.put(9000, 4.0);
        anotherItems.put(8000, 4.0);
        anotherItems.put(50, 4.0);
        note = "abrakadabra";
        tbOne = new TransitBundle(items, 501, 102);
        tbTwo = new TransitBundle(anotherItems, 102, 501, note);
        newNote = "entyempentyem";
    }

    @Test
    void getItems()
    {
        assertEquals(items, tbOne.getItems());
    }

    @Test
    void getSenderId()
    {
        assertEquals(501, tbOne.getSenderId());
    }

    @Test
    void getRecipientId()
    {
        assertEquals(102, tbOne.getRecipientId());
    }

    @Test
    void getNotes()
    {
        assertEquals("abrakadabra", tbTwo.getNotes());
    }

    @Test
    void getStatus()
    {
        assertEquals(TranstiBundleStatus.RESERVED, tbOne.getStatus());
        assertEquals(TranstiBundleStatus.RESERVED, tbTwo.getStatus());
    }

    @Test
    void setStatusToSent()
    {
        tbOne.setStatusToSent();
        assertEquals(TranstiBundleStatus.SENT, tbOne.getStatus());
    }

    @Test
    void addNotesIfNoteNull()
    {
        tbOne.addNotes(newNote);
        assertEquals("entyempentyem", tbOne.getNotes());
    }

    @Test
    void addNotesIfNoteNotNull()
    {
        tbTwo.addNotes(newNote);
        String finalNote = note.concat("\n" + newNote);
        assertEquals(finalNote, tbTwo.getNotes());
    }
}