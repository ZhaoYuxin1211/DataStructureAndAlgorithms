package practice.yuxinzhao.stack;

//使用栈完成表达式的计算思路
//1. 通过一个 index  值（索引），来遍历我们的表达式
//2. 如果我们发现是一个数字, 就直接入数栈
//3. 如果发现扫描到是一个符号,  就分如下情况
//  3.1 如果发现当前的符号栈为 空，就直接入栈
//  3.2 如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符， 就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，
//  进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈， 如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
//4. 当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
//5. 最后在数栈只有一个数字，就是表达式的结果

//进阶——扫描多位数字
public class Calculator2 {
    public static void main(String[] args) {

        String expression = "30+2*6-2";

        //create two stacks, one for numbers, one for operators
        ArrayStack2 numbers = new ArrayStack2(10);
        ArrayStack2 operators = new ArrayStack2(10);

        int index = 0; // used as pointer
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

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
                    } else {
                        operators.push(ch);
                    }
                }
            } else {
                //Multi-digit
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numbers.push(Integer.parseInt(keepNum));
                } else if (operators.isOper(expression.charAt(index + 1))) {
                    numbers.push(Integer.parseInt(keepNum));
                    //ATTENTION!!!
                    keepNum = "";
                }

            }
            index++;
            if (index >= expression.length()) {
                break;
            }


        }
        while (true) {
            if (operators.isEmpty()) {
                break;
            } else {
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

