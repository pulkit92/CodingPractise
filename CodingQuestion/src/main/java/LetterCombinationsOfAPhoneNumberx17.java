import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberx17 {
  Map<Integer, List<Character>> map = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    fillMap();
    List<String> out = new ArrayList<>();
    letterCombinations(digits, out, new StringBuffer());
    return out;
  }

  public void letterCombinations(String digits, List<String> out, StringBuffer temp) {
    if (0 == digits.length()) {
      out.add(temp.toString());
    }
    if (digits.length() > 0) {
      int as = Integer.parseInt((digits.substring(0, 1)));
      List<Character> ch = map.get(as);
      for (Character ch1 : ch) {
        temp.append(ch1);
        letterCombinations(digits.substring(1), out, temp);
        temp.deleteCharAt(temp.length() - 1);
      }
    }
  }



  private void fillMap() {
    map.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
    map.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
    map.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
    map.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
    map.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
    map.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
    map.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
    map.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
  }

  public static void main(String args[]) {
    LetterCombinationsOfAPhoneNumberx17 l = new LetterCombinationsOfAPhoneNumberx17();
    System.out.println(l.letterCombinations("23"));
  }
}
