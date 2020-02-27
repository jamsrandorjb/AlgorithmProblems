package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 989. Add to Array-Form of Integer
* problem url: https://leetcode.com/problems/add-to-array-form-of-integer/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AddToArrayForm {

	public static void main(String[] args) {
		System.out.println(addToArrayForm(new int[] { 1, 2, 3, 4 }, 9));
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {
		int carry = 0;
		int len = A.length - 1;
		List<Integer> result = new ArrayList<>(len);

		while (len >= 0 || K != 0) {
			int sum = carry;
			if (len >= 0)
				sum += A[len--];
			if (K != 0)
				sum += K % 10;
			result.add(sum % 10);
			carry = sum / 10;
			K = K / 10;
		}

		if (carry != 0)
			result.add(carry);

		Collections.reverse(result);
		return result;
	}
}
