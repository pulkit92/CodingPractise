package string;

import java.util.Arrays;

public class SortCharactersByFrequency451 {
  public String frequencySort(String s) {
    int count = 0;
    int a[] = new int[256];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int as = (int) ch;
      a[as]++;
      count = Math.max(count, a[as]);
    }
    StringBuffer sb[] = new StringBuffer[count + 1];
    for (int i = 0; i < sb.length; i++) {
      sb[i] = new StringBuffer();
    }

    for (int i = 0; i < 256; i++) {
      if (a[i] > 0) {
          sb[a[i]].append(Character.toString((char) i));
      }
    }
    StringBuffer s1 = new StringBuffer();
    for (int i = count; i > 0; i--) {
      char[] sm = sb[i].toString().toCharArray();
      Arrays.sort(sm);
      for (int j = 0; j < sm.length; j++) {
        for (int k=0;k<i;k++)
        s1.append(sm[j]);
      }
    }
    return s1.toString();
  }

  public static void main(String args[]) {
    SortCharactersByFrequency451 s = new SortCharactersByFrequency451();
    System.out.println(s.frequencySort("tree"));
  }
}
