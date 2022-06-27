import junit.framework.TestCase;

public class AddressTest extends TestCase {

    public void testGetZipcode() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        assertEquals(1234,a.getZipcode());
    }

    public void testSetZipcode() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        a.setZipcode(5555);
        assertEquals(5555, a.getZipcode());
    }

    public void testGetCity() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        assertEquals("Pest", a.getCity());
    }

    public void testSetCity() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        a.setCity("Szerencs");
        assertEquals("Szerencs", a.getCity());
    }

    public void testGetStreet() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        assertEquals("Arany utca", a.getStreet());
    }

    public void testSetStreet() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        a.setStreet("valami");
        assertEquals("valami", a.getStreet());
    }

    public void testGetStreetNumber() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        assertEquals("12/A", a.getStreetNumber());
    }

    public void testSetStreetNumber() {
        Address a = new Address(
            1234,
            "Pest",
            "Arany utca",
            "12/A",
            "+3645123456");
        a.setStreetNumber("11");
        assertEquals("11", a.getStreetNumber());
    }

    public void testGetPhoneNumber() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        assertEquals("+3645123456", a.getPhoneNumber());
    }

    public void testSetPhoneNumber() {
        Address a = new Address(
                1234,
                "Pest",
                "Arany utca",
                "12/A",
                "+3645123456");
        a.setPhoneNumber("6");
        assertEquals("6", a.getPhoneNumber());
    }
}