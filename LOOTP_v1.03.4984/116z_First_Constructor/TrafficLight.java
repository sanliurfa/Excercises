


public class TrafficLight
{
    public TrafficLight()
    {
        new Rectangle(0,   0, 50, 150, NamedColor.BLACK);
        new Ellipse  (0,   0, 50,  50, NamedColor.RED);
        new Ellipse  (0,  50, 50,  50, NamedColor.AMBER);
        new Ellipse  (0, 100, 50,  50, NamedColor.GREEN);
    }
}
