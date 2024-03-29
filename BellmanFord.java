import java.util.*;

class Graph{
    class Edge{
        int weight;
        int src;
        int dest;
        Edge(int s, int d, int w){
            weight = w;
            src = s;
            dest = d;
        }
    }
    int V, E;
    Edge edge[];
    Graph(int v, int e){
        V =v;
        E = e;
        edge = new Edge[e];
    }

    void bellmanFord(int src){
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int i=1;i<V;i++){
            for(int j=0;j<E;j++){
                int u = edge[j].src;
                int v = edge[j].dest;
                int w = edge[j].weight;
                if(dist[u] != Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(i+" "+dist[i]+" ");
        }
    }

}

class BellmanFord{
    public static void main(String args[]){
        int V = 5;
        int E = 7;
        Graph graph = new Graph(V, E);
        graph.edge[0] = graph.new Edge(0, 1, 5);
        graph.edge[1] = graph.new Edge(0, 2, 4);
        graph.edge[2] = graph.new Edge(1, 3, 3);
        graph.edge[3] = graph.new Edge(2, 1, 6);
        graph.edge[4] = graph.new Edge(3, 2, 2);
        graph.edge[5] = graph.new Edge(1, 4, -4);
        graph.edge[6] = graph.new Edge(4, 2, 2);
        graph.bellmanFord(0); 
    }
}