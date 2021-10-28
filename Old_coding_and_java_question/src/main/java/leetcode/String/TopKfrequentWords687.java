package leetcode.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopKfrequentWords687 {
	public static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i]))

			{
				int v = map.get(words[i]);
				map.put(words[i], v + 1);
			} else {
				map.put(words[i], 1);
			}

		}

		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				int value = map.get(o1);
				int value1 = map.get(o2);
				if (value==(value1))
					return o1.compareTo(o2);
				if (value > value1)
					return -1;
				else
					return 1;

			}
		});
		return list;

	}

	public static void main(String args[]) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };

		System.out.println(topKFrequent(words, 1));

	}

}
