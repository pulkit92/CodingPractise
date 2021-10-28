package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HappyNumber {
  public boolean isHappy(int n) {
    boolean b = false;
    int sum = n;
    if (n == 1 || n == 7) {
      return true;
    }
    while (sum > 9) {
      int pow = 0;
      for (int i = sum; i > 0; i = i / 10) {
        pow = pow + (int) Math.pow(i % 10, 2);
      }
      if (pow == 1) {
        b = true;
        break;
      } else {
        sum = pow;
      }
    }
    if (sum == 7) {
      return true;
    }
    return b;
  }

  public static void main(String args[]) {
    HappyNumber h = new HappyNumber();
    Map<Integer, Integer> map=new HashMap<>();
    Set <Integer> list=map.keySet();
    if(4>3){
      System.out.println(true);
    }
    //System.out.println(h.isHappy(19));
  }
}
