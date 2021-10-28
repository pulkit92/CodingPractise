import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;



public class Result {

  /*
   * Complete the 'vanity' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY codes
   *  2. STRING_ARRAY numbers
   */

  public static List<String> vanity(List<String> codes, List<String> numbers) {
    TreeSet<String> ts = new TreeSet();
    List<String> codes1 = new ArrayList<>();
    Map<String, String> phone = new HashMap<String, String>() {{
      put("abc", "2");
      put("def", "3");
      put("ghi", "4");
      put("jkl", "5");
      put("mno", "6");
      put("pqrs", "7");
      put("tuv", "8");
      put("wxyz", "9");
    }};

    for (int i = 0; i < codes.size(); i++) {
      String sna = codes.get(i);
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < sna.length(); j++) {
        char ch = sna.charAt(j);
        for (String na : phone.keySet()) {
          if (na.toUpperCase().contains(Character.toString(ch))) {
            sb.append(phone.get(na));
          }
        }
      }
      codes1.add(sb.toString());
    }
    for (String s : numbers) {
      for (String w : codes1) {
        if (s.contains(w)) {
          ts.add(s);
          break;
        }
      }
    }
    List<String> lList = new LinkedList<String>();
    lList.addAll(ts);
    return lList;

  }

  public static void main(String[] args) throws IOException {
    List<String> lList = new LinkedList<String>();
    List<String> lLis1 = new LinkedList<String>();
    lList.add("TWLO");
    lLis1.add("+14157088956");
    lLis1.add("+15109926333");
    lLis1.add("++17474824380");
    lLis1.add("+1415123456");
    lLis1.add("+919810155555");
    Result result = new Result();
    System.out.println(result.vanity(lList, lLis1));
  }

}


