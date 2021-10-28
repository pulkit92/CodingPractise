package map;

import dp.LongestPalindromicSubstringExpnadFrmCenter;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int count =0;
    for(int i=0;i<nums.length-1;i++){
      int sum=nums[i];
      if(sum==k){
        count ++;
      }
      for(int j=i+1;j<nums.length;j++){
        sum=sum+nums[j];
        if(sum==k){
          count ++;
        }
      }
    }
    if(nums[nums.length-1]==k){
      count ++;
    }
    return count;
  }
  public static void main(String args[]) {
    int a[]={1,2,3};
    int sume=3;
    SubarraySumEqualsK subarraySumEqualsK =
        new SubarraySumEqualsK();
    System.out.println(subarraySumEqualsK.subarraySum(a,sume));
  }
}
