import java.util.Stack;

public class DesignBrowserHistory {

  private Stack<String> stack1 = null;
  private Stack<String> stack2 = null;

  public DesignBrowserHistory(String homepage) {

    stack1 = new Stack<>();
    stack2 = new Stack<>();
    stack1.add(homepage);
  }

  public void visit(String url) {
    stack1.add(url);

    stack2.clear();
  }

  public String back(int steps) {
    while (steps > 0 && stack1.size() > 1) {
      stack2.push(stack1.pop());
      steps--;
    }
    return stack1.peek();
  }

  public String forward(int steps) {

    while (steps > 0 && !stack2.isEmpty()) {
      stack1.push(stack2.pop());
      steps--;
    }
    return stack1.peek();
  }

  public static void main(String args[]) {
    DesignBrowserHistory browserHistory = new DesignBrowserHistory("leetcode.com");
   /* browserHistory.visit("kni.com");     // You are in "google.com". Visit "facebook.com"
    System.out.println(browserHistory.back(7));                   // You are in "youtube.com", move back to "facebook
    // .com" return
    // "facebook.com"
    System.out.println(browserHistory.back(7));                   // You are in "facebook.com", move back to "google
    // .com" return "google.com"
    System.out.println(browserHistory.forward(5));                // You are in "google.com", move forward to
    // "facebook.com" return "facebook.com"
    System.out.println(browserHistory.forward(1));                // You are in "linkedin.com", you cannot move
    browserHistory.visit("pwrrbnw.com");     // You are in "google.com". Visit "facebook.com"
    browserHistory.visit("mosohif.com");     // You are in "google.com". Visit "facebook.com"
    System.out.println(browserHistory.back(9));  */                 // You are in "facebook.com", move back to "google
    browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
    browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
    browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
    System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to
    // "facebook.com" return "facebook.com"
    System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to
    // "google.com" return "google.com"
    System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to
    // "facebook.com" return "facebook.com"
    browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
    System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move
    // forward any steps.
    System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two
    // steps to "facebook.com" then to "google.com". return "google.com"
    System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back
    // only one step to "leetcode.com". return "leetcode.com"
  }
}


