package anagram;

import java.util.HashMap;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

  public int minSteps(String s, String t) {
    HashMap<Character, Integer> sMap = new HashMap<>();
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      sMap.put(c, sMap.getOrDefault(c, 0) + 1);
    }
    for (char c : t.toCharArray()) {
      tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    }
    int sum = 0;

    for (char ch : sMap.keySet()) {
      if (tMap.containsKey(ch) && sMap.get(ch) - tMap.get(ch) > 0) {
        sum = sum + sMap.get(ch) - tMap.get(ch);
      } else if (!tMap.containsKey(ch)) {
        sum = sum + sMap.get(ch);
      }
    }
    return sum;
  }

  public static void main(String args[]) {
    MinimumNumberOfStepsToMakeTwoStringsAnagram minimumNumberOfStepsToMakeTwoStringsAnagram =
        new MinimumNumberOfStepsToMakeTwoStringsAnagram();
    System.out.println(minimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("friend", "family"));
  }

}