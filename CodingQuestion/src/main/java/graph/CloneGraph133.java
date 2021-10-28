package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph133 {
  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) {
      return null;
    }
    GraphNode newNode = new GraphNode(node.value);
    Queue<GraphNode> queue = new LinkedList<>();
    queue.add(node);
    Map<GraphNode, GraphNode> map = new HashMap<>();
    map.put(node, newNode);
    while (!queue.isEmpty()) {
      GraphNode temp = queue.poll();
      GraphNode x1 = map.get(temp);
      if (temp.list != null) {
        List<GraphNode> list = temp.list;
        for (GraphNode x : list) {
          if (!map.containsKey(x)) {
            GraphNode graphNode=new GraphNode(x.value);
            map.put(x, graphNode);
            x1.list.add(graphNode);
            queue.add(x);
          }
        }
      }
    }
    return newNode;
  }


  public static void main(String args[]) {
    GraphNode node1 = new GraphNode(1);
    GraphNode node2 = new GraphNode(2);
    GraphNode node3 = new GraphNode(3);
    GraphNode node4 = new GraphNode(4);
    node1.list.add(node2);
    node1.list.add(node4);
    node2.list.add(node3);
    node2.list.add(node1);
    node3.list.add(node2);
    node3.list.add(node4);
    node4.list.add(node1);
    node4.list.add(node4);
    CloneGraph133 cloneGraph133 = new CloneGraph133();
    System.out.println(cloneGraph133.cloneGraph(node1));
  }
}
