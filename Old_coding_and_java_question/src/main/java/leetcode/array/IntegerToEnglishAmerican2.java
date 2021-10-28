package leetcode.array;

public class IntegerToEnglishAmerican2 {
	public static void main(String[] args) {
		IntegerToEnglishAmerican2 h = new IntegerToEnglishAmerican2();
		System.out.println(h.numberToWords(1234567891));
	}

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
		}
		return "";
	}

	public static String twoLessThan20(int num) {
		switch (num) {
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

	public String numberToWords(int num) {

		if (num == 0)
			return "zero";

		int billon = num / 1000000000;
		int million = (num - billon * 1000000000) / 1000000;
		int thousand = (num - billon * 1000000000 - million * 1000000) / 1000;
		int rest = (num - billon * 1000000000 - million * 1000000 - thousand * 1000);
		String str = "";
		if (billon != 0) {
			str = str + three(billon) + " Billion";

		}
		if (million != 0) {
			if (!str.isEmpty()) {
				str += " ";

			}
			str = str + three(million) + " Million";
		}
		if (thousand != 0) {
			if (!str.isEmpty()) {
				str += " ";
			}
			str = str + three(thousand) + " Thousand";
		}
		if (!str.isEmpty()) {
			str += " ";
		}
		str = str + three(rest);

		return str.trim();

	}

	public String three(int num) {
		int h = num / 100;
		int rem = num - (h * 100);
		if (h == 0) {
			return Two(rem);

		} else if (h != 0 && rem == 0) {
			return one(h) + " " + "Hundred";
		} else {
			return one(h) + " " + "Hundred" + " " + Two(rem);
		}

	}

	public String Two(int num) {
		if (num < 10)
			return one(num);
		else if (num > 9 && num < 20)
			return twoLessThan20(num);
		else {
			int t = num / 10;
			int h = num - t * 10;
			if (h == 0) {
				return ten(t);

			} else {
				return ten(t) + " " + one(h);
			}

		}
	}

}