package stack;

import java.util.Stack;

public class NextGreaterElementGFG {
  void printNGE(int arr[]) {
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!st.isEmpty() && arr[i] > st.peek()) {
        System.out.println("element " + st.pop() + " greater " + arr[i]);
      }
      st.push(arr[i]);
    }
    if (!st.isEmpty()) {
      System.out.println("element " + st.pop() + " greater " + -1);
    }

  }

  public static void main(String args[]) {
    NextGreaterElementGFG n = new NextGreaterElementGFG();
    int a[] = {4, 5, 2, 25};
    n.printNGE(a);
  }
}
