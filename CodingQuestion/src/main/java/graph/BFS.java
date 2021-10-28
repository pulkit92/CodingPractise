package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
  static Graph graph;

  public static void main(String args[]) {
    BFS bfs = new BFS();
    graph = new Graph(5);
    bfs.addGraph(0, 1);
    bfs.addGraph(0, 2);
    bfs.addGraph(1, 2);
    bfs.addGraph(2, 0);
    bfs.addGraph(2, 3);
    bfs.addGraph(3, 3);
    bfs.bfs(2);

  }

  public void addGraph(int u, int v) {
    graph.list.get(u).add(v);
  }

  private void bfs(int s) {
    boolean visited[] = new boolean[5];
    visited[s] = true;
    Queue<Integer> queue = new LinkedList<>();
    visited[s] = true;

    queue.add(2);
    while (!queue.isEmpty()) {
      int sm = queue.poll();
      System.out.println(sm);
      List<Integer> edges = graph.list.get(sm);
      for(int i:edges){
        if (!visited[i]){
          visited[i] = true;
          queue.add(i);
        }
      }


    }
  }
}


class Graph {
  List<List<Integer>> list;

  public Graph(int vertex) {
    list =new ArrayList<>();
    for (int i = 0; i < vertex; i++) {
      list.add(new ArrayList<>());
    }

  }

}
