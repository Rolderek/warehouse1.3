/**
 * Integer, Double párokat tárol a MovementLister-nek
 */

public class MovementHelper
{
    private int integerPart;

    private double doublePart;

    public MovementHelper(int integerPart, double doublePart)
    {
        this.integerPart = integerPart;
        this.doublePart = doublePart;
    }

    public int getIntegerPart()
    {
        return integerPart;
    }

    public double getDoublePart()
    {
        return doublePart;
    }

}
