package practice.yuxinzhao.recursion;

//The Eight Queens Problem is a classic chess puzzle
// that involves placing eight queens on a chessboard in such a way
// that no two queens threaten each other.
// This means that no two queens can share
// the same row, column, or diagonal.
// The challenge is to find all possible solutions to this problem.
public class EightQueens {
    int max = 8;
    //Define an array to store the positions where the queens are placed.
    int[] array = new int[max];
    //count the number of methods
    static int count = 0;

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.place(0);
        System.out.println("There are " + count + " kinds of methods to solve the eight queens problem.");
    }

    /**
     * Place chess pieces in a recursive manner.
     *
     * @param n the nth queen
     */
    public void place(int n) {
        if (n == max) {
            printResult();
            count++;
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (ifNotConflict(n)) {
                place(n + 1);
            }
        }
    }

    /**
     * Check whether the newly placed chess piece conflicts with the previous ones.
     *
     * @param n the nth queen
     * @return if the queen could be placed at this place
     */
    public boolean ifNotConflict(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || // on the same coloum
                    Math.abs(n - i) == Math.abs(array[n] - array[i])) {  // on the same diagonal
                return false;
            }
        }
        return true;
    }

    public void printResult() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
