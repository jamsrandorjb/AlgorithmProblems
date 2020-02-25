package leetcode;

/*
* Add Strings
* problem url: https://leetcode.com/problems/add-strings/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AddStringsProblem {

	public static void main(String[] args) {
		System.out.println(addStrings("98", "9"));
	}

	public static String addStrings(String num1, String num2) {
		int carry = 0;
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		StringBuilder sb = new StringBuilder();

		while (len1 >= 0 || len2 >= 0) {
			int sum = carry;
			if (len1 >= 0)
				sum += num1.charAt(len1--) - '0';
			if (len2 >= 0)
				sum += num2.charAt(len2--) - '0';
			sb.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			sb.append(carry);

		return sb.reverse().toString();
	}
}
