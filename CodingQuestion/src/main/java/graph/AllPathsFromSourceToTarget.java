package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllPathsFromSourceToTarget {
  Map<String, List<String>> cities = null;

  public AllPathsFromSourceToTarget() {
    cities = new HashMap<>();
  }

  public void addRoute(String src, String dst) {
    List<String> conn = cities.getOrDefault(src, new ArrayList<>());
    conn.add(dst);
    cities.put(src, conn);
  }

  public List<List<String>> printRoutes(String src, String dst) {
    if (!cities.containsKey(src)) {
      return new ArrayList<>();
    }
    List<List<String>> out = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    List<String> value = cities.get(src);
    List<String> temp = new ArrayList<>();
    temp.add(src);
    printRoutesFrmSrcToDest(src, dst, out, visited, temp);

    return out;
  }

  private void printRoutesFrmSrcToDest(String src, String dest, List<List<String>> out, Set<String> visited,
      List<String> temp) {
    if (src.equals(dest)) {
      out.add(new ArrayList<>(temp));
    }
    if (!cities.containsKey(src)) {
      return;
    }
    visited.add(src);

    List<String> newPath = cities.get(src);
    for (String path : newPath) {
      if (!visited.contains(path)) {
        temp.add(path);
        printRoutesFrmSrcToDest(path, dest, out, visited, temp);
        temp.remove(path);
      }
    }
    visited.remove(src);
  }

  public static void main(String args[]) {
    AllPathsFromSourceToTarget sourceToTarget = new AllPathsFromSourceToTarget();
    sourceToTarget.addRoute("bombay", "delhi");
    sourceToTarget.addRoute("bombay", "madras");
    sourceToTarget.addRoute("bombay", "calcutta");
    sourceToTarget.addRoute("madras", "bombay");
    sourceToTarget.addRoute("madras", "delhi");
    sourceToTarget.addRoute("delhi", "calcutta");
    sourceToTarget.addRoute("calcutta", "delhi");



    System.out.println(sourceToTarget.printRoutes("madras", "calcutta"));

  }
}
