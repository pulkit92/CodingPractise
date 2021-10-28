package com.expense.management;

import java.util.*;

class GFG {

  static final int N = 100000;

  // variables to be used
  // in both functions
  @SuppressWarnings("unchecked")
  static ArrayList<Integer>[] graph = new ArrayList[N];
  @SuppressWarnings("unchecked")
  static Vector<Integer>[] cycles = new Vector[N];
  static int cyclenumber;

  // Function to mark the vertex with
  // different colors for different cycles
  static void dfs_cycle(int u, int p, int[] color,
      int[] mark, int[] par) {

    // already (completely) visited vertex.
    if (color[u] == 2) {
      return;
    }

    // seen vertex, but was not completely visited -> cycle detected.
    // backtrack based on parents to find the complete cycle.
    if (color[u] == 1) {

      cyclenumber++;
      int cur = p;
      mark[cur] = cyclenumber;

      // backtrack the vertex which are
      // in the current cycle thats found
      while (cur != u) {
        cur = par[cur];
        mark[cur] = cyclenumber;
      }
      return;
    }
    par[u] = p;

    // partially visited.
    color[u] = 1;

    // simple dfs on graph
    for (int v : graph[u]) {

      // if it has not been visited previously
      if (v == par[u]) {
        continue;
      }
      dfs_cycle(v, u, color, mark, par);
    }

    // completely visited.
    color[u] = 2;
  }

  // add the edges to the graph
  static void addEdge(int u, int v) {
    graph[u].add(v);
    graph[v].add(u);
  }

  // Function to print the cycles
  static List<Integer> printCycles(int edges, int mark[]) {

    // push the edges that into the
    // cycle adjacency list
    for (int i = 1; i <= edges; i++) {
      if (mark[i] != 0) {
        cycles[mark[i]].add(i);
      }
    }
    List<Integer> list = new ArrayList<>();
    // print all the vertex with same cycle
    for (int i = 1; i <= cyclenumber; i++) {
      // Print the i-th cycle
      System.out.printf("Cycle Number %d: ", i);
      for (int x : cycles[i]) {
        list.add(x);
      }
      System.out.println();
    }
    return list;
  }

  // Driver Code
  public static void main(String[] args) {

    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
      cycles[i] = new Vector<>();
    }

    // add edges
    addEdge(4, 4);
    addEdge(1, 3);
    addEdge(4, 3);
    addEdge(4, 2);
    addEdge(1, 2);


    // arrays required to color the
    // graph, store the parent of node
    int[] color = new int[N];
    int[] par = new int[N];

    // mark with unique numbers
    int[] mark = new int[N];

    // store the numbers of cycle
    cyclenumber = 0;
    int edges = 5;

    // call DFS to mark the cycles
    dfs_cycle(1, 0, color, mark, par);

    // function to print the cycles
    List<Integer> list = printCycles(edges, mark);
    nearestTown(graph, edges, list, list.size());

  }

  static List<Integer> nearestTown(ArrayList<Integer> graph[],
      int n, List<Integer> sources, int s) {
List<Integer> list=new ArrayList<>();
    // Create a queue for BFS
    Queue<Integer> q = new LinkedList<>();

    // Mark all the source vertices as
    // visited and enqueue it
    for (int i = 0; i < s; i++) {
      q.add(sources.get(i));
      visited[sources.get(i)] = true;
    }

    Multisource_BFS(graph, q);

    // Printing the distances
    for (int i = 1; i <= n; i++) {
        list.add(dist[i]);
      System.out.println(i + " " + dist[i]);
    }
    return list;
  }
    static int dist[] = new int[N];

    //This boolean array is true if the current vertex
    // is visited otherwise it is false
    static boolean visited[] = new boolean[N];
    static void Multisource_BFS(ArrayList<Integer> graph[],
        Queue<Integer>q)
    {
        while (!q.isEmpty())
        {
            int k = q.peek();
            q.poll();

            for(int i:graph[k])
            {
                if (!visited[i])
                {

                    // Pushing the adjacent unvisited vertices
                    // with distance from current source = this
                    // vertex's distance + 1
                    q.add(i);
                    dist[i] = dist[k] + 1;
                    visited[i] = true;
                }
            }
        }
    }

}

// This code is contributed by
// sanjeev2552