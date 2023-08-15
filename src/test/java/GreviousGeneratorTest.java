import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreviousGeneratorTest
{

    @Test
    void constructorOffer()
    {
        GreviousGeneratorForTransitBundle g = new GreviousGeneratorForTransitBundle(GreviousType.OFFER);
        assertEquals(1, g.generateBundleId());
    }

    @Test
    void constructorConfirmation()
    {
        GreviousGeneratorForTransitBundle g = new GreviousGeneratorForTransitBundle(GreviousType.CONFIRMATION);
        assertEquals(10000, g.generateBundleId());
    }

    @Test
    void constructorFinal()
    {
        GreviousGeneratorForTransitBundle g = new GreviousGeneratorForTransitBundle(GreviousType.FINAL);
        assertEquals(100000, g.generateBundleId());
    }

    @Test
    void generateBundleId()
    {
        GreviousGeneratorForTransitBundle g = new GreviousGeneratorForTransitBundle();
        assertEquals(0, g.generateBundleId());
        assertEquals(1, g.generateBundleId());
    }
}