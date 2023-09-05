package practice.yuxinzhao.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //normal add
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //added by order
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);


        singleLinkedList.showList();

    }

    /**
     * get the number of node in a linked list
     *
     * @param head head node
     * @return number of node
     */
    public static int getNodeLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 倒序打印单向链表
     * 使用栈（stack）实现
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转单链表
     * 1、遍历原链表
     * 2、将每个结点的下一个结点存储到next
     * 3、将处理中的结点的下一个结点，改为反转结点头后第一个结点
     * 4、将处理中的结点连接到反转结点头之后
     * 5、移动到next结点、继续处理上述步骤
     *
     * @param head
     */
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原链表，每遍历一个结点就将其取出、放在新链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //查找单链表中倒数第k个结点
    //1. 编写一个方法，接收head结点与index值
    //2. index表示单链表中的倒数第k个结点、
    //3. 先把链表从头到尾遍历一遍，得到总长度size
    //4. 从链表头开始遍历到第（size - index）个
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getNodeLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }
}

//定义单链表（Single Linked List）
class SingleLinkedList {
    //head node
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //find the last node of the linked list
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public HeroNode getHead() {
        return head;
    }

    //add the new node to the right place by order
    //if the no has existed, print error message
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean isExist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                isExist = true;
                break;
            }
            temp = temp.next;
        }

        if (isExist) {
            System.out.println("This hero could not be added for the no of him(her) has existed.");
            System.out.println("The no is " + heroNode.no + ".");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void showList() {
        if (head.next == null) {
            System.out.println("This linked list is empty.");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void delNode(int no) {
        HeroNode temp = head;
        boolean flag = false;   //whether we found the node we need to delete
        while (true) {
            if (temp.next == null) { //whether we reach the end of the nodelist
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("The node doesn't exist.");
        }
    }
}

//定义节点（Node）
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}

