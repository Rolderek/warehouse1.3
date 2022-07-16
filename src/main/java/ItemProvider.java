public class ItemProvider {

    private InventoryContainer inventories;

    public ItemProvider(InventoryContainer inventories) {
        this.inventories = inventories;
    }

    public void inventorySendToInventory() {
        // létrehoz egy foglalást a küldő raktárában, nem mehetsz minuszba ebben az esetben
        //létrehozza a TransitBundle-t a foglalás alapőján
        //beteszi a TransitInventoryba
        //
    }
}
