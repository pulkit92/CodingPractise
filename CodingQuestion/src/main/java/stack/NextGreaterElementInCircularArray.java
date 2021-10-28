package stack;

import java.util.Stack;

public class NextGreaterElementInCircularArray {
    public int[] nextGreaterElements(int[] nums) {
        int a[]=new int[nums.length];
        int length=nums.length;
        Stack<Integer> stack=new Stack<>();
        for(int i= nums.length*2-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[i%length]){
                stack.pop();
            }
            a[i%length]=stack.isEmpty()?-1:nums[stack.peek()];
            stack.add(i%length);
        }
        return a;
    }
    public static void main(String args[]){
        int nums[]={1,2,3,4,3};
        NextGreaterElementInCircularArray nextGreaterElementInCircularArray= new NextGreaterElementInCircularArray();
        System.out.println(nextGreaterElementInCircularArray.nextGreaterElements(nums));
    }
}
