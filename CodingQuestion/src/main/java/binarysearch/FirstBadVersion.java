package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {
  static Map<Integer, Boolean> map = new HashMap<>();


  public static void main(String args[]) {
    FirstBadVersion firstBadVersion = new FirstBadVersion();
    for (int i = 1; i <= 1702766718; i++) {
      map.put(i, false);
    }
    for (int i = 1702766719; i <= 2126753390; i++) {
      map.put(i, true);
    }
    System.out.println(firstBadVersion.firstBadVersion(9));
  }

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean isBadVersion(int n) {
    return map.get(n);
  }
}
