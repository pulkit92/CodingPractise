package string;

import java.util.Arrays;
import java.util.Collections;

public class ReordeDataInLogFiles {
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (s1, s2) -> {
      String sp1[] = s1.split(" ", 2);
      String sp2[] = s2.split(" ", 2);
      boolean isdigt1 = Character.isDigit(sp1[1].charAt(0));
      boolean isdigt2 = Character.isDigit(sp2[1].charAt(0));
      if (!isdigt1 && isdigt2) {
        int cmp = sp1[1].compareTo(sp2[1]);
        if (cmp != 0) {
          return cmp;

        }
        return sp1[0].compareTo(sp2[0]);
      }
      return isdigt1 ? (isdigt1 ? 0 : 1) : -1;



    });
    return logs;
  }
}
