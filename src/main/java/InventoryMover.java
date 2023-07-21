import java.util.HashMap;

/** WarehouseInventory-k között mozgatja a készleteket */
public class InventoryMover {

    private ItemProvider provider;
    private TransitInventory transit;

    public InventoryMover(ItemProvider provider, TransitInventory transit) {
        this.provider = provider;
        this.transit = transit;
    }

    public void sendItems(TransitBundle transitBundle) {
        /** megkap egy bundle-t és átteszi a transit-ba
         * ezt lehetne úgy is hogy csak egy metóduban csinálja a kiadást/bevételt attól fügőően hogy mi a TB tipusa,  ez lesz a superSendItems SSI*/
        for (int itemId : transitBundle.getItems().keySet()) {
            provider.getInventories().getInventory(transitBundle.getSenderId()).getItemAmount(itemId).sendAmount(transitBundle.getItems().get(itemId));
        }
        transitBundle.setStatusToSent();
        transit.addBoundle(transitBundle);
        /** ittbillen át DONE-ra az ItemReservation */
        makeItemReservationToDone(transitBundle);
    }

    public void makeItemReservationToDone(TransitBundle bundle) {
        /** státusz átbillentő segéd metódus */
        for (ItemReservation r : provider.getInventories().getReservations()) {
            if (bundle.getItems() == r.getItemPackage().getItems() && bundle.getRecipientId() == r.getReciverId()) {
                r.setStatusToDone();
            }
        }
    }

    public void reciveItems(TransitBundle transitBundle) {
        /** megkap egy bundle-t és kiveszi a transit-ból és átteszi a fogadó félhez */
        for (int itemId : transitBundle.getItems().keySet()) {
            provider.getInventories().getInventory(transitBundle.getRecipientId()).getItemAmount(itemId).addAmount(transitBundle.getItems().get(itemId));
        }
        transit.removeBundle(transitBundle);
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

    public void searchBundleInTransitInventory(int senderId, int reciverId) {
        /** végig iterál a TB-k között és visszaad egy listát amikre igazak a feltételek */
    }

}
