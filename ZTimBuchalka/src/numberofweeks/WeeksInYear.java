package numberofweeks;

import java.util.Calendar; 
public class WeeksInYear {     
    public static void main(String[] args) {  
        Calendar calendar = Calendar.getInstance();             
        if(calendar.isWeekDateSupported()) {               
            System.out.println("Number of weeks in this year: " + calendar.getWeeksInWeekYear());                   
            System.out.println("Current week number: " + calendar.                               get(Calendar.WEEK_OF_YEAR));         
        }     
    }
}
