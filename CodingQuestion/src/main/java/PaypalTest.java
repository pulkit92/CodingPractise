import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class PaypalTest {
  //[12:06 PM] Srinivas Janga
  //    abcdabcefghfhgaa
  //find first non repeated character
  // map with frequescnes
  //bca
  public static void main(String args[]) {
    PaypalTest paypalTest = new PaypalTest();
    // System.out.println(paypalTest.findNonRepetedChar("abcdabcefghfhgaa"));
  }

  public char findNonRepetedChar(String s) {
    char arr[] = s.toCharArray();
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char ch : arr) {
      if (map.containsKey(ch)) {
        map.put(ch, -1);
      } else {
        map.put(ch, 1);
      }
    }
    Set<Character> set = map.keySet();
    for (char ch : set) {
      if (map.get(ch) == 1) {
        return ch;
      }
    }
    return new Character('1');

  }

  public List<Character> findTopNRepeatingChar(String s, int n) {
    // map > charcter and frequecy
    // treemap-> heap
    List<Character> list=new ArrayList<>();
    Map<Character, Integer> frequencyCountMap = new HashMap<>();
    PriorityQueue<Character> priorityQueue =
        new PriorityQueue<>((ch1,ch2)-> frequencyCountMap.get(ch1)-frequencyCountMap.get(ch2));
    for (char ch:frequencyCountMap.keySet()){
      priorityQueue.add(ch);
      if(priorityQueue.size()>n){
        priorityQueue.poll();
      }
    }
return new ArrayList<>();
  }

}
