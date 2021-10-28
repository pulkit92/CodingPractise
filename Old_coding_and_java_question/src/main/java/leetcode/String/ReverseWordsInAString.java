package leetcode.String;

public class ReverseWordsInAString {

	public static String reverseWords(String s) {

		String a[] = s.trim().split(" ");

		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] != " " && a[j] != " ") {
				String t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			} else if (a[i] == " ") {
				i++;

			} else if (a[i] == " ") {
				j--;

			}

		}
		s = "";
		for (String s1 : a) {
			if (s1 != " ")
				s = s + s1 + " ";

		}
		return s.trim();

	}

	public static void main(String args[]) {
		String words = "  a   b ";

		System.out.println(reverseWords(words));

	}

}
