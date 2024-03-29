import java.util.*;

class Graph{
    int V;
    List<List<Node>> adj;
    Graph(int v){
        V =v;
        adj = new ArrayList<>(V);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList());
        }
    }
    
    void addEdge(int source,int dest, int weight){
        Node node = new Node(dest, weight);
        adj.get(source).add(node);
    }

    void dijkstra(int startVertex){
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[startVertex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(startVertex,0));
        while(!pq.isEmpty()){
            int currentVertex = pq.poll().vertex;
            for(Node nei: adj.get(currentVertex)){
                int newDist = distance[currentVertex] + nei.weight;
                if(newDist < distance[nei.vertex]){
                    distance[nei.vertex] = newDist;
                    pq.add(new Node(nei.vertex, newDist));
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(i+" "+distance[i]+" ");
        }
    }

}

class Node{
    int weight;
    int vertex;
    Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}

class DialAlgo{
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int source = 0; // Source vertex
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 2, 1);

        graph.dijkstra(source);
    }

}