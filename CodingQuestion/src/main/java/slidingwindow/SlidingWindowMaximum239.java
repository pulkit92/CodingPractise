package slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {

  Deque<Integer> dequeue = null;

  public static void main(String args[]) {
    SlidingWindowMaximum239 slidingWindowMaximum239 = new SlidingWindowMaximum239();
    int sm[] = {1, 3, 1, 2, 0, 5};
    int a[] = slidingWindowMaximum239.maxSlidingWindow(sm, 3);
    for (int x : a) {
      System.out.println(x);
    }
  }

  private void cleanDeque(int i,int k,int nums[]){
    if(!dequeue.isEmpty() && i-k==dequeue.getFirst()){
      dequeue.removeFirst();
    }
    while(!dequeue.isEmpty()&&nums[i]<nums[dequeue.getLast()]){
      dequeue.removeLast();
    }
  }
  public int[] maxSlidingWindow(int[] nums, int k) {

      int out[]=new int[nums.length-k+1];
      dequeue= new LinkedList<>();
      for(int i=0;i<k;i++){
        cleanDeque(i,k,nums);
        dequeue.addLast(i);
      }
      out[0]=nums[dequeue.getFirst()];

      for(int i=k;i<nums.length;i++){
        cleanDeque(i,k,nums);
        dequeue.addLast(i);
        out[i-k+1]=nums[dequeue.getFirst()];
      }
      int max=Integer.MIN_VALUE;

      for(int i=0;i<out.length;i++){
        max=Math.max(max,out[i]);
      }
      return out;
  }
}
