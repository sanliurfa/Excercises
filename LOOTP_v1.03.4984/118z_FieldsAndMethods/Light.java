


public class Light
{
    private Ellipse    bulb;
    private NamedColor color;


    public Light()
    {
        bulb  = new Ellipse();
        color = bulb.getColor();
    }


    public Light(int x, int y)
    {
        bulb  = new Ellipse(x, y, 50, 50);
        color = bulb.getColor();
    }


    public Light(int x, int y, NamedColor b)
    {
        color = b;
        bulb  = new Ellipse(x, y, 50, 50, color);
    }


    public void switchOff()
    {
        bulb.setColor(NamedColor.BLACK);
    }


    public void switchOn()
    {
        bulb.setColor(color);
    }


    public void blink()
    {
        switchOn ();    IO.pause(500);
        switchOff();    IO.pause(500);
    }
}