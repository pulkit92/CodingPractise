package string;

public class PerformStringShifts {
  public static void main(String args[]) {
    int a[][]={{1,1},{1,1},{0,2},{1,3}};
    PerformStringShifts p = new PerformStringShifts();
    System.out.println(p.stringShift("abcdefg",a));
  }

  public String stringShift(String s, int[][] shift) {
    for (int i = 0; i < shift.length; i++) {
      int a[] = shift[i];
      if (a[0] == 1) {
        s = ShiftRight(a[1], s);
      } else {
        s = ShiftLeft(a[1], s);
      }
    }
    return s;
  }

  private String ShiftRight(int pos, String sb) {

    String sm = sb.substring(0,sb.length()-pos);
    String s1 = sb.substring(sb.length()-pos);
    return s1.concat(sm);
  }

  private String ShiftLeft(int pos, String sb) {
    String sm = sb.substring(pos);
    String s1 = sb.substring(0,pos);
    return sm.concat(s1);
  }
}
