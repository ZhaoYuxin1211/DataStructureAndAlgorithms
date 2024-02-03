package practice.yuxinzhao.algorithms.greedyAlgorithm;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexNum = data.length;

        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };

        MGraph graph = new MGraph(vertexNum);
        MinTree minTree = new MinTree();

        // Create the graph
        minTree.createGraph(graph, vertexNum, data, weight);

        // Display the original graph
        minTree.showGraph(graph);

        // Apply Prim's Algorithm to find and display the Minimum Spanning Tree
        minTree.prim(graph, 0);
    }
}

/**
 * Represents a Minimum Spanning Tree (MST) and associated operations.
 */
class MinTree {
    /**
     * Creates the graph with given data, weight, and vertex number.
     *
     * @param graph      The graph to be created.
     * @param vertexNum  The number of vertices in the graph.
     * @param data       The array containing vertex data.
     * @param weight     The 2D array containing edge weights.
     */
    public void createGraph(MGraph graph, int vertexNum, char[] data, int[][] weight) {
        for (int i = 0; i < vertexNum; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertexNum; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * Displays the adjacency matrix representation of the graph.
     *
     * @param graph The graph to be displayed.
     */
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * Applies Prim's Algorithm to find and display the Minimum Spanning Tree.
     *
     * @param graph The graph on which Prim's Algorithm is applied.
     * @param v     The starting vertex for the algorithm.
     */
    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.vertexNum];

        visited[v] = 1;
        int vertex1 = -1;
        int vertex2 = -1;
        int minWeight = 10000;

        // Iterate over all vertices in the graph
        for (int k = 1; k < graph.vertexNum; k++) {
            // Iterate over each vertex and find the minimum-weight edge connecting the visited and unvisited vertices
            for (int i = 0; i < graph.vertexNum; i++) {
                for (int j = 0; j < graph.vertexNum; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        vertex1 = i;
                        vertex2 = j;
                    }
                }
            }

            // Display the selected edge and update the visited array
            System.out.println("Edge:<" + graph.data[vertex1] + "," + graph.data[vertex2] +
                    ">, Weight:" + minWeight);
            visited[vertex2] = 1;
            minWeight = 10000;
        }
    }
}

/**
 * Represents a graph using an adjacency matrix.
 */
class MGraph {
    int vertexNum;
    char[] data;
    int[][] weight;

    /**
     * Constructs a graph with the specified number of vertices.
     *
     * @param vertexNum The number of vertices in the graph.
     */
    public MGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        data = new char[vertexNum];
        weight = new int[vertexNum][vertexNum];
    }
}