package heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
  public static int minNum(int samDaily, int kellyDaily, int difference) {
    // Write your code here
    int count = 1;
    int samtotal = samDaily + difference;
    int kellyTotal = kellyDaily;
    int currdiff = samtotal - kellyTotal;
    if (currdiff < 0) {
      return -1;
    }
    while (true) {
      if (samtotal < kellyTotal) {
        return count;
      }
      kellyTotal = kellyTotal + kellyDaily;
      samtotal = samtotal + samDaily;
      if (currdiff < samtotal - kellyTotal) {
        return -1;
      }
      count++;
    }
  }

  public static void main(String[] args) {

    List x = List.of("88 99 200", "88 99 300", "99 32 100", "12 12 15");
    // int result = minNum(100, 100, 0);

    //System.out.println(processLogs(x, 2));
    System.out.println(firstOccurrence("juliasamanthasamanthajulia", "ant*as"));
  }

  public static List<String> processLogs(List<String> logs, int threshold) {
    // Write your code here

    Map<Long, Integer> map = new TreeMap<>();
    Collection<Integer> list=map.values();
    for (String log : logs) {
      String sn[] = log.split(" ");
      long recv = Long.parseLong(sn[0]);
      long sender = Long.parseLong(sn[1]);
      int countrecv = map.getOrDefault(recv, 0);
      map.put(recv, countrecv + 1);
      if (sender == recv) {
        continue;
      }
      int sendrecv = map.getOrDefault(sender, 0);
      map.put(sender, sendrecv + 1);
    }

    List<String> out = new ArrayList<>();
    for (long i : map.keySet()) {
      if (map.get(i) >= threshold) {
        out.add(String.valueOf(i));
      }
    }
    return out;

  }

  public static int firstOccurrence(String s, String x) {
    // Write your code here

    int M = x.length();
    int N = s.length();

    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= N - M; i++) {
      int j;
      int count = 0;
            /* For current index i, check for
            pattern match */
      for (j = 0; j < M; j++) {
        if (s.charAt(i + j)
            == x.charAt(j) || (x.charAt(j) == '*' && count == 0)) {
          if (x.charAt(j) == '*' && count == 0) {
            count++;
          }
        } else {
          break;
        }

      }

      if (j == M) {
        return i;
      }
    }

    return -1;
  }
}

