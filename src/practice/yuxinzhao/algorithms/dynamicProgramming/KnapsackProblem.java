package practice.yuxinzhao.algorithms.dynamicProgramming;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3};
        int[] value = {1500, 3000, 2000};
        int m = 4;
        int n = value.length;

        int[][] maxValue = new int[n + 1][m + 1];

        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < value.length; i++) {
            maxValue[i][0] = 0;
        }
        for (int i = 0; i < maxValue[0].length; i++) {
            maxValue[0][i] = 0;
        }

        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {
                if (weight[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
//                    maxValue[i][j] = Math.max(maxValue[i - 1][j], value[i - 1] + maxValue[i - 1][j - weight[i - 1]]);
                    if (maxValue[i - 1][j] < value[i - 1] + maxValue[i - 1][j - weight[i - 1]]){
                        maxValue[i][j] = value[i - 1] + maxValue[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    }else {
                        maxValue[i][j] = maxValue[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < maxValue.length; i++){
            for (int j = 0; j < maxValue[i].length; j++){
                System.out.print(maxValue[i][j] + "  ");
            }
            System.out.println();
        }

//        for (int i = 0; i < path.length; i++){
//            for (int j = 0; j < path[i].length; j++){
//               if (path[i][j] == 1){
//                   System.out.println("Put good no." + i + " into the bag;");
//               }
//            }
//        }

        int i = path.length -1;
        int j = path[0].length -1;
        while (i > 0 && j > 0){
            if (path[i][j] == 1){
                System.out.println("Put good no." + i + " into the bag;");
                j -= weight[i-1];
            }
            i--;
        }
    }
}
