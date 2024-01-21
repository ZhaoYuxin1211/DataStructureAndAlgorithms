package practice.yuxinzhao.hashtable;

import java.util.Scanner;

public class HashtableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        // A simple menu
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("+++++++++++++++");
            System.out.println("add: add new employee");
            System.out.println("list: list all employees");
            System.out.println("find: find an employee by id");
            System.out.println("exit: quit the system");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("Please input the id:");
                    int id = scanner.nextInt();
                    System.out.println("Please input the name:");
                    String name = scanner.next();

                    Employee employee = new Employee(id, name);
                    hashTable.add(employee);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("Please input the id you want to find:");
                    int inputId = scanner.nextInt();
                    hashTable.findById(inputId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
            }
        }

    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    // Initialize
    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    // Add new employee
    public void add(Employee employee) {
        int employeeLinkedListNO = hashFunction(employee.id);
        empLinkedLists[employeeLinkedListNO].add(employee);
    }

    // a simple modulo operation
    public int hashFunction(int id) {
        return id % size;
    }

    public void list() {
        for (int i = 0; i < size; i++){
            empLinkedLists[i].iterate(i);
        }
    }

    public void findById(int id){
        int employeeLinkedListNO = hashFunction(id);
        Employee employee = empLinkedLists[employeeLinkedListNO].findById(id);
        if (employee!=null){
            System.out.println("The employee is: " + employee.name);
        }else {
            System.out.println("Cannot find the employee in the hash table.");
        }
    }
}

class EmpLinkedList {
    // Head node, point to the first employee (different from the linkedlist)
    private Employee head;

    // Add new employee to the linked list
    public void add(Employee employee) {
        // If it is the first node in the linked list
        if (head == null) {
            head = employee;
            return;
        }

        // Otherwise, we need to find the last node
        Employee curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = employee;
    }

    // Iterate
    public void iterate(int no) {
        if (head == null) {
            System.out.println("The "+no+"st linked list is null.");
            return;
        }

        System.out.println("The "+ no +"st linked list is:");
        Employee curEmp = head;
        while (true) {
            System.out.println("id:" + curEmp.id + " , name: " + curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println("End.");
    }

    public Employee findById(int id){
        if (head == null){
            System.out.println("This linked list is null");
            return null;
        }

        Employee curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            // find no result
            if (curEmp.next == null){
                curEmp = null;
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }

}

