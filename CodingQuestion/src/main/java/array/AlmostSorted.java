package array;

import java.util.HashMap;
import java.util.Map;

public class AlmostSorted {
  static int  findPivot(int[] nums){
    Map<Integer,Integer> map1=new HashMap<>();


    int end=nums.length;
    int start=0;
    while(end>start){
      int mid=(start+end)/2;
      if(mid>0&& nums[mid-1]>nums[mid]){
        return mid-1;
      }
      else if(mid<nums.length-1&& nums[mid]>nums[mid+1]){
        return mid;
      }
      else if(nums[start]<nums[mid]){
        start=mid+1;
      }
      else
      {
        end =mid-1;
      }
    }
    return nums.length-1;

  }
  public static void main(String args[]) {
    String sna="pcs-ing-tenable-collector";
    System.out.println(sna.length());
    int a[] = {1,4,5};
    //System.out.println(findPivot(a));
  }
}
