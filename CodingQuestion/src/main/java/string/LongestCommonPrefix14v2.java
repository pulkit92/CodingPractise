package string;

public class LongestCommonPrefix14v2 {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    int lenMin = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      lenMin = Math.max(lenMin, strs[i].length());
    }
    int start = 1;
    int end = lenMin;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (isTrue(strs, mid)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }

    }
    return strs[0].substring(0, (start + end) / 2);

  }

  private boolean isTrue(String[] strs, int len) {
    String str1 = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(str1)) {
        return false;
      }
    }
    return true;
  }



  public static void main(String args[]) {
    LongestCommonPrefix14 l = new LongestCommonPrefix14();
    String a[] = {"aca", "cba"};
    System.out.println(l.longestCommonPrefix(a));
  }
}
