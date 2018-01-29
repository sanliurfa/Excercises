/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Třída Main slouží ke spouštění aplikace ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Main
{
    private Main() {}

    public static void main(String [] args)
    {
        IUFOFactory tnu = new UFOFactory();
        Dispatcher dispatcher = Dispatcher.getDispatcher(tnu);
    }
}
