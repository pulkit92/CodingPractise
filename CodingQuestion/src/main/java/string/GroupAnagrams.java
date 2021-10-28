package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static void main(String args[]) {
    String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    GroupAnagrams g = new GroupAnagrams();
    System.out.println(g.groupAnagrams(strs));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList();
    }
    Map<String, List> ans = new HashMap<String, List>();
    int[] count = new int[26];
    for (String s : strs) {
      Arrays.fill(count, 0);
      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      StringBuffer sna=new StringBuffer();
      for(int i=0;i<count.length;i++){
        sna.append('#');
        sna.append(count[i]);
      }
      String key = sna.toString();
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

}