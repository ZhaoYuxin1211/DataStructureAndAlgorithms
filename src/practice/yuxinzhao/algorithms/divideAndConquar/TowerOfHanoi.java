package practice.yuxinzhao.algorithms.divideAndConquar;

public class TowerOfHanoi {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }
    public static void hanoiTower(int num, char from, char aux, char to){
        if (num == 1){
            System.out.println("Move disk 1 from " + from + " to " + to);
        } else {
            // Move (num-1) disks from source to auxiliary rod
            hanoiTower(num-1, from, to, aux);

            // Move the nth disk from source to destination rod
            System.out.println("Move disk " + num + " from " + from + " to " + to);

            // Move (num-1) disks from auxiliary rod to destination rod
            hanoiTower(num -1, aux, from, to);
        }
    }
}
