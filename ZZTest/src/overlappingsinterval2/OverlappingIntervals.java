/**
 * 
 */
package overlappingsinterval2;

/**
 * @author ro-goki
 *
 */
public class OverlappingIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static Long findOverlappingInterval(Long startTime1, Long endTime1, Long startTime2, Long endTime2)
	{
	    if (startTime1 < endTime1 && startTime2 < endTime2) 
	        return Math.max(0, Math.min(endTime2, endTime1) - Math.max(startTime1, startTime2) + 1);
	    else
	    {
	        if (startTime1 < endTime1) 
	            return findOverlappingInterval(startTime1, endTime1, 0L, endTime2) + 
	                   findOverlappingInterval(startTime1, endTime1, startTime2, 23L);
	        else if (startTime2 < endTime2) 
	            return findOverlappingInterval(0L, endTime1, startTime2, endTime2) + 
	                   findOverlappingInterval(startTime1, 23L, startTime2, endTime2);
	        else
	        {
	            return findOverlappingInterval(0L, endTime1, 0L, endTime2) +
	                   findOverlappingInterval(0L, endTime1, startTime2, 23L) +
	                   findOverlappingInterval(startTime1, 23L, 0L, endTime2) +
	                   findOverlappingInterval(startTime1, 23L, startTime2, 23L);
	        }
	    }
	}
	
}
