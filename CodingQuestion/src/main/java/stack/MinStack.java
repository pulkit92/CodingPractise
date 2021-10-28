package stack;

public class MinStack {
  Elem top;

  public MinStack() {
  }

  public void push(int x) {
    if (top == null) {
      top = new Elem(x, x);
    } else {
      int min = top.min;
      Elem el = new Elem(x, Math.min(x, min));
      el.next = top;
      top = el;
    }

  }

  public void pop() {
    if (top != null) {
      Elem elem = top.next;
      top = elem;
    }
  }

  public int top() {
    if (top != null) {
      return top.value;
    }
    return 0;
  }

  public int getMin() {
    return top.min;
  }

  public static void main(String args[]) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();

    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}


class Elem {
  int value;
  int min;
  Elem next;

  public Elem(int value, int min) {
    this.value = value;
    this.min = min;
  }
}

