import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestClass5 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // Reading input from STDIN
		Map<Integer, List<Integer>> map = new LinkedHashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			List<Integer> a = new ArrayList<>();
			String na[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {

				a.add(Integer.parseInt(na[j]));

			}
			list.add(Integer.parseInt(br.readLine()));
			map.put(i, a);
		}

		for (int i : map.keySet()) {

			List<Integer> b = (delete(map.get(i), list.get(i)));
			int x[] = segregate0and1(b);

			for (int p = 0; p < x.length; p++) {
				System.out.print(x[p] + " ");
			}
			System.out.println();

		}

	}

	private static List<Integer> delete(List<Integer> a, int d) {
		List<Integer> result = new ArrayList<>();

		for (int item : a)
			if (d != item)
				result.add(item);
			else
				result.add(1);

		return result;
	}

	static int[] segregate0and1(List<Integer> arr) {
		int count = 0; // counts the no of zeros in arr
		int a[] = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == 1)
				count++;
		}

		// loop fills the arr with 0 until count
		for (int i = 0; i < count; i++)
			a[i] = 1;

		// loop fills remaining arr space with 1
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) != 1) {
				a[count] = arr.get(i);
				count++;
			}
		}

		return a;
	}
}
