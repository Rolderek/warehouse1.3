import java.util.ArrayList;
import java.util.HashMap;

/**
 * A mindenkori raktárak gyűjtő osztálya
 */
public class InventoryContainer
{

    /**
      * stores Inventory and TransitInventory classes
      */

    private HashMap<Integer, WarehouseInventory> inventories;

    private TransitInventory transitInventory;

    private ItemMovement reservations;

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory, ItemMovement reservations)
    {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
        this.reservations = reservations;
    }

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory)
    {
        this.inventories = inventories;
        this.transitInventory = transitInventory;
    }

    public ItemMovement getReservationsAllInOne()
    {
        return reservations;
    }

    public ArrayList<TransitBundle> getMyReservation(int senderId)
    {
        ArrayList<TransitBundle> sortedList = new ArrayList<>();
        for (int i = 0; i < reservations.getWasMoving().size(); i++)
        {
            if (senderId != reservations.getWasMoving().get(i).getSenderId())
            {
                System.out.println("No result.");
            }
            sortedList.add(reservations.getWasMoving().get(i));
        }
        return sortedList;
    }

    public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories)
    {
        this.inventories = inventories;
    }

    public HashMap<Integer, WarehouseInventory> getAllInventories()
    {
        return inventories;
    }

    public WarehouseInventory getInventory(int inventoryId)
    {
        return inventories.get(inventoryId);
    }

    public TransitInventory getTransitInvertory()
    {
        return transitInventory;
    }

    public void setReservations(ItemMovement reservations)
    {
        this.reservations = reservations;
    }

    public ItemMovement getReservations()
    {
        return reservations;
    }

    /**
     * public void addReservation(HashMap<Integer, Double> itemsToReservate, int senderId, int recipientId) {
     *         reservations.put(Instant.now(), new ItemReservation(itemsToReservate, senderId, recipientId));
     *     }
     *     */

    public boolean addInventory(WarehouseInventory newWarehouseInventory)
    {
        WarehouseInventory result = inventories.putIfAbsent(newWarehouseInventory.getWarehouseId(), newWarehouseInventory);
        if (result == null)
        {
            return true;
        }
        return false;
    }

    /** private ArrayList<ItemReservation> reservations = new ArrayList<>();
     *
     * public InventoryContainer(HashMap<Integer, WarehouseInventory> inventories, TransitInventory transitInventory, ArrayList<ItemReservation> reservations) {
     *         this.inventories = inventories;
     *         this.transitInventory = transitInventory;
     *         this.reservations = reservations;
     *     }
     *
     * public ArrayList<ItemReservation> getPackage() {
     *         return reservations;
     *     }
     *
     * public void setReservations(ArrayList<ItemReservation> reservations) {
     *         this.reservations = reservations;
     *     }
     *
     * public ArrayList<ItemReservation> getReservations() {
     *         return reservations;
     *     }
     *
     *     public ItemReservation addReservation(ItemReservation newReservation) {
     *         reservations.add(newReservation);
     *         return newReservation;
     *     }
     *     */

}
