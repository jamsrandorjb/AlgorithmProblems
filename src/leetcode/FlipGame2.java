package leetcode;

/*
* Flip Game - 2
* problem url: https://leetcode.com/problems/flip-game-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FlipGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWin("++++"));
	}

	public static boolean canWin(String s) {
		if (s == null || s.length() < 2)
			return false;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
				String newFlip = s.substring(0, i) + "--" + s.substring(i + 2);
				if (!canWin(newFlip)) {
					return true;
				}
			}
		}

		return false;
	}
}
