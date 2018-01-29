/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.IMultimovable;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Multimover;
import cz.pecinovsky.english.lootp.manager.CanvasManager;

import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Direction8;


/*******************************************************************************
 * Instances of the {@code DirectableCircular} class represents
 * decorators of movable a directable objects.
 * They decorates the wrapped objects with the ability to circulate at rounds
 * and with the ability to change their shape together with changing
 * the direction of their movement.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class DirectableCircular implements IMultimovable, IDirectable
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
    private final IDirectable decorated;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The object current moving speed. */
    private int speed = DEFAULT_SPEED;

    /** The field the object leaved last time. */
    private RoadField field;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Create a new instance decorating the given object.
     *
     * @param decorated Wrapped and decorated object
     */
    public DirectableCircular(IDirectable decorated)
    {
        this.decorated = decorated;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Vrátí základní délku, od níž se odvozují všechny rozměry objektu.
     *
     * @return Velikost modulu
     */
    @Override
    public int getModule()
    {
        return decorated.getModule();
    }


    /***************************************************************************
     * Nastaví nový základní rozměr objektu,
     * od nějž se odvozují jeho ostatní rozměry.
     *
     * @param module Nově nastavovaný module
     */
    @Override
    public void setModule(int module)
    {
        decorated.setModule(module);
    }


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
     * Set a new position of the instance.
     *
     * @param position   The set position
     */
    @Override
    public void setPosition(Position position)
    {
        decorated.setPosition(position);
    }


    /***************************************************************************
     * Set a new coordinates of the instance.
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
     * Set the speed for next moving..
     *
     * @param speed  The set speed
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }


    /***************************************************************************
     * Return the current direction of the instance.
     *
     * @return Current instance direction
     */
    @Override
    public Direction8 getDirection()
    {
        return decorated.getDirection();
    }


    /***************************************************************************
     * Turn the instance to the given direction..
     *
     * @param direction Direction, to which the instance should be turned
     */
    @Override
    public void setDirection(Direction8 direction)
    {
        decorated.setDirection(direction);
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
     * Set the decorated object at the given ring
     * and start to circulate with it.
     *
     * @param ring The ring for circulating
     */
    public void goRound(Ring ring)
    {
        RoadField start = ring.getStartField();
        continueFrom(start);
    }


    /***************************************************************************
     * Put the decorated object at the given field
     * and move to its successor.
     *
     * @param field The starting field
     */
    public void continueFrom(RoadField field)
    {
        this.field = field;
        Position pozice = field.getPosition();
        decorated.setPosition(pozice);
        decorated.setModule(field.getModule());
        CM.add(this);
        moved();
    }


    /***************************************************************************
     * Method called by multimover in the moment,
     * when it brings the object to the requested target.
     * It start moving of the decorated object to the next field.
     */
    @Override
    public void moved()
    {
        Direction8 direction = field.getDirection();
        decorated.setDirection(direction);
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
        return "Directable_(" + decorated.toString() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
    }
