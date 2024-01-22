package practice.yuxinzhao.tree;

import javax.xml.crypto.KeySelector;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node first = new Node(1, "first");
        Node second = new Node(2, "Second");
        Node third = new Node(3, "Third");
        Node forth = new Node(4, "Forth");

        first.setLeft(second);
        first.setRight(third);
        third.setRight(forth);
        binaryTree.setRoot(first);

        System.out.println("Preorder traversal:");
        binaryTree.preOrder();

        System.out.println("Inorder traversal:");
        binaryTree.inOrder();

        System.out.println("Postorder traversal:");
        binaryTree.postOrder();
    }
}

class BinaryTree{
    private Node root;

    public void setRoot(Node root){
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("The current Binary Tree is null.");
        }
    }

    public void inOrder(){
        if (this.root != null){
            this.root.inOrder();
        }else {
            System.out.println("The current Binary Tree is null.");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("The current Binary Tree is null.");
        }
    }


}

class Node {
    private int id;
    private String name;
    private Node left;
    private Node right;

    public Node() {

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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // The preorder, inorder traversal, and postorder traversal of a binary tree.
    public void preOrder() {
        // parent
        System.out.println(this);

        // left
        if (this.left != null) {
            this.left.preOrder();
        }
        // right
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void inOrder(){
        // left
        if (this.left != null){
            this.left.inOrder();
        }

        //parent
        System.out.println(this);

        // right
        if (this.right != null){
            this.right.inOrder();
        }
    }

    public void postOrder(){
        // left
        if (this.left != null){
            this.left.postOrder();
        }

        // right
        if (this.right != null){
            this.right.postOrder();
        }

        // parent
        System.out.println(this);
    }
}
