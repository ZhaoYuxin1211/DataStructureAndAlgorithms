package practice.yuxinzhao.algorithms.greedyAlgorithm;

import java.util.Arrays;

public class KruskalAlgorithm {
    private int edgeNum;
    private char[] vertex;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][]{
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertex, weight);
        kruskalAlgorithm.print();
//        EdgeData[] edges = kruskalAlgorithm.getEdges();
//        System.out.println(Arrays.toString(edges));
//        kruskalAlgorithm.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
        kruskalAlgorithm.kruskal();
    }

    public KruskalAlgorithm(char[] vertex, int[][] matrix) {
        int vertexNum = vertex.length;

        this.vertex = new char[vertexNum];
        System.arraycopy(vertex, 0, this.vertex, 0, vertex.length);

        this.matrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vertexNum);
        }

        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal(){
        int index = 0;
        int[] ends = new int[edgeNum];
        EdgeData[] results = new EdgeData[edgeNum];

        EdgeData[] edges = getEdges();
        sortEdges(edges);

        for (int i = 0; i < edgeNum; i++) {
            int point1 = getVertexIndex(edges[i].start);
            int point2 = getVertexIndex(edges[i].end);

            int m = getEnd(ends, point1);
            int n = getEnd(ends, point2);
            if (m != n){
                ends[m] = n;
                results[index++] = edges[i];
            }
        }

        System.out.println("The minimum spanning tree: " + Arrays.toString(results));
    }

    public void print() {
        System.out.println("Adjacency Matrix:\n");
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void sortEdges(EdgeData[] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EdgeData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    private int getVertexIndex(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (ch == vertex[i]) {
                return i;
            }
        }
        return -1;
    }

    private EdgeData[] getEdges() {
        int index = 0;
        EdgeData[] edges = new EdgeData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EdgeData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] ends, int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }
}

class EdgeData {
    char start;
    char end;
    int weight;

    public EdgeData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" + start +
                ", " + end +
                ", " + weight +
                '}';
    }
}
