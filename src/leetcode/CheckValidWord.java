package leetcode;

/*
* 1003. Check If Word Is Valid After Substitutions
* problem url: https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CheckValidWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("abc"));
	}

	public static boolean isValid(String S) {
		if (S.length() < 3)
			return false;

		while (S.length() > 0) {
			if (!S.contains("abc") || S.charAt(0) != 'a')
				return false;
			S = S.replace("abc", "");
		}

		return true;
	}
}
