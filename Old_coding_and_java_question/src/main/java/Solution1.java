import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'smallestString' function below.
	 *
	 * The function is expected to return a STRING. The function accepts
	 * LONG_INTEGER weight as parameter.
	 */

	public static String smallestString(long weight) {
		long a[] = new long[5];
		a[0] = 1;
		long sum = 0;
		for (int i = 2; i <= 5; i++) {
			sum = (a[i - 2] * i) + i;
			a[i - 1] = sum;
			sum = 0;
		}
		List<Character> list = new ArrayList<Character>();
		List<Character> list1 = get(list, a, weight);
		String str = list1.stream().map(e -> e.toString()).reduce((acc, e) -> acc + e).get();
		return str;
	}

	static List<Character> get(List<Character> list, long a[], long weight) {
		if (weight > 0) {
			for (int j = a.length - 1; j >= 0; j--) {
				if (weight > a[j]) {
					list.add((char) (65 + j + 1));
					get(list, a, weight - a[j]);
				}
			}
		}

		return list;

	}

}

public class Solution1 {
	public static void main(String[] args) throws IOException {

		String result = Result.smallestString(20);
		System.out.println(result);

	}
}