


public class Arrow implements IPaintable
{
    private Rectangle  body;
    private Triangle   head;
    private NamedColor color;


    public Arrow()
    {
        color = NamedColor.BLACK;
        body  = new Rectangle( 0, 15, 25, 20, color);
        head  = new Triangle (25,  0, 25, 50, color, Direction8.EAST);
    }


    public Arrow(int x, int y)
    {
        color = NamedColor.BLACK;
        body  = new Rectangle(x,    y+15, 25, 20, color);
        head  = new Triangle (x+25, y,    25, 50, color, Direction8.EAST);
    }


    public Arrow(int x, int y, NamedColor c)
    {
        color = c;
        body  = new Rectangle(x,    y+15, 25, 20, c);
        head  = new Triangle (x+25, y,    25, 50, c, Direction8.EAST);
    }


    public void setColor(NamedColor color)
    {
        body.setColor(color);
        head.setColor(color);
    }


    public void translucent()
    {
        body.setColor(color.translucent());
        head.setColor(color.translucent());
    }


    public void restoreColor()
    {
        setColor(color);
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        body.paint(painter);
        head.paint(painter);
    }
}
