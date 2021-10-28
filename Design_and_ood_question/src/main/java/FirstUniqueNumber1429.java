import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FirstUniqueNumber1429 {
 /* Set<Integer> set;
  LinkedHashSet<Integer> list;

  public FirstUniqueNumber1429(int[] nums) {

    set = new HashSet<>();
    list = new LinkedHashSet<>();
    for (int i : nums) {
      this.add(i);
    }
  }

  public int showFirstUnique() {
    if (!list.isEmpty()) {
      return list.iterator().next().intValue();
    }
    return -1;
  }

  public void add(int value) {
    if (!set.contains(value)) {
      list.add(value);
      set.add(value);
    } else {
      list.remove(value);
    }
  }*/

  Queue<Integer> queue;
  Map<Integer, Boolean> map;

  public FirstUniqueNumber1429(int[] nums) {

    queue = new LinkedList<>();
    map = new HashMap<>();
    for (int i : nums) {
      this.add(i);
    }
  }
  public int showFirstUnique() {
   while (!queue.isEmpty()){
     if(map.get(queue.peek())){
       return queue.peek().intValue();
     }
     queue.poll();
   }
   return -1;
  }
  public void add(int value) {
    if (!map.containsKey(value)) {
      map.put(value, true);
      queue.add(value);
    } else {
      map.put(value,false);
    }
  }

    public static void main (String args[]){
      int[] nums = {2, 3, 5};
      FirstUniqueNumber1429 firstUniqueNumber1429 = new FirstUniqueNumber1429(nums);
      System.out.println(firstUniqueNumber1429.showFirstUnique());
      firstUniqueNumber1429.add(2);
      System.out.println(firstUniqueNumber1429.showFirstUnique());
      firstUniqueNumber1429.add(3);
      System.out.println(firstUniqueNumber1429.showFirstUnique());
      firstUniqueNumber1429.add(5);

      System.out.println(firstUniqueNumber1429.showFirstUnique());
      firstUniqueNumber1429.add(1);

      System.out.println(firstUniqueNumber1429.showFirstUnique());

    }
  }
