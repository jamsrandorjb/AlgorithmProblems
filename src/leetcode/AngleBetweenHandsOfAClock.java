package leetcode;

/*
* 1344. Angle Between Hands of a Clock
* problem url: https://leetcode.com/problems/angle-between-hands-of-a-clock/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AngleBetweenHandsOfAClock {

	public static void main(String[] args) {
		System.out.println(angleClock(12, 30));
		System.out.println(angleClock(3, 30));
		System.out.println(angleClock(3, 15));
		System.out.println(angleClock(4, 50));
		System.out.println(angleClock(12, 0));
	}

	public static double angleClock(int hour, int minutes) {

		double anglePerMinut = 360.0 / 60;
		double anglePerHour = 360.0 / 12;
		double anglePerHourMinute = anglePerMinut / 12;

		double minuteDegree = minutes * anglePerMinut;
		double hourDegree = hour * anglePerHour + minutes * anglePerHourMinute;

		double diff = Math.abs(hourDegree - minuteDegree);

		return Math.min(Math.abs(diff - 360), diff);
	}
}
