import java.util.HashMap;

public class SupplierContainer {

    private HashMap<Integer, Supplier> suppliers;

    public SupplierContainer(HashMap<Integer, Supplier> suppliers)
    {
        this.suppliers = suppliers;
    }

    public HashMap<Integer, Supplier> getSuppliers()
    {
        return suppliers;
    }

    public void addSuplier(Supplier newSupplier)
    {
        suppliers.put(newSupplier.getId(), newSupplier);
    }

    public void removeSupplier(Supplier oldSupplier)
    {
        suppliers.remove(oldSupplier.getId());
    }
}
