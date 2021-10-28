package leetcode.String;

public class Strstr {
	public int strStr(String longString, String shortString) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == shortString.length())
					return i;
				if (i + j == longString.length())
					return -1;
				if (shortString.charAt(j) != longString.charAt(i + j))
					break;
			}
		}
	}
}
