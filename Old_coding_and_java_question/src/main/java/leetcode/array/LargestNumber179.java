package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
	public static String largestNumber(int[] nums) {
		String a[] = new String[nums.length];
		boolean b=true;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				b=false;
			}
			a[i] = String.valueOf(nums[i]);

		}
		if(b)
			return "0";
		Arrays.sort(a, new comaring());
		String s = "";
		for (int i = 0; i < a.length; i++) {
				s=s+a[i];
				s=String.valueOf(Integer.parseInt(s));
		}
		return s;
	}

	public static void main(String[] args) {
		int arr[] = { 0,0,0,0};
		String a = largestNumber(arr);
		System.out.println(a);
	}

	static class comaring implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			String s1 = String.valueOf(o1) + String.valueOf(o2);
			String s2 = String.valueOf(o2) + String.valueOf(o1);
			if (s1.compareTo(s2) > 0) {
				return -1;
			} else
				return 1;
		}
	}
}
