/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.tests;


/*******************************************************************************
 * The {@code ByWords} class allows to translate the integer numbers
 * into text showing how they can be said by words.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public final class ByWords
{
    //== CONSTANT CLASS FIELDS =================================================

    /** The maximum translatable value */
    public static final long MAX = 999L;

    private static final String UNITS[] = new String[] {
        "",        "one",      "two",       "three",    "four",
        "five",    "six",      "seven",     "eight",    "nine",
        "ten",     "eleven",   "twelve",    "thirteen", "fourteen",
        "fifteen", "sixteen",  "seventeen", "eighteen", "nineteen",
    };

    private static final String TENS[] = new String[] {
        "",        "ten",      "twenty",    "thirty",   "forty",
        "fifty",   "sixty",    "seventy",   "eighty",   "ninety"
    };

    private static final String HUNDRED = " hundred";

    private static final String AND = " and ";

    private static final String[] TRIADS = { "",
        "thousand", "million", "billion", "trillion",
        "quadrillion", "quintillion"
    };



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Returns a string representing the given number expressed by words.
     *
     * @param number  Converted number
     * @return Word representation of the given number
     */
    public static String number(long number)
    {
        if (number == 0) {
            return "zero";      //==========>
        }
        if (number > 0) {
            return convert(number);
        }
        else {
            return "minus " + convert(-number);
        }
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /** Private constructor preventing creation of an instance. */
    private ByWords() {}



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================
    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Returns a string representing the given number expressed by words.
     *
     * @param number  Converted number
     * @return Word representation of the given number
     */
    private static String convert(long number)
    {
        String[] texts = new String[TRIADS.length];
        texts[0] = hundred((int)(number % 1000));
        int triad = 0;
        do {
            int trinum = (int)(number % 1000);
            if (trinum == 0)
            {
                triad++;
                continue;
            }
            String trinumString = hundred(trinum);
            String triadString  = TRIADS[triad];
            texts[triad] = trinumString + " " + triadString;
            triad++;
        } while ((number /= 1000) > 0);
        StringBuilder sb = new StringBuilder();
        for (int i = triad-1;   i >= 0;   i--)
        {
            if (texts[i] == null) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(texts[i]);
        }
//        String ret = sb.toString();
        return sb.toString();
    }


    /***************************************************************************
     * Returns a string representing the given number from 1 to 999
     * expressed by words.
     *
     * @param number  Converted number
     * @return Word representation of the given number
     */
    private static String hundred(int number)
    {
        int units    = number % 10;
        int ten_units= number % 100;
        int tens2    = number / 10;
        int tens1    = tens2  % 10;
        int hundreds = tens2  / 10;

        StringBuilder sb = new StringBuilder();
        if (hundreds > 0) {
            sb.append(UNITS[hundreds]).append(HUNDRED);
        }
        if ((tens1 > 0)  ||  (units > 0)) {
            if (hundreds > 0) {
                sb.append(AND);
            }
            if (ten_units < 20) {
                sb.append(UNITS[ten_units]);
            }
            else {
                sb.append(TENS[tens1]);
                if ((tens1 > 0)  &&  (units > 0)) {
                    sb.append(' ');
                }
                sb.append(UNITS[units]);
            }
        }
        return  sb.toString();
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================

    /***************************************************************************
     * The test method.
     */
    public static void test()
    {
        java.util.Random rnd = new java.util.Random();
        for (int i = 0;   i < 100;   i++)
        {
            long n = rnd.nextLong();
            System.out.println(n + " = " +  number(n));
        }
    }
    /** @param args Command line arguments - not used. */
    public static void main(String[] args)  {  test();  }
}
