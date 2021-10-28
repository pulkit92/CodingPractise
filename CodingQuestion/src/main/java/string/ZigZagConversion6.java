package string;

public class ZigZagConversion6 {
  public String convert(String s, int numRows) {
    StringBuffer out = new StringBuffer();
    StringBuffer a[] = new StringBuffer[numRows+1];
    for (int x = 0; x < numRows+1; x++) {
      a[x] = new StringBuffer();
    }
    int i = 0;
    boolean b = false;
    for (int k = 0; k < s.length(); k++) {
      if (!b && i < numRows) {
        StringBuffer m = a[i++];
        m.append(s.charAt(k));
        if (i >= numRows) {
          i=i-1;
          b = true;
        }
      } else {
        StringBuffer m = a[i--];
        m.append(s.charAt(k));
        if (i <= 1) {
          b = false;
          i=i-1;
        }
      }
    }
    for (int k = 0; k < numRows; k++) {
      out.append(a[k]);
    }
    return out.toString();
  }

  public static void main(String args[]) {
    ZigZagConversion6 z = new ZigZagConversion6();
    System.out.println(z.convert("PAYPALISHIRING", 3));
  }
}
