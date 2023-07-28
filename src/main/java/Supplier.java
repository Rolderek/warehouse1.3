public class Supplier {

    private int id;

    private String name;

    private Address address;

    private String note;

    private SupplierContact contact;

    private SupplierTermOfPayment termOfPayment;

    public Supplier(int id, String name, Address address, String note, SupplierContact contact, SupplierTermOfPayment termOfPayment)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.note = note;
        this.contact = contact;
        this.termOfPayment = termOfPayment;
    }

    public Supplier(int id, String name, Address address, SupplierContact contact, SupplierTermOfPayment termOfPayment)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.termOfPayment = termOfPayment;
    }

    public void setTermOfPayment(SupplierTermOfPayment newTerm)
    {
        termOfPayment = newTerm;
    }

    public void setNote(String newNote)
    {
        note = newNote;
    }

    public void setContact(SupplierContact newContact)
    {
        contact = newContact;
    }

    public void setAddress(Address newAddress)
    {
        address = newAddress;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setId(int newId)
    {
        id = newId;
    }

    public SupplierTermOfPayment getTermOfPayment()
    {
        return termOfPayment;
    }

    public SupplierContact getContact()
    {
        return contact;
    }

    public String getNote()
    {
        return note;
    }

    public Address getAddress()
    {
        return address;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }
}
