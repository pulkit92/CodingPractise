package string;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {
  public static void main(String args[]) {
    SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
    System.out.println(sortCharactersByFrequency.frequencySort("tree"));
  }

  public String frequencySort(String s) {
    int maxFre = 0;
    Map<Character, Integer> map = new HashMap();
    for (char ch : s.toCharArray()) {
      int i = map.getOrDefault(ch, 0);
      int fr = i + 1;
      map.put(ch, fr);
      maxFre = Math.max(fr, maxFre);
    }
    StringBuffer[] sb = new StringBuffer[maxFre+1];
    for (int i = 0; i < maxFre+1; i++) {
      sb[i] = new StringBuffer();
    }
    for (Character character : map.keySet()) {
      int value = map.get(character);
      sb[value].append(character);
    }
    String sna = "";
    for (int i = sb.length - 1; i >= 0; i--) {
      for (char chars : sb[i].toString().toCharArray()) {
        for (int j = 0; j < i; j++) {
          sna=sna+chars;
        }
      }

    }
    return sna;
  }
}

