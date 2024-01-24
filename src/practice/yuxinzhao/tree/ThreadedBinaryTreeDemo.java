package practice.yuxinzhao.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        ThreadedNode root = new ThreadedNode(1, "11");
        ThreadedNode second = new ThreadedNode(3, "33");
        ThreadedNode third = new ThreadedNode(6, "66");
        ThreadedNode forth = new ThreadedNode(8, "88");
        ThreadedNode fifth = new ThreadedNode(10, "10");
        ThreadedNode sixth = new ThreadedNode(14, "14");

        root.setLeft(second);
        root.setRight(third);
        second.setLeft(forth);
        second.setRight(fifth);
        third.setLeft(sixth);

        tree.setRoot(root);
        tree.threadedNodes();

        //test
        ThreadedNode leftNode = fifth.getLeft();
        ThreadedNode rightNode = fifth.getRight();
        System.out.println("The predecessor node of the fifth node is: " + leftNode);
        System.out.println("The successor node of the fifth node is: " + rightNode);

        // traversal
        System.out.println("Threaded binary tree traversal");
        tree.threadedTraversal();
    }
}

class ThreadedBinaryTree {
    private ThreadedNode root;
    private ThreadedNode pre = null;

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    // traversal
    public void threadedTraversal(){
        ThreadedNode node = root;
        while (node != null){
            // left
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            // print the current node
            System.out.println(node);
            // successor
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            // right
            node = node.getRight();
        }
    }

    // Inorder threaded
    public void threadedNodes(ThreadedNode node){
        if (node == null){
            return;
        }

        // left
        threadedNodes(node.getLeft());
        // parent (IMPORTANT!)
        // predecessor node
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // successor node
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        // right
        threadedNodes(node.getRight());
    }
}

class ThreadedNode {
    private int id;
    private String name;
    private ThreadedNode left;
    private ThreadedNode right;
    // 0: left child tree; 1: predecessor node
    private int leftType;
    // 0: right child tree; 1: successor node
    private int rightType;

    public ThreadedNode() {

    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadedNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadedNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
