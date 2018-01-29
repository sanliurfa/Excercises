


public class TrafficLight
{
    public TrafficLight()
    {
        new Rectangle(0,   0, 50, 150, NamedColor.BLACK);
        new Light    (0,   0, NamedColor.RED);
        new Light    (0,  50, NamedColor.AMBER);
        new Light    (0, 100, NamedColor.GREEN);
    }


    public TrafficLight(int x, int y)
    {
        new Rectangle(x, y+  0,  50, 150, NamedColor.BLACK);
        new Light  (x, y+  0, NamedColor.RED);
        new Light  (x, y+ 50, NamedColor.AMBER);
        new Light  (x, y+100, NamedColor.GREEN);
    }


    public TrafficLight(int x, int y, NamedColor boxColor)
    {
        new Rectangle(x, y+  0,  50, 150, boxColor);
        new Light    (x, y+  0, NamedColor.RED);
        new Light    (x, y+ 50, NamedColor.AMBER);
        new Light    (x, y+100, NamedColor.GREEN);
    }
}
