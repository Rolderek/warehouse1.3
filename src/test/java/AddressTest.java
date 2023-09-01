import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.restlet.resource.ClientResource;
import org.json.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest
{

    Address address;

    @BeforeEach
    public void setUp()
    {
     address = new Address(3903, "Bekecs", "Tűzoltó út", "28", "+36901112222");
    }

    @Test
    void request()
    {
        String apiKey = "";
        ClientResource resource = new ClientResource("http://data.fixer.io/api/latest?access_key="+ apiKey +"&symbols=HUF%2CUSD%2CGBP");
        try
        {
            String response = resource.get().getText();
            System.out.println(response);
            JSONObject responseObject = new JSONObject(response);
            System.out.println("Base: " + responseObject.get("base"));
            System.out.println("USD: " + ((JSONObject)responseObject.get("rates")).get("USD"));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getZipcode()
    {
        assertEquals(3903, address.getZipcode());
    }

    @Test
    void setZipcode()
    {
        address.setZipcode(5);
        assertEquals(5, address.getZipcode());
    }

    @Test
    void getCity()
    {
        assertEquals("Bekecs", address.getCity());
    }

    @Test
    void setCity()
    {
        address.setCity("a");
        assertEquals("a", address.getCity());
    }

    @Test
    void getStreet()
    {
        assertEquals("Tűzoltó út", address.getStreet());
    }

    @Test
    void setStreet()
    {
        address.setStreet("b");
        assertEquals("b", address.getStreet());
    }

    @Test
    void getStreetNumber()
    {
        assertEquals("28", address.getStreetNumber());
    }

    @Test
    void setStreetNumber()
    {
        address.setStreetNumber("0");
        assertEquals("0", address.getStreetNumber());
    }

    @Test
    void getPhoneNumber()
    {
        assertEquals("+36901112222", address.getPhoneNumber());
    }

    @Test
    void setPhoneNumber()
    {
        address.setPhoneNumber("7");
        assertEquals("7", address.getPhoneNumber());
    }

    @Test
    void testToString()
    {
        assertEquals("3903,Bekecs,Tűzoltó út,28,+36901112222", address.toString());
    }
}