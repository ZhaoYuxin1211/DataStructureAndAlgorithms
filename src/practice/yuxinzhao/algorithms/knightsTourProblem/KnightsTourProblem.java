package practice.yuxinzhao.algorithms.knightsTourProblem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class KnightsTourProblem {
    private static int X;
    private static int Y;
    private static boolean visited[];
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        tour(chessboard, row-1, column-1,1);

        for (int[] rows : chessboard){
            for (int step: rows){
                System.out.print(step + "   ");
            }
            System.out.println();
        }
    }

    public static void tour(int[][] chessboard, int row, int column, int step){
        chessboard[row][column] = step;
        visited[row*X + column] = true;
        ArrayList<Point> next = next(new Point(column, row));
        sort(next);
        while (!next.isEmpty()){
            Point point = next.remove(0);
            if (!visited[point.y * X + point.x]){
                tour(chessboard,point.y, point.x, step+1);
            }
        }
        if (step < X*Y && !finished){
            chessboard[row][column] = 0;
            visited[row*X + column] = false;
        }else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> points = new ArrayList<>();
        Point point1 = new Point();
        if ((point1.x = curPoint.x -2) >= 0 && (point1.y = curPoint.y-1)>=0 ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x -1) >= 0 && (point1.y = curPoint.y-2)>=0 ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x +1) < X && (point1.y = curPoint.y-2)>=0 ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x +2) < X && (point1.y = curPoint.y-1)>=0 ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x +2) < X   && (point1.y = curPoint.y+1) < Y ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x +1) < X && (point1.y = curPoint.y+2)<Y ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x -1) >= 0 && (point1.y = curPoint.y+2)<Y ){
            points.add(new Point(point1));
        }
        if ((point1.x = curPoint.x -2) >= 0 && (point1.y = curPoint.y+1)<Y ){
            points.add(new Point(point1));
        }
        return points;
    }

    public static void sort(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2){
                    return -1;
                }else if (count1 == count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
