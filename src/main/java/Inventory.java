import java.util.HashMap;

/** Egy adott telephelyre megkérdezheted hogy mi tartozik hozzá ebből a készletből.*/
public interface Inventory {

    public abstract HashMap<Integer, Double> getAllItemsOfWarehouse(int warehouseId);


}
