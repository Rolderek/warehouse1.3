import java.util.ArrayList;

/**
 * WarehouseInventory-k között mozgatja a készleteket,
 * Bevételezések itt történnek a beszállítóktól
 */
public class InventoryMover
{

    private ItemProvider provider;
    private TransitInventory transit;
    private PurchaseContainer purchaseContainer;
    private KommissionList kommissionList;

    public InventoryMover(ItemProvider provider, TransitInventory transit)
    {
        this.provider = provider;
        this.transit = transit;
    }

    /**
     * innen kezdődik a hozzáirt funkció:
     */

    public InventoryMover(ItemProvider provider, TransitInventory transit, PurchaseContainer purchaseContainer, KommissionList kommissionList)
    {
        this.provider = provider;
        this.transit = transit;
        this.purchaseContainer = purchaseContainer;
        this.kommissionList = kommissionList;
    }

    /**
     * kommissiós lista alapján elküldi a tételeket
     * még új tesztelni kell!
     */
    public void sendKommissionList(int warehouseid)
    {
        kommissionList.makeKommissionListOfOneWarehouse(warehouseid);
        for (int transitbundleId : kommissionList.getOnlyOneWarehouseList().keySet())
        {
            sendItems(kommissionList.getOnlyOneWarehouseList().get(transitbundleId));
        }

    }

    public KommissionList getKommissionList()
    {
        return kommissionList;
    }

    public PurchaseContainer getPurchaseContainer()
    {
        return purchaseContainer;
    }

    public void setPurchaseContainer(PurchaseContainer newContainer)
    {
        purchaseContainer = newContainer;
    }

    /**
      * első
      */
    public PurchaseFinal findPurchaseFinalInPurchaseContainer(int finalId)
    {
        return purchaseContainer.getPurchaseFinalById(finalId);
    }

    /**
      * második
      */

    public void recivePurchase(PurchaseFinal purchaseFinal)
    {
        for (int itemId : purchaseFinal.getItems().keySet())
        {
            provider.getInventories()
                    .getInventory(purchaseFinal
                            .getWarehouseId())
                    .getItemAmount(itemId)
                    .addAmount(purchaseFinal
                            .getItems()
                            .get(itemId)
                            .getAmount());
        }
        purchaseFinal.setStatusToRecived();
    }

    /**
      * Eddig tart.
      */

    public void sendItems(TransitBundle transitBundle)
    {
        // ezt lehetne úgy is hogy csak egy metóduban csinálja a kiadást/bevételt attól fügőően hogy mi a TB tipusa, ez lesz a superSendItems SSI
        // létrehozni az SSI-t csak a móka kedvéért 2023.07.26
        for (int itemId : transitBundle.getItems().keySet())
        {
            provider.getInventories().getInventory(transitBundle.getSenderId()).getItemAmount(itemId).sendAmount(transitBundle.getItems().get(itemId));
        }
        transitBundle.setStatusToSent();
        transit.addBoundle(transitBundle);
    }

    public void reciveItems(TransitBundle transitBundle)
    {
        /**
         * megkap egy bundle-t és kiveszi a transit-ból és átteszi a fogadó félhez
         */
        for (int itemId : transitBundle.getItems().keySet())
        {
            provider.getInventories().getInventory(transitBundle.getRecipientId()).getItemAmount(itemId).addAmount(transitBundle.getItems().get(itemId));
        }
        transit.removeBundle(transitBundle);
    }



    public ItemProvider getProvider()
    {
        return provider;
    }

    public void setProvider(ItemProvider newProvider)
    {
        provider = newProvider;
    }

    public TransitInventory getTransit()
    {
        return transit;
    }

    public void setTransit(TransitInventory newTransit)
    {
        transit = newTransit;
    }

    public ArrayList<TransitBundle> searchBundleInTransitInventory(int senderId, int reciverId)
    {
        ArrayList<TransitBundle> sortedList = new ArrayList<>();
        for (int id : transit.getBundles().keySet())
        {
            if (transit.getBundles().get(id).getSenderId() == senderId && transit.getBundles().get(id).getRecipientId() == reciverId)
            {
                sortedList.add(transit.getBundles().get(id));
            }
        }
        return sortedList;
    }

}
