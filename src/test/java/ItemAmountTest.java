import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class ItemAmountTest
{

    ItemAmount itemAmount;

    @BeforeEach
    public void setUp()
    {
        itemAmount = new ItemAmount(10.0, 5.0);
    }
    @Test
    void getTotalAmount()
    {
        assertEquals(10.0, itemAmount.getTotalAmount());
    }

    @Test
    void getReservedAmount()
    {
        assertEquals(5.0, itemAmount.getReservedAmount());
    }

    @Test
    void addAmount()
    {
        itemAmount.addAmount(5.0);
        assertEquals(15.0, itemAmount.getTotalAmount());
    }

    @Test
    void reserveAmount()
    {
        itemAmount.reserveAmount(1.0);
        assertEquals(6.0, itemAmount.getReservedAmount());
    }

    @Test
    void getFreeAmount()
    {
        assertEquals(5.0, itemAmount.getFreeAmount());
    }

    @Test
    void removeReservedAmount()
    {
        itemAmount.removeReservedAmount(5.0);
        assertEquals(10.0, itemAmount.getFreeAmount());
    }

    @Test
    void removeReservedAmountNotEnought()
    {
        //befejezni!
    }

    @Test
    void sendAmount()
    {
        //befejezni!
    }
}