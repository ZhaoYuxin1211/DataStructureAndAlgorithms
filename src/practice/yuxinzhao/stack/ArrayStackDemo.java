package practice.yuxinzhao.stack;

import java.util.Scanner;

//使用数组模拟栈
public class ArrayStackDemo {
    public static void main(String[] args) {
        //test stack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show: show the stack");
            System.out.println("pop: take a value out of the stack");
            System.out.println("push: add a value to the stack");
            System.out.println("exit: exit programme");
            System.out.println("Please input your order:");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.showStack();
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.println("Pop: " + result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "push":
                    System.out.println("Please input the new value:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("Please input the right order.");
            }
        }

        System.out.println("Program finished.");
    }
}

class ArrayStack {
    private int maxSize;    //size of stack
    private int[] stack;    //data
    private int top = -1;   //top of the stack, initiated as -1

    //constructor
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //push
    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack has been full. Can't push new value in it.");
            return;
        }
        top++;
        stack[top] = value;
    }

    //pop
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack has been empty. Can't pop.");
        }

        int value = stack[top];
        top--;
        return value;
    }

    //iterate (from top to bottom)
    public void showStack() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }
}
