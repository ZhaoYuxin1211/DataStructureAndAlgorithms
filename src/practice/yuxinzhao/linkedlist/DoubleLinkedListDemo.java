package practice.yuxinzhao.linkedlist;

import javax.security.auth.kerberos.DelegationPermission;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList {
    //head node
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //iterate
    public void showList() {
        if (head.next == null) {
            System.out.println("This linked list is empty.");
            return;
        }

        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }
    }

    //create
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        //find the last node of the linked list
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }
        //this part is different from singly linked list
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //update
    public void update(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("The list is empty.");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode2.name;
            temp.nickName = head.nickName;
        } else {
            System.out.println("Cant find the needed node.");
        }
    }

    //delete
    //we need to find the node itself
    //then we delete it
    //unlike singly ones which we need to find the node before the need-to-delete one
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("This list is empty.");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            //!!ATTENTION!!
            temp.pre.next = temp.next;
            //if the node we need to delete is the last node in the list
            //then we need not to modify "temp.next"
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("The node didn't exist.");
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int hNo, String hName, String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}
