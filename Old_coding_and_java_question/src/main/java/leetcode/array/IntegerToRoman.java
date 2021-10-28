package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public static void main(String arg[]) {
		System.out.println(intToRoman(500));
	}

	static Map<Integer, String> map;
	static int a[] = { 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

	public static String intToRoman(int num) {
		map = new HashMap<Integer, String>();
		fillMap();
		String sna = "";

		for (int i = a.length - 1; i >= 0; i--) {
			if (num / a[i] > 0) {
				int t = num / a[i];
				for (int j = 0; j < t; j++) {
					sna = sna + map.get(a[i]);
				}
				num = num - (t * a[i]);
			}

		}
		if (map.containsKey(num)) {
			sna = sna + map.get(num);
			return sna;
		}
		return sna;
	}

	public static void fillMap() {
		map.put(1, "I");
		map.put(2, "II");
		map.put(3, "III");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(6, "VI");
		map.put(7, "VII");
		map.put(8, "VIII");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");

	}

}
