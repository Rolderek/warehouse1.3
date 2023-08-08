import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierTermOfPaymentTest
{

    SupplierTermOfPayment stop;
    @BeforeEach
    public void setUp()
    {
        stop = new SupplierTermOfPayment("Francesco Virgolini");
    }
    @Test
    void getTermOfPayment()
    {
        assertEquals("Francesco Virgolini", stop.getTermOfPayment());
    }

    @Test
    void setTermOfPayment()
    {
        stop.setTermOfPayment("wrrrooooooom!");
        assertEquals("wrrrooooooom!", stop.getTermOfPayment());
    }
}