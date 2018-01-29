


public class Light
{
    public Light()
    {
        new Ellipse();
    }


    public Light(int x, int y)
    {
        new Ellipse(x, y, 50, 50);
    }


    public Light(int x, int y, NamedColor color)
    {
        new Ellipse(x, y, 50, 50, color);
    }
}
