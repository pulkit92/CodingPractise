package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms841 {
  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> m = new ArrayList<>();
    m.add(1);
    list.add(m);
    List<Integer> m1 = new ArrayList<>();
    m1.add(2);
    list.add(m1);
    List<Integer> m2 = new ArrayList<>();
    m2.add(3);
    list.add(m2);
    List<Integer> m3 = new ArrayList<>();
    list.add(m3);
    KeysAndRooms841 k = new KeysAndRooms841();
    System.out.println(k.canVisitAllRooms(list));
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Stack<Integer> st = new Stack<>();
    boolean b[] = new boolean[rooms.size()];
    st.push(0);
    b[0] = true;
    while (!st.isEmpty()) {
      int i = st.pop();
      for (int j : rooms.get(i)) {
        if (!b[j]) {
          b[j] = true;
          st.push(j);
        }
      }
    }
    for (boolean c : b) {
      if (!c) {
        return false;
      }
    }
    return true;

  }



}
