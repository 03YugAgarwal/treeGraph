import java.util.*;

class Graph{
    int V;
    LinkedList<Integer> adj[];
    boolean[] visited;
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[v];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFS(int s){
        visited[s] = true;
        System.out.print(s+" ");
        Iterator<Integer> ite = adj[s].listIterator();
        while(ite.hasNext()){
            int m = ite.next();
            if(!visited[m]){
                DFS(m);
            }
        }
    }

}

class DFSGraph{
    public static void main(String args[]){
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,3);

        g.DFS(2);

    }
}