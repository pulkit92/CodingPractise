package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ZigZagConv1 {
	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		boolean down = false;
		StringBuffer sb = new StringBuffer();
		List<StringBuffer> arr = new ArrayList<>();
		int t = 0;
		for (int i = 0; i < Math.min(numRows, s.length()); i++) {
			arr.add(new StringBuffer());
		}
		for (int i = 0; i < s.length(); i++) {

			arr.get(t).append(s.charAt(i));

			if (t == numRows - 1) {
				down = true;
			}
			if (t == 0) {
				down = false;
			}
			if (down == false) {
				t++;

			} else {
				t--;
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i));
		}

		return sb.toString();

	}

	public static void main(String args[]) throws Exception {
		/// not done
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}
}