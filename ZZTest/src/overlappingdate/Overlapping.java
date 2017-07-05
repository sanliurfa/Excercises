package overlappingdate;

import java.time.LocalTime;
import java.util.Date;

public class Overlapping {

	static LocalTime startA = LocalTime.of( 7 , 0 );
	static LocalTime stopA = LocalTime.of( 10 , 30 );

	static LocalTime startB = LocalTime.of( 10 , 00 );
	static LocalTime stopB = LocalTime.of( 11 , 30 );
	
	
	public static void main(String[] args) {
		

		
      System.out.println(isTimeOverlapped(startA, stopA, startB, stopB));
      

	}
	
	
	public boolean isDatesOverLapped(Date startDate1, Date endDate1, Date startDate2, Date endDate2)
		      throws NullPointerException {
		    if ((startDate1.before(startDate2) && endDate1.after(startDate2))
		        || (startDate1.before(endDate2) && endDate1.after(endDate2))
		        || (startDate1.before(startDate2) && endDate1.after(endDate2))
		        || (startDate1.equals(startDate2) && endDate1.equals(endDate2))) {
		      return Boolean.TRUE;
		    }
		    return Boolean.FALSE;
		  }
	
	public static boolean validTime(LocalTime startA, LocalTime stopA, LocalTime startB, LocalTime stopB){
		return ( ! startA.isAfter( stopA ) ) && ( ! startB.isAfter( stopB ) ) ;
		
	}
	
	public static boolean isTimeOverlapped(LocalTime startA, LocalTime stopA, LocalTime startB, LocalTime stopB)
			throws NullPointerException {
		
		
		    if ((validTime(startA, startB, stopA, stopB))&&
				    ( startA.isBefore( stopB ) ) 
				    && 
				    ( stopA.isAfter( startB ) ) 
				) {
		      return Boolean.TRUE;
		    }
		    return Boolean.FALSE;
		  }
	
	
	//public OverlapendeBehandelingen(){
		
//	}


}
