


public class Arrow
{
    public Arrow()
    {
        new Rectangle( 0, 15, 25, 20, NamedColor.BLACK);
        new Triangle (25,  0, 25, 50, NamedColor.BLACK, Direction8.EAST);
    }


    public Arrow(int x, int y)
    {
        new Rectangle(x,    y+15, 25, 20, NamedColor.BLACK);
        new Triangle (x+25, y,    25, 50, NamedColor.BLACK, Direction8.EAST);
    }


    public Arrow(int x, int y, NamedColor color)
    {
        new Rectangle(x,    y+15, 25, 20, color);
        new Triangle (x+25, y,    25, 50, color, Direction8.EAST);
    }
}
