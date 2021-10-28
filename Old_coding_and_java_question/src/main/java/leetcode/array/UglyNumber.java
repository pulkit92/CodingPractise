package leetcode.array;

public class UglyNumber {
	public static boolean isUgly(int num) {
		
		if(num>=Integer.MAX_VALUE || num<=Integer.MIN_VALUE)
			return false;
		while (num % 2 == 0) {

			num /= 2;
		}
		while (num % 3 == 0) {

			num /= 3;
		}
		while (num % 5 == 0) {

			num /= 5;
		}

		if (num == 1)
			return true;

		return false;
	}

	public static void main(String args[]) {
		System.out.println(isUgly(0));
	}
}
