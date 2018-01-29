


public class Car implements IPaintable
{
    private Rectangle chassis;
    private Rectangle cab;
    private Ellipse   lightL;
    private Ellipse   lightR;


    public Car()
    {
        chassis = new Rectangle(  0,  0, 128, 64, NamedColor.BLUE);
        cab     = new Rectangle( 16, 16,  64, 32, NamedColor.GRAY);
        lightL  = new Ellipse  (112,  0,  16, 16, NamedColor.YELLOW);
        lightR  = new Ellipse  (112, 48,  16, 16, NamedColor.YELLOW);
    }


    public Car(int x, int y)
    {
        chassis = new Rectangle(x+  0, y+ 0, 128, 64, NamedColor.BLUE);
        cab     = new Rectangle(x+ 16, y+16,  64, 32, NamedColor.GRAY);
        lightL  = new Ellipse  (x+112, y+ 0,  16, 16, NamedColor.YELLOW);
        lightR  = new Ellipse  (x+112, y+48,  16, 16, NamedColor.YELLOW);
    }


    public Car(int x, int y, NamedColor chassisColor)
    {
        chassis = new Rectangle(x+  0, y+ 0, 128, 64, chassisColor);
        cab     = new Rectangle(x+ 16, y+16,  64, 32, NamedColor.GRAY);
        lightL  = new Ellipse  (x+112, y+ 0,  16, 16, NamedColor.YELLOW);
        lightR  = new Ellipse  (x+112, y+48,  16, 16, NamedColor.YELLOW);
    }


    /***************************************************************************
     * Paint a picture of your instance using given painter.
     *
     * @param painter Painter, which will paint the instance
     */
    @Override
    public void paint(Painter painter)
    {
        chassis.paint(painter);
        cab    .paint(painter);
        lightL .paint(painter);
        lightR .paint(painter);
    }
}
