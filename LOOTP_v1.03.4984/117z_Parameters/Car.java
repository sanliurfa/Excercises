


public class Car
{
    public Car()
    {
        new Rectangle(  0,  0, 128, 64, NamedColor.BLUE);
        new Rectangle( 16, 16,  64, 32, NamedColor.GRAY);
        new Ellipse  (112,  0,  16, 16, NamedColor.YELLOW);
        new Ellipse  (112, 48,  16, 16, NamedColor.YELLOW);
    }


    public Car(int x, int y)
    {
        new Rectangle(x+  0, y+ 0, 128, 64, NamedColor.BLUE);
        new Rectangle(x+ 16, y+16,  64, 32, NamedColor.GRAY);
        new Ellipse  (x+112, y+ 0,  16, 16, NamedColor.YELLOW);
        new Ellipse  (x+112, y+48,  16, 16, NamedColor.YELLOW);
    }


    public Car(int x, int y, NamedColor chassisColor)
    {
        new Rectangle(x+  0, y+ 0, 128, 64, chassisColor);
        new Rectangle(x+ 16, y+16,  64, 32, NamedColor.GRAY);
        new Ellipse  (x+112, y+ 0,  16, 16, NamedColor.YELLOW);
        new Ellipse  (x+112, y+48,  16, 16, NamedColor.YELLOW);
    }
}
