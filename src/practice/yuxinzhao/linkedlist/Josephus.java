package practice.yuxinzhao.linkedlist;


//环形单向链表分析解决约瑟夫问题
//use singly linked list to solve Josephus problem

//n个人围成一圈
//从编号为k的人开始
//每m个人出列一个
public class Josephus {
    public static void main(String[] args) {
        CircleSinglyLinkedList circleSinglyLinkedList = new CircleSinglyLinkedList();
        circleSinglyLinkedList.addNode(5);
        circleSinglyLinkedList.showList();

        //test the Josephus
        circleSinglyLinkedList.josephus(1,2,5);
    }
}

class CircleSinglyLinkedList {
    private Node first = new Node(-1);

    public void addNode(int nums) {
        if (nums < 1) {
            System.out.println("nums should not be smaller than 1.");
            return;
        }

        Node curNode = null;
        for (int i = 1; i <= nums; i++) {
            Node child = new Node(i);
            if (i == 1) {
                first = child;
                first.setNext(first);
                curNode = first;
            } else {
                curNode.setNext(child);
                curNode = child;
                child.setNext(first);
            }
        }
    }

    //iterate
    public void showList() {
        //whether the list is empty
        if (first == null) {
            System.out.println("This list is empty.");
            return;
        }
        Node curNode = first;
        while (true) {
            System.out.println("The number of node is " + curNode.getNo());
            if (curNode.getNext() == first) {
                break;
            } else {
                curNode = curNode.getNext();
            }
        }
    }

    /**
     * solve Josephus problem by Circle Single Linked List
     * 1、创建helper指针，开始时指向环形链表最后一个结点
     * 2、开始count时，count m次即将first和helper同时移动m-1次
     * 3、然后将数到的结点出列
     *
     * @param startNo  start from it
     * @param countNum every 'countNum' get one node
     * @param sum      original number of nodes
     */
    public void josephus(int startNo, int countNum, int sum) {
        if (first == null || startNo < 1 ||startNo>sum){
            System.out.println("There's something wrong with the list or the augments.");
            return;
        }

        //create a helper and point it to the last node
        Node helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //move first and helper point to the startNo
        for (int i = 0; i < startNo -1; i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //start the count process
        while (true){
            //only one node left in the list
            if (helper == first){
                break;
            }

            for (int i = 0; i <countNum-1; i++){
                first = first.getNext();
                helper = helper.getNext();
            }

            //get the 'first' node
            System.out.println("Get the '" + first.getNo() +"' node");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("The last node is " + first.getNo());
    }
}

class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
