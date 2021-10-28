package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget797 {
  /*public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<Integer>[] list = new List[graph.length];
    for (int i = 0; i < graph.length; i++) {
      list[i] = new ArrayList<>();
      for (int j = 0; j < graph[i].length; j++) {
        list[i].add(graph[i][j]);
      }
    }
    List<List<Integer>> out = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(0);

    printAllPaths(0, list, temp, out);
    return out;

  }

  private void printAllPaths(int j, List<Integer>[] path, List<Integer> temp, List<List<Integer>> out) {
    if(j==path.length-1){
      out.add(new ArrayList(temp));
    }
    if (path[j].isEmpty()) {
      return;
    }
    List<Integer> list = path[j];
    for (int k : list) {
      temp.add(k);
      printAllPaths(k, path, temp, out);
      temp.remove(temp.size() - 1);
    }
  }*/


  public static void main(String args[]) {
    int graph[][] = {{4,3,1}, {3,2,4}, {3}, {4},{}};
    AllPathsFromSourceToTarget797 allPathsFromSourceToTarget797 = new AllPathsFromSourceToTarget797();
    System.out.println(allPathsFromSourceToTarget797.allPathsSourceTarget(graph));
  }

  ///applying DP
  Map<Integer, List<List<Integer>>> memo = null;

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<Integer>[] list = new List[graph.length];
    for (int i = 0; i < graph.length; i++) {
      list[i] = new ArrayList<>();
      for (int j = 0; j < graph[i].length; j++) {
        list[i].add(graph[i][j]);
      }
    }
    List<List<Integer>> out = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(0);
    memo = new HashMap<>();
    printAllPaths(0, list, temp, out);
    return out;
  }
  private void printAllPaths(int j, List<Integer>[] path, List<Integer> temp, List<List<Integer>> out) {
    if (j == path.length - 1) {
      out.add(new ArrayList(temp));
      return;
    }
    if (memo.containsKey(j)) {
    // out.addAll(memo.get(j));
      return;
    }

    if (path[j].isEmpty()) {
      return;
    }
    List<Integer> list = path[j];
    for (int k : list) {
      temp.add(k);
      printAllPaths(k, path, temp, out);
      temp.remove(temp.size() - 1);
    }
    memo.put(j,out);
  }


}
