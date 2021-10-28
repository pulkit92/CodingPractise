package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  int value;
  List<GraphNode> list;

  public GraphNode() {
    list = new ArrayList<>();

  }

  public GraphNode(int value) {
    this.value = value;
    list = new ArrayList<>();
  }

  public GraphNode(int value, List<GraphNode> list) {
    this.value = value;
    this.list = list;
  }
}
