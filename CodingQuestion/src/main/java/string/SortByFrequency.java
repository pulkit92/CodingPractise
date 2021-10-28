package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {
  public static void main(String args[]) {
    int a[] = {2, 5, 2, 8, 5, 6, 8, 8};
    SortByFrequency sortByFrequency = new SortByFrequency();
    sortByFrequency.sort(a);

  }

  public void sort(int a[]) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (!map.containsKey(a[i])) {
        map.put(a[i], i);
      }
    }
    for (int i = 0; i < a.length; i++) {
      int count = countMap.getOrDefault(a[i], 0);
      countMap.put(a[i], count + 1);
      list.add(a[i]);
    }
    SortComaprator sortComaprator = new SortComaprator(countMap,map);
    Collections.sort(list, sortComaprator);
    for (int i : list) {
      System.out.print(i + " ");
    }
  }
}



class SortComaprator implements Comparator<Integer> {
  Map<Integer, Integer> countMap;
  Map<Integer, Integer> indexMap;

  @Override public int compare(Integer o1, Integer o2) {
    int freq = countMap.get(o2).compareTo(countMap.get(o1));
    if (freq == 0) {
      return indexMap.get(o1).compareTo(indexMap.get(o2));
    }

    return freq;
  }

  SortComaprator(Map<Integer, Integer> countMap, Map<Integer, Integer> indexMap) {
    this.countMap = countMap;
    this.indexMap = indexMap;
  }

}
