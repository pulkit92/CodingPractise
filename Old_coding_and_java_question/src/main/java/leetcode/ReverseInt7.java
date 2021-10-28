package leetcode;

import java.util.List;

public class ReverseInt7 {
	public static void main(String[] args) {
		int list = reverse(1534236469);
		System.out.println(list);

	}

	public static int reverse(int x) {

		boolean b = false;
		if (x < 0) {
			b = true;
			x = x * (-1);
		}
		int s = 0;

		for (int i = x; i > 0; i = i / 10) {
			int r = i % 10;
			if (s > Integer.MAX_VALUE / 10 || (s == Integer.MAX_VALUE / 10 && r > 7))
				return 0;
			if (s < Integer.MIN_VALUE / 10 || (s == Integer.MIN_VALUE / 10 && r < -8))
				return 0;
			s = s * 10 + r;
		}
		if (b) {
			s = s * (-1);
		}
		return s;

	}
}
