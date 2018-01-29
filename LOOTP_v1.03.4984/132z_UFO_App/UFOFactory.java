/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Instance třídy {@code UFOFactory} představují továrny,
 * které na požádání vyrobí nové UFO se zadanými parametry.
 * Vyráběná UFO musejí být instancí třídy implementující rozhraní {@link IUFO}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class UFOFactory implements IUFOFactory
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     *
     */
    public UFOFactory()
    {
    }


    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Metoda je vyvolána dipečerem poté,
     * co dispečera někdo požádá o přistavení nového UFO.
     * Dispečer vytvoří talíř, umístí jej na startovní rampu a
     * předá jej metodě jako parametr
     * spolu s pořadím vytvářeného UFO v rámci všech dosud vytvořených UFO.
     *
     * @param saucer   Odkaz na talíř tvořící kostru UFO
     * @param order  Pořadí konstruovaného UFO v rámci již vytvořených
     * @return Nová instance rozhraní {@link IUFO}
     */
    @Override
    public IUFO newUFO(ISaucer saucer, int order)
    {
        return new UFO(saucer, order);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
//
//    /***************************************************************************
//     * The test method.
//     */
//    public static void test()
//    {
//        UFOFactory inst = new UFOFactory();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
