package academy.learnprogramming;


class MuseumClosed extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6683217549353999357L;}

class MuseumClosedForLunch extends MuseumClosed{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8944720377301082727L;}




public class _125_CatchingExceptions {

	public static void main(String[] args) {
		try {
			visitMuseum();
			// ook dit compileert niet omdat de runtime exception een super class is
//		} catch (RuntimeException e) {
//			System.out.println("Runtime Exception");
		} catch (MuseumClosedForLunch mc) {
			System.out.println("Closed for lunch come back in 2 hours");  	// subclass
		} catch (MuseumClosed mc) {
			System.out.println("Closed");									// superclass
		// dit compileert niet omdat de superclass alles al opvangt
//		} catch (MuseumClosedForLunch mc) {
//		System.out.println("Closed for lunch come back in 2 hours");  	// subclass

			System.out.println(calculate());
			
		}


		
	}
	
	@SuppressWarnings("finally")
	public static String calculate() {
		String result ="";
		String str = null;
		try {
			try { result += "start";	// result = start
			str.length();				// throws nullpointetexception
			result += "end";			// wordt niet uitgevoerd omdat er hierboven een nullpointer exception gegooid is
										// het gaat naar de catch block
			} catch (NullPointerException e) {
				result += "npe";				// result = startnpe
				throw new RuntimeException();
			} finally {
				result += "finally";			// result = startnpefinally
				throw new Exception();
			}
		
			
		} catch (Exception e) {
			result += "finished";		// result = startnpefinallyfinished
		}
		return result;
	}
	
	
	public static void visitMuseum() {
		boolean b = Math.random() < 0.5;
		
		if(b) {
			throw new MuseumClosed();
		}
		throw new MuseumClosedForLunch();
	} 

}
