import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    public static List<List<Integer>> getGraph() {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            graph.add(new ArrayList<>());
        }

        return graph;
    }

    public static int[][] getEdges() {

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

    public static List<List<Integer>> constructGraph(List<List<Integer>> graph, int[][] edges) {
        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    public static void printGraph(List<List<Integer>> graph) {
        for (List<Integer> i : graph) {
            System.out.print(i);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = getGraph();
        int[][] edges = getEdges();
        graph = constructGraph(graph, edges);
        printGraph(graph);
    }
}