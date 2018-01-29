/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;


/*******************************************************************************
 * Instances of {@code TrafficLightState} class represents traffic light states.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public enum TrafficLightState
{
    /** All lights are switchedOff.              */  LIGHTS_OFF,
    /** Only amberLight (orange) is switched on. */  ATTENTION,
    /** Only redLight is switched on.            */  STOP,
    /** AmberLight and RedLight are switched on. */  GET_READY,
    /** Only greenLight is switched on.          */  GO,
    /** All lights are switched on.              */  LIGHTS_ON;
}
