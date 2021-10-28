package leetcode.array;

import java.util.Stack;

public class NextGreaterElement {
	public static void main(String args[]) {
		int a[] = { 4,5,2,25 };
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			while (!st.isEmpty() && a[i] > st.peek()) {
				System.out.println("peel " + st.pop() + " is " + a[i]);
			}
			st.push(a[i]);
		}
		System.out.println();
	}

}
