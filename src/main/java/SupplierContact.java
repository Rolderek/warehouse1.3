public class SupplierContact {

    private String name;

    private String email;

    private String phoneNumber;

    private String note;

    public SupplierContact(String name, String email, String phoneNumber, String note)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.note = note;
    }

    public SupplierContact(String name, String email, String phoneNumber)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String newNote)
    {
        note = newNote;
    }

    public void setPhoneNumber(String newNumber)
    {
        phoneNumber = newNumber;
    }

    public void setEmail(String newEmail)
    {
        email = newEmail;
    }

    public void setName(String newName)
    {
        name = newName;
    }
}
