package array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray525 {
  /*public int findMaxLength(int[] nums) {
    int[] arr = new int[2 * nums.length + 1];
    Arrays.fill(arr, -2);
    arr[nums.length] = -1;
    int maxlen = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 0 ? -1 : 1);
      if (arr[count + nums.length] >= -1) {
        maxlen = Math.max(maxlen, i - arr[count + nums.length]);
      } else {
        arr[count + nums.length] = i;
      }

    }
    return maxlen;
  }*/

  public static void main(String arrgs[]) {

    int nums[] = {0, 1};
    ContiguousArray525 c = new ContiguousArray525();
    System.out.println(c.findMaxLength(nums));
  }

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map=new HashMap<>();
    int maxlen = 0, count = 0;
    map.put(0,-1);
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 0 ? -1 : 1);
      if(map.containsKey(count)){
        maxlen=Math.max(maxlen,i-map.get(count));
      }
      else {
        map.put(count,i);
      }
    }
    return maxlen;
  }
}


