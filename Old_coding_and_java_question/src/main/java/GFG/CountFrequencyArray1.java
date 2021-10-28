package GFG;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyArray1 {
	public static void main(String[] args) {
		CountFrequencyArray1 count = new CountFrequencyArray1();
		int arr[] = { 2, 3, 3, 2, 5 };
		int n = arr.length;
		count.printfrequency(arr, n);
	}

	void printfrequency(int arr[], int n) {
		Map<Integer, Integer> m = new HashMap<>();
		// Subtract 1 from every element so that the elements
		// become in range from 0 to n-1
		for (int j = 0; j < n; j++) {
			if (m.containsKey(arr[j])) {
				int value = m.get(arr[j]);
				m.put(arr[j], ++value);
			} else {
				m.put(arr[j], 1);
			}
		}
		for (int j = 1; j <= n; j++) {
			if (m.containsKey(j)) {
				System.out.println(j + "->" + m.get(j));
			} else {
				System.out.println(j + "->" + 0);

			}

		}
	}
}
