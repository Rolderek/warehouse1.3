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
    void removeReservedAmountIfItRun()
    {
        itemAmount.removeReservedAmount(5.0);
        assertEquals(10.0, itemAmount.getFreeAmount());
    }

    @Test
    void removeReservedAmountNotEnought()
    {
        Throwable exception = assertThrows(InputMismatchException.class,
                ()->
                {
                    itemAmount.removeReservedAmount(6.0);
                });
        assertEquals(5.0, itemAmount.getReservedAmount());
    }

    @Test
    void removeReservedAmountThrowMessage()
    {
        InputMismatchException thrown = assertThrows(
                InputMismatchException.class,
                /**
                 * ezt a lambdát meg kell néznem!
                 */
                () -> itemAmount.removeReservedAmount(6.0),
                "maximum reserved amount can be removed"
        );

        assertTrue(thrown.getMessage().contains("maximum reserved amount can be removed"));
    }

    @Test
    void removeReservedAmountInputZero()
    {
        InputMismatchException thrown = assertThrows(
                InputMismatchException.class,
                () -> itemAmount.removeReservedAmount(0.0),
                "amount must be positive"
        );

        assertTrue(thrown.getMessage().contains("amount must be positive"));
    }

    @Test
    void sendAmountIfItRun()
    {
        itemAmount.sendAmount(5.0);
    }

    @Test
    void sendAmountWrongInput()
    {
        Throwable exception = assertThrows(InputMismatchException.class,
                ()->
                {
                    itemAmount.sendAmount(6.0);
                });
    }
}