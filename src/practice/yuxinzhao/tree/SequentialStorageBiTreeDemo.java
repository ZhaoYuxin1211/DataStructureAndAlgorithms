package practice.yuxinzhao.tree;

public class SequentialStorageBiTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        SequentialStorageBiTree biTree = new SequentialStorageBiTree(arr);
        biTree.preOrder(0);
    }
}

class SequentialStorageBiTree{
    private int[] arr;

    public SequentialStorageBiTree(int[] arr){
        this.arr = arr;
    }

    /**
     *
     * @param index index in the arr
     */
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("The arr is null.");
            return;
        }

        // parent
        System.out.println(arr[index]);

        // left
        if ((index * 2 + 1) < arr.length){
            preOrder(index * 2 + 1);
        }

        //right
        if ((index * 2 + 2) < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}
