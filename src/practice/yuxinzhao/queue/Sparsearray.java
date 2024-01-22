package practice.yuxinzhao.queue;

public class Sparsearray {
    //    稀疏数组
    public static void main(String[] args) {
        //  原始二维数组
        int[][] chessArrayOri = new int[11][11];
        chessArrayOri[1][2] = 1;
        chessArrayOri[2][4] = 2;

        for (int[] row : chessArrayOri) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        //  二维数组转稀疏数组
        int sum = 0;
        for (int i = 0; i < chessArrayOri.length; i++) {
            for (int j = 0; j < chessArrayOri.length; j++){
                if (chessArrayOri[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        //  创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = chessArrayOri.length;
        sparseArray[0][1] = chessArrayOri[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArrayOri.length; i++) {
            for (int j = 0; j < chessArrayOri.length; j++){
                if (chessArrayOri[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArrayOri[i][j];
                }
            }
        }

        System.out.println("===================================");
        for (int[] row : sparseArray) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        // 稀疏数组转二维数组
        int[][] chessArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++){
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("==========================================");
        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
