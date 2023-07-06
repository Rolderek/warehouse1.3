import java.util.HashMap;

/** This class make the actual move between WarehouseInventories */
public class InventoryMover {

    private ItemProvider provider;
    private TransitInventory transit;

    public InventoryMover(ItemProvider provider, TransitInventory transit) {
        this.provider = provider;
        this.transit = transit;
    }

    public void sendItems(HashMap<Integer, Double> items, int senderId, int recipientId) {
        /** megkap egy bundle-t és átteszi a transit-ba */
        provider.makeReservation(items, senderId, recipientId);

    }

    public void reciveItems() {
        /** megkap egy bundle-t és kiveszi a transit-ból és átteszi a fogadó félhez */

    }

    public ItemProvider getProvider() {
        return provider;
    }

    public void setProvider(ItemProvider newProvider) {
        provider = newProvider;
    }

    public TransitInventory getTransit() {
        return transit;
    }

    public void setTransit(TransitInventory newTransit) {
        transit = newTransit;
    }

}
