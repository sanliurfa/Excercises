/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Class {@code CCI} and its instances serves for demonstrations and experiments
 * when explaining the
 * implementing and initialization of classes and construction of its instances.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class CCI
{
    static  // Opening static initializer
    {/*##_1_##*/
        String me = "\nSTART of the class constructor (= static initializer)" +
                    " of the CCI class";
        IO.inform(me);
        printStaticFields(me);
    }

    //Opening instance initializer
    {/*##_2_##*/
        String me = "\nSTART of the initialization of the creating " +
                    "CCI instance\n" +  this;
        IO.inform(me + " of a new CCI instance\n\nSTART");
        System.out.println("\n-------------------------------------" +
                           "\n" + me + " - START for " + this);
    }



    //== CONSTANT CLASS FIELDS =================================================

    static  //Before declaration of constants
    {/*##_3_##*/
        //Use of undeclared constant is a syntax error,
        //even if the constant value was assigned in the compile-time
        //System.out.println("COMPILED:    " + COMPILED);

        //Nevertheless, the hidden use works as can be seen in the block ##_1_##
    }

    /** Constant initialized in the compile-time -
     *  if the value of a constant is known in the compile-time.
     *  compiler initializes it during compilation. */
    private static final String COMPILED = "COMPILED";

    /** Constant initialized during the class loading. */
    public static final Class<?> CLASS_OBJECT = CCI.class;

    /** Constant initialized in a static initializer. */
    public static final String INITIALIZED;

    static  //After declaration of constants
    {/*##_4_##*/
        //The not initialized constant can't still be used as well
        //System.out.println("INITIALIZED: " + INITIALIZED);

        INITIALIZED = CLASS_OBJECT.getName();

        //After the initialization constants can be used
        System.out.println("\nxxx Print after the initialization" +
                                " of class constants:" +
                           "\n    - COMPILED:     " + COMPILED +
                           "\n    - CLASS_OBJECT: " + CLASS_OBJECT +
                           "\n    - INITIALIZED:  " + INITIALIZED);
    }

    //Static (= class) field can also refer to an instance of the class
    //But it's needed to initialize such field after all static fields,
    //which are used during its initialization.
    //The following declaration has problems with constant feld LOADED
    //as well as with variable field countCreated.
    //Problems are solved by shift of this field initialization
    //behind all fields used in its initialization.
    //public static final CCI ME = new CCI();



    //== VARIABLE CLASS FIELDS =================================================

    static //Before declaration of instance variables
    {/*##_5_##*/
        //Undeclared variable may not be used
        //System.out.println("variable: " + variable);
    }

    private static String variable;
    private static int    countCreated = 0;

    static  //After declaration of variables
    {/*##_6_##*/
        //Variable can be also used if uninitialized,
        //because the compiler is not able to recognise it
        System.out.println("\nxxx Print after declaration of class variables:" +
                           "\n    - variable:    " + variable);
        variable = "VARIABLE";  //As of this moment variable is reinitialized
    }



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    private final int ID;
    //Instance ID has to be at first counted
    {/*##_7_##*/
        countCreated = countCreated + 1;  //Increase of static field
        ID = countCreated;                //and save its current value
        //The hidden parameter this can be used in the initializers ...
        System.out.println("ID field initialized: " + this);
    }

    private final CCI THIS = this;  //... as well as in field iinitialization

    //In the following inicialization I ask the instance for its class-object
    String name = "[" + this.getClass() + "]";    //Temporary name



    //== VARIABLE INSTANCE FIELDS ==============================================

    //In the initialization of the instance fields we can use only
    //already declared instance fields and already initialized constants.
    //On the other side all class fields can be used,
    //because they were already defined during the class loading.
    private String time = LOADED;

    String source;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Prints all static attributes of class to standard output.
     * The compiler  do not recognize, if this method is used
     * before the used fields are declared and/or initialized.
     *
     * @param title Header of the particular prints
     */
    public static void printStaticFields(String title)
    {
        System.out.println("\n" + title +
                           "\n   - COMPILED     = " + COMPILED +
                           "\n   - CLASS_OBJECT = " + CLASS_OBJECT +
                           "\n   - variable     = " + variable +
                           "\n   - countCreated = " + countCreated +
                           "\n   - LOADED       = " + LOADED
                        );
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Parameterless constructor for test of initialization.
     */
    public CCI()
    {
        String text = " of the body of the parameterless constructor of ";
        System.out.println("Beginning" + text + this);
        source = "Parametereless";
        System.out.println("End" + text + this);
    }


    /***************************************************************************
     * One-parametric constructor for test of responsibility delegation.
     *
     * @param name Name of the generated instance
     */
    public CCI(String name)
    {
//        //Before the delegation of the responsibility there can be nothing
//        System.out.println("One parametric for " + this);
        this(name, prepare("One-parametric"));
        System.out.println("END parameter one");
    }


    /***************************************************************************
     * Constructor with 2 parameters for test of responsibility delegation.
     *
     * @param name   Name of the generated instance
     * @param source Characteristics of applicant
     */
    public CCI(String name, String source)
    {
        this(name, prepare("2-parametric"), source);
        String local = "2-parameters";
        System.out.println("END " + local);
    }


    /***************************************************************************
     * Constructor with 3 parameters for testing of responsibility delegation.
     *
     * @param name      Name of the generated instance
     * @param source    Characteristics of applicant
     * @param presource Second part of attribute value {@code source}
     */
    public CCI(String name, String source, String presource)
    {
        String text = " of the body of the 3-parametric constructor";
        System.out.println("Beginning" + text + this +
        "\n   Title=" + name + ", Source=" + source +
                            ", Presource=" + presource);
        String unused;
        String underlinning;
        this.name    = name;
        String sum   = "«" + presource + " -> " + source + "»";
        this.source  = sum;
        String local = "END" + text + "\n   this=";
        underlinning = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        System.out.println(local + this + underlinning);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Return the object's text signature.
     *
     * @return The object's text signature
     */
    @Override
    public String toString()
    {
        return "CCI_" + ID + "(name=" + name + ", source=" + source +
               ", ##time=" + time + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Auxiliary static method serving for registration of the moment,
     * in which the parameters are evaluated.
     *
     * @param text Header before particular prints
     */
    private static String prepare(String text)
    {
        System.out.println("  === Preparing: " + text);
        return text;
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================

    {/*##_8_##*/
        String text = "END of the initialization part of\n   " + this;
        System.out.println(text + "\n----------------------------");
        IO.inform(text);
    }

    //Static attribute declared as far as at the end of the body
    private static final String LOADED = "" + new java.util.Date();
    static
    {/*##_9_##*/
        String me = "\nEND of the class constructor (= static initializer)" +
                    " of the CCI class";
        printStaticFields(me);
        System.out.println("=============================\n");
        IO.inform(me);
    }
}
