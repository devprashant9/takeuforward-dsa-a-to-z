import java.util.Arrays;

public class AdjacencyMatrix {

    public int[][] getGraph() {
        int V = 7;
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = 0;
            }
        }

        return graph;
    }

    public int[][] getEdges() {

        int[][] edges = {
                { 6, 6 },
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 1, 4 },
                { 2, 5 },
                { 4, 5 }
        };

        return edges;
    }

    public int[][] constructGraph(int[][] graph, int[][] edges) {
        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        return graph;
    }

    public void printGraph(int[][] graph) {
        for (int[] i : graph) {
            System.out.print(Arrays.toString(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix();
        int[][] graph = g.getGraph();
        int[][] edges = g.getEdges();
        graph = g.constructGraph(graph, edges);
        g.printGraph(graph);
    }

}