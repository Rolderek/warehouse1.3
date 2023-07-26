import java.time.Instant;
import java.util.HashMap;

/**
 * elkészitési időt és cikk listát tárol, az InventoryContainer használja foglalás ellenőrzés és visszakeresés céljából (még nincs kész az új verzió ott)
 */
public class ItemPackage
{


    private HashMap<Integer, Double> items;
    private Instant time;

    public ItemPackage(Instant time, HashMap<Integer, Double> items)
    {
        this.time = Instant.now();
        this.items = items;
    }

    public Instant getTime()
    {
        return time;
    }

    public HashMap<Integer, Double> getItems()
    {
        return items;
    }

    public void setItems(HashMap<Integer, Double> newItems)
    {
        items = newItems;
    }

}
