import java.util.*;

class Kahn {

  private Map<Integer, List<Integer>> adjacencyList;
  private int vertices;

  public Kahn(int vertices) {
    this.vertices = vertices;
    this.adjacencyList = new HashMap<>();
    for (int i = 0; i < vertices; i++) {
      this.adjacencyList.put(i, new ArrayList<>());
    }
  }

  public void createEdge(int u, int v) {
    this.adjacencyList.get(u).add(v);
  }

  public void topologicalSort() {
    int[] totalIndegree = new int[vertices];
    for (int i = 0; i < vertices; i++) {
      for (int j : adjacencyList.get(i)) {
        totalIndegree[j]++;
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < vertices; i++) {
      if (totalIndegree[i] == 0) {
        queue.add(i);
      }
    }
    int visitedNodes = 0;
    List<Integer> order = new ArrayList<>();

    while (!queue.isEmpty()) {
      int u = queue.poll();
      order.add(u);

      for (int i : adjacencyList.get(u)) {
        totalIndegree[i]--;

        if (totalIndegree[i] == 0) {
          queue.add(i);
        }
      }
      visitedNodes++;
    }
    if (visitedNodes != vertices) {
      System.out.println(
        "There's a cycle present in the Graph.\nGiven graph is not DAG"
      );
    } else {
      System.out.println(order);
    }
  }

  public static void main(String[] args) {
    Kahn graph = new Kahn(6);
    graph.createEdge(0, 1);
    graph.createEdge(0, 2);
    graph.createEdge(1, 3);
    graph.createEdge(1, 5);
    graph.createEdge(2, 3);
    graph.createEdge(2, 5);
    graph.createEdge(3, 4);
    graph.createEdge(5, 4);

    graph.topologicalSort();
  }
}
