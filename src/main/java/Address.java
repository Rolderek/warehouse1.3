/**
 * Egy adott raktár címe.
 */
public class Address
{

    private int zipcode;

    private String city;

    private String street;

    private String streetNumber;

    private String phoneNumber;

    public Address(int zipcode, String city, String street, String streetNumber, String phoneNumber)
    {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.phoneNumber = phoneNumber;
    }

    public int getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return this.zipcode + "," +
        this.city + "," +
        this.street + "," +
        this.streetNumber + "," +
        this.phoneNumber;
    }

}
