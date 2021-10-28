package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class IntegerToEnglishWords {
	public static String one(int num) {
		switch (num) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		}
		return "";
	}

	public static String ten(int num) {
		switch (num) {
		case 2:
			return "Twenty";
		case 3:
			return "Thirty";
		case 4:
			return "Forty";
		case 5:
			return "Fifty";
		case 6:
			return "Sixty";
		case 7:
			return "Seventy";
		case 8:
			return "Eighty";
		case 9:
			return "Ninety";
		}
		return "";
	}

	public static String get(int num) {
		if (num >= 1000000000)
			return "Billion";
		else if (num >= 1000000)
			return "Million";
		else if (num >= 1000)
			return "Thousand";
		else if (num >= 100)
			return "Hundred";
		else
			return "";
	}

	public static int m[] = { 1000000000, 100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10 };

	public static String numberToWords(int num) {
		String str = "";

		str = str + convert(num / 1000000000, "Billion");
		str = str + convert((num / 1000000) % 100, "Million");
		str = str + convert((num / 1000) % 100, "Thousand");
		str = str + convert((num / 100) % 10, "Hundred");
		str = str + convert((num % 100), "");
		return str;

	}

	private static String convert(int n, String s) {
		String out = "";
		if(n==0)
			return "";
		if (n > 19) {
			out = out + ten(n / 10) + " "+one(n % 10);
		} else {
			out = out + one(n % 10);
		}
		out = out +" " +s;
		return out+" ";
	}

	public static void main(String[] args) {

		System.out.println(numberToWords(1234567));
	}

}
