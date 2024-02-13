package practice.yuxinzhao.algorithms.greedyAlgorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        Graph graph = new Graph(vertex, matrix);
        graph.printGraph();
        graph.dijkstra(6);
        graph.printResult();
    }
}

class Graph {
    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex visitedVertex;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void printGraph() {
        for (int[] link : matrix
        ) {
            System.out.println(Arrays.toString(link));

        }
    }

    public void printResult() {
        visitedVertex.show();
    }

    public void dijkstra(int index) {
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);

        for (int j = 1; j < vertex.length; j++) {
            index = visitedVertex.updateArr();
            update(index);
        }
    }

    private void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = visitedVertex.getDistance(index) + matrix[index][i];
            if (!visitedVertex.isVisited(i) && len < visitedVertex.getDistance(i)) {
                visitedVertex.updatePre(i, index);
                visitedVertex.updateDistance(i, len);
            }

        }
    }
}

class VisitedVertex {
    public int[] already;
    public int[] pre;
    public int[] dis;

    public VisitedVertex(int length, int index) {
        this.already = new int[length];
        this.pre = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 65535);
        this.already[index] = 1;
        this.dis[index] = 0;
    }

    public boolean isVisited(int index) {
        return already[index] == 1;
    }

    public void updateDistance(int index, int length) {
        dis[index] = length;
    }

    public void updatePre(int pre, int index) {
        this.pre[pre] = index;
    }

    public int getDistance(int index) {
        return dis[index];
    }

    public int updateArr() {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already.length; i++) {
            if (already[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }

        already[index] = 1;
        return index;
    }

    public void show() {
        System.out.println("===============");
        for (int i : already
        ) {
            System.out.print(i + "    ");
        }
        System.out.println();
        for (int i : pre
        ) {
            System.out.print(i + "    ");
        }
        System.out.println();
        for (int i : dis
        ) {
            System.out.print(i + "    ");
        }
    }
}