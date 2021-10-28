package stack;

public class ImplementStack {
  public static void main(String args[]) {

    stack st = new stack();
    if (!st.overflow()) {
      st.push(5);
    }
    if (!st.overflow()) {
      st.push(9);
    }
    if (!st.underflow()) {
      System.out.println(st.pop());
    }
  }
}


class stack {
  int top;
  int size=5;
  int a[];

  stack( ) {
    //size = this.size;
    top = -1;
    a = new int[size];
  }

  public void push(int elem) {
    a[++top] = elem;
  }

  public int pop() {
    return a[top--];
  }

  public boolean underflow() {
    if (top <= -1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean overflow() {
    if (top > size) {
      return true;
    } else {
      return false;
    }
  }

}
