/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.IMovable;
import cz.pecinovsky.english.lootp.manager.IMultimovable;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Multimover;
import cz.pecinovsky.english.lootp.manager.CanvasManager;

import cz.pecinovsky.english.lootp.util.Position;


/*******************************************************************************
 * Instances of the {@code Circular} class represent movable object decorators
 * that decorate the wrapped objects with the ability to circulate at rounds.
 * By this circulation the circulated objects don't change their shape
 * together with the direction of their movement.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Circular implements IMultimovable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Default speed of objects moving. */
    private static final int DEFAULT_SPEED = 100;

    /** Manager of the canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Decorated object that will circulate at a round. */
    private final IMovable decorated;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The object's current moving speed. */
    private int speed = DEFAULT_SPEED;

    /** The field the object leaved last time. */
    private RoadField field;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new instance decorating the given object.
     *
     * @param decorated Wrapped and decorated object
     */
    public Circular(IMovable decorated)
    {
        this.decorated = decorated;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns instance of the class {@code Position} with current position.
     *
     * @return Current position
     */
    @Override
    public Position getPosition()
    {
        return decorated.getPosition();
    }


    /***************************************************************************
     * Sets a new position of the instance.
     *
     * @param position   The set position
     */
    @Override
    public void setPosition(Position position)
    {
        decorated.setPosition(position);
    }


    /***************************************************************************
     * Sets a new coordinates of the instance.
     *
     * @param x  The newly set horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    @Override
    public void setPosition(int x, int y)
    {
        decorated.setPosition(x, y);
    }


    /***************************************************************************
     * Sets the speed for the next moving.
     *
     * @param speed  The set speed
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        decorated.paint(painter);
    }


    /***************************************************************************
     * Sets the decorated object at the given ring
     * and starts to circulate with it.
     *
     * @param ring The ring for circulating
     */
    public void goRound(Ring ring)
    {
        RoadField start = ring.getStartField();
        continueFrom(start);
    }


    /***************************************************************************
     * Puts the decorated object at the given field
     * and moves to its successor.
     *
     * @param field The starting field
     */
    public void continueFrom(RoadField field)
    {
        this.field = field;
        Position position = field.getPosition();
        decorated.setPosition(position);
        CM.add(this);
        moved();
    }


    /***************************************************************************
     * Method called by multimover in the moment,
     * when it brings the object to the requested target.
     * It starts the moving of the decorated object to the next field.
     */
    @Override
    public void moved()
    {
        field = field.getNext();
        Position position = field.getPosition();
        Multimover m = Multimover.getInstance();
        m.moveWithSpeed(speed, this, position);
    }


    /***************************************************************************
     * Returns a string representation of the object &ndash; its text signature.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return "Circular_(" + decorated.toString() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
