package practice.yuxinzhao.stack;

//使用栈完成表达式的计算思路
//1. 通过一个 index  值（索引），来遍历我们的表达式
//2. 如果我们发现是一个数字, 就直接入数栈
//3. 如果发现扫描到是一个符号,  就分如下情况
//  3.1 如果发现当前的符号栈为 空，就直接入栈
//  3.2 如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符， 就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈， 如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
//4. 当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
//5. 最后在数栈只有一个数字，就是表达式的结果
public class Calculator {
    public static void main(String[] args) {

        String expression = "3+2*6-2";

        //create two stacks, one for numbers, one for operators
        ArrayStack2 numbers = new ArrayStack2(10);
        ArrayStack2 operators = new ArrayStack2(10);

        int index = 0; // used as pointer
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';

        while (true) {
            ch = expression.charAt(index);
            if (operators.isOper(ch)) {
                if (operators.isEmpty()) {
                    operators.push(ch);
                } else {
                    if (operators.priority(ch) <= operators.priority(operators.peek())) {
                        num1 = numbers.pop();
                        num2 = numbers.pop();
                        oper = operators.pop();
                        res = numbers.cal(num1, num2, oper);
                        numbers.push(res);
                        operators.push(ch);
                    }else {
                        operators.push(ch);
                    }
                }
            } else {
                numbers.push(ch - 48);
            }
            index++;
            if (index >= expression.length()) {
                break;
            }


        }
        while (true) {
            if (operators.isEmpty()){
                break;
            }else {
                num1 = numbers.pop();
                num2 = numbers.pop();
                oper = operators.pop();
                res = numbers.cal(num1, num2, oper);
                numbers.push(res);
            }
        }

        System.out.println("The expression is: " + expression);
        System.out.println("The result is: " + numbers.peek());

    }


}

class ArrayStack2 {
    private int maxSize;    //size of stack
    private int[] stack;    //data
    private int top = -1;   //top of the stack, initiated as -1

    //constructor
    public ArrayStack2(int maxSize) {
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

    //peek
    public int peek() {
        return stack[top];
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

    //get the priority of an operator
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //whether the argument is an operator
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //calculation
    public int cal(int num1, int num2, int oper) {
        int result = 0; //used to store the result
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '%':
                result = num2 / num1;
                break;
        }
        return result;
    }

}
