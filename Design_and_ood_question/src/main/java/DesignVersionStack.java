import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

public class DesignVersionStack {
  Map<Integer, VersionNode> map = new HashMap<>();
  int version = 1;
  int count = 0;

  public void push(int element) {
    count = count + 1;
    if (!map.containsKey(version)) {
      map.put(version, new VersionNode(count, "push", element));
      return;
    }
    VersionNode versionNode = map.get(version);
    VersionNode newVersionNode = new VersionNode(count, "push", element);
    newVersionNode.setVersionNode(versionNode);
    version = version + 1;
    map.put(version, newVersionNode);
  }

  public int pop() {
    count = count - 1;
    VersionNode newVersionNode = new VersionNode(count, "pop", null);
    int oldValue = map.get(version).getElement();
    newVersionNode.setVersionNode(map.get(version));
    version = version + 1;
    map.put(version, newVersionNode);
    return oldValue;
  }
  ///4,3,2

  public int peek(int version) {
    if (map.get(version).getOperation().equals("push")) {
      return map.get(version).getElement();
    }
    Stack<String> stack = new Stack<>();
    VersionNode temp = map.get(version);
    while (temp != null) {
      if (temp.getOperation() == "pop") {
        stack.push("pop");
        temp=temp.getVersionNode();
        continue;
      }
      if (stack.isEmpty()){
        return temp.getElement();
      }
      stack.pop();
      temp=temp.getVersionNode();
    }
    return -1;

  }

  public List<Integer> getAllElements(int version) {
    List<Integer> list = new ArrayList<>();
    VersionNode versionNode = map.get(version);
    int count = versionNode.getCount();
    int i = 1;
    Stack<String> stack = new Stack<>();
    while (i <= count && versionNode != null) {
      if (versionNode.getOperation().equals("pop")) {
        versionNode = versionNode.getVersionNode();
        stack.push("pop");
        continue;
      }
      if (stack.isEmpty()) {
        list.add(versionNode.getElement());
        versionNode = versionNode.getVersionNode();
        i++;
      } else {
        versionNode = versionNode.getVersionNode();
        stack.pop();
      }
    }
    return list;
  }

  public static void main(String args[]) {
    DesignVersionStack designVersionStack = new DesignVersionStack();
    designVersionStack.push(2);//1
    designVersionStack.push(3);//2
    designVersionStack.push(8);//3
    designVersionStack.push(1);//4
    System.out.println(designVersionStack.peek(2));
    System.out.println(designVersionStack.peek(4));
    designVersionStack.push(10);//5
    System.out.println(designVersionStack.pop());//6
    designVersionStack.push(20);//7
    designVersionStack.push(9);//8
    designVersionStack.pop();
    System.out.println(designVersionStack.peek(6));
    System.out.println(designVersionStack.getAllElements(6));
    System.out.println(designVersionStack.getAllElements(8));

  }

}


class VersionNode {
  private int count;
  private String operation;
  private Integer element;
  private VersionNode versionNode;

  public VersionNode(int count, String operation, Integer element) {
    this.count = count;
    this.operation = operation;
    versionNode = null;
    this.element = element;
  }

  public void setVersionNode(VersionNode VersionNode) {
    this.versionNode = VersionNode;
  }

  public int getCount() {
    return count;
  }

  public String getOperation() {
    return operation;
  }

  public VersionNode getVersionNode() {
    return versionNode;
  }

  public void setElement(Integer element) {
    this.element = element;
  }

  public Integer getElement() {
    return element;
  }

}

