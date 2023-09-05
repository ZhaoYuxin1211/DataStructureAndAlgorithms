package practice.yuxinzhao.recursion;

//Maze Backtracking Problem: Use a recursive method to find the exit route of the maze.
public class Maze {
    public static void main(String[] args) {
        //Create a two-dimensional array to simulate the maze.
        int[][] map = new int[8][7];
        // value 1 means the wall
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        //original map
        System.out.println("The original map:");
        showMap(map);
        System.out.println("");

        //set way to exit
        setWay(map, 1, 1);

        //result
        System.out.println("Route: ");
        showMap(map);

    }

    public static void showMap(int[][] map){
        //output the maze
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * find a route simply without considering the shortest route
     *
     * @param map maze
     * @param i   current location x
     * @param j   current location y
     * @return if the current location is the exit
     */
    public static boolean setWay(int[][] map, int i, int j) {
        // 1. started from (1,1)
        // 2. exit at (6,5)
        // 3. value 0 represents unexplored path, 1 represents walls,
        //      2 represents a clear path, and 3 represents a dead end.
        // 4. When exploring the maze, we follow the order of
        //      down -> right -> up -> left
        if (map[6][4] == 2) {
            return true;    //find the exit
        } else {
            if (map[i][j] == 0) {    // unexplored path
                map[i][j] = 2; // assuming that this point is accessible.

                if (setWay(map, i + 1, j)) {   //down
                    return true;
                } else if (setWay(map, i, j + 1)) { //right
                    return true;
                } else if (setWay(map, i - 1, j)) { //up
                    return true;
                } else if (setWay(map, i, j - 1)) { //left
                    return true;
                } else {
                    //it is a dead end
                    map[i][j] = 3;
                    return false;
                }
            } else {    // 1, 2 or 3, means explored
                return false;
            }
        }
    }
}
