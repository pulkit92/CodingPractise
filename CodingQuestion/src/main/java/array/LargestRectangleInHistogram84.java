package array;

import java.util.Stack;

public class LargestRectangleInHistogram84 {

  public int largestRectangleArea(int[] heights) {
    Stack<Integer> st = new Stack<>();
    int area = 0;
    for (int i = 0; i < heights.length; i++) {
      while (!st.isEmpty() && (heights[st.peek()] > heights[i])) {
        int pos = st.pop();
        area = Math.max(area, heights[pos] * (i - pos));
      }
      st.push(i);
    }
    int lastIndex = heights.length;
    while (!st.isEmpty()) {
      int pos = st.pop();
      int breadth = 0;
      if (!st.isEmpty() && heights[pos] > heights[st.peek()]) {
        breadth = lastIndex - pos;
      } else {
        breadth = lastIndex - (st.empty() ? 0 : st.peek());
      }
      int newArea = breadth * heights[pos];
      area = Math.max(area, newArea);
    }

    return area;
  }

  public static void main(String args[]) {
    LargestRectangleInHistogram84 l = new LargestRectangleInHistogram84();
    int a[] = {5,4,1,2};
    System.out.println(l.largestRectangleArea(a));
  }
}
