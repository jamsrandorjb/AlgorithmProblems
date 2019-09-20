package leetcode;

/*
* Day of the Week for given date input
* problem url: https://leetcode.com/problems/day-of-the-week/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class DayOfTheWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dayofTheWeek(31,8,2019));
	}
	
	public static String dayofTheWeek(int day, int month, int year) {
        String[] days = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int intDay  = java.time.LocalDate.of(year,month,day).getDayOfWeek().getValue();
 
        return intDay==7?days[0]:days[intDay];
    }
}
