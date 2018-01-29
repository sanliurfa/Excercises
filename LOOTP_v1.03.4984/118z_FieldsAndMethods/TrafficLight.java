


public class TrafficLight
{
    private Rectangle box;
    private Light     redLight;
    private Light     amberLight;
    private Light     greenLight;


    public TrafficLight()
    {
        box        = new Rectangle(0,   0, 50, 150, NamedColor.BLACK);
        redLight   = new Light    (0,   0, NamedColor.RED);
        amberLight = new Light    (0,  50, NamedColor.AMBER);
        greenLight = new Light    (0, 100, NamedColor.GREEN);
    }


    public TrafficLight(int x, int y)
    {
        box        = new Rectangle(x, y+  0,  50, 150, NamedColor.BLACK);
        redLight   = new Light    (x, y+  0, NamedColor.RED);
        amberLight = new Light    (x, y+ 50, NamedColor.AMBER);
        greenLight = new Light    (x, y+100, NamedColor.GREEN);
    }


    public TrafficLight(int x, int y, NamedColor boxColor)
    {
        box        = new Rectangle(x, y+  0,  50, 150, boxColor);
        redLight   = new Light    (x, y+  0, NamedColor.RED);
        amberLight = new Light    (x, y+ 50, NamedColor.AMBER);
        greenLight = new Light    (x, y+100, NamedColor.GREEN);
    }


    public void stop()
    {
        redLight   .switchOn();
        amberLight .switchOff();
        greenLight .switchOff();
    }


    public void getReady()
    {
        redLight   .switchOn();
        amberLight .switchOn();
        greenLight .switchOff();
    }


    public void go()
    {
        redLight   .switchOff();
        amberLight .switchOff();
        greenLight .switchOn();
    }


    public void attention()
    {
        redLight   .switchOff();
        amberLight .switchOn();
        greenLight .switchOff();
    }


    public void allLightsOff()
    {
        redLight   .switchOff();
        amberLight .switchOff();
        greenLight .switchOff();
    }


    public void allLightsOn()
    {
        redLight   .switchOn();
        amberLight .switchOn();
        greenLight .switchOn();
    }


    public void cycle(int stop, int getReady, int go, int attention,
                      int lightsOff)
    {
        stop();             IO.pause(stop);
        getReady();         IO.pause(getReady);
        go();               IO.pause(go);
        attention();        IO.pause(attention);
        allLightsOff();     IO.pause(lightsOff);
    }


    public void cycle()
    {
        cycle(500, 500, 500, 500, 0);
    }

}
