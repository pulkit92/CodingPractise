import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintValidCombos {
  public static void main(String args[]) {
    PrintValidCombos p = new PrintValidCombos();
    p.printValid(2);
  }

 /* public void printValid(int n) {

    List<String> out = new ArrayList<>();
    String sna = "";
    backtrack(sna, 0, 0, n);
  }

  private void backtrack(String sna, int openBracket, int closeBracket, int n) {
    if (sna.length() == 2 * n) {
      System.out.println(sna);
      return;
    }
    if (openBracket < n) {
      backtrack(sna + "(", openBracket + 1, closeBracket, n);
    }
    if (closeBracket < openBracket) {
      backtrack(sna + ")", openBracket, closeBracket + 1, n);
    }

  }*/

  public void printValid(int n) {
    bfs(n);
  }

  public void bfs( int n) {
    Queue<ParanthesisString> queue = new LinkedList<>();
    queue.add(new ParanthesisString("", 0, 0));
    while (!queue.isEmpty()) {
      ParanthesisString ps = queue.poll();
      if (ps.open == n && ps.close == n) {
        System.out.println(ps.sna);
      } else {
        if (ps.open < n) {
          queue.add(new ParanthesisString(ps.sna + "(", ps.open + 1, ps.close));
        }
        if (ps.open > ps.close) {
          queue.add(new ParanthesisString(ps.sna + ")", ps.open, ps.close + 1));
        }
      }
    }
  }

  class ParanthesisString {
    public ParanthesisString(String sna, int open, int close) {
      this.sna = sna;
      this.close = close;
      this.open = open;
    }

    String sna;
    int open, close;

  }



}

