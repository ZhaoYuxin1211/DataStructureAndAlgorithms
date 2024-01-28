package practice.yuxinzhao.AVLTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int j : arr) {
            avlTree.addNode(new Node(j));
        }
        avlTree.inOrderTra();

        System.out.println("height:" + avlTree.getRoot().getHeight());
        System.out.println("left height:" + avlTree.getRoot().leftHeight());
        System.out.println("right height:" + avlTree.getRoot().rightHeight());
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void inOrderTra() {
        if (root != null) {
            root.inOrderTra();
        } else {
            System.out.println("This tree is null.");
        }
    }

}

class Node {
    private int id;
    private int value;
    private String name;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    private void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.getHeight();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.getHeight();
    }

    public int getHeight() {
        return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
    }

    public Node(int id, String name) {
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }

    public void addNode(Node node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }

        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
            }
            leftRotate();
            return;
        }

        if (leftHeight() - rightHeight() > 1){
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }

    public void inOrderTra() {
        if (this.left != null) {
            this.left.inOrderTra();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.inOrderTra();
        }
    }
}

