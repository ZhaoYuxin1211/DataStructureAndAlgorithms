package practice.yuxinzhao.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
//        (3+4)*5-6 --> 3 4 + 5 * 6 -
        String suffixNotation = "3 4 + 5 * 6 -";

//        get string list
        List<String> rpnList = getListString(suffixNotation);

//        test
        int result = calculate(rpnList);
        System.out.println(result);

    }


    /**
     * parse a infix expression to a suffix expression
     * @param ls
     * @return
     */
    public static List<String> infixExpressionToSuffixExpression(List<String> ls) {
        //stack to store operators
        Stack<String> stackOperator = new Stack<String>();
        //normally we will use another stack to store the middle result,
        //but in this case, we choose to use arraylist because it will be easier to use
        List<String> listMiddleResult = new ArrayList<String>();

        for (String item : ls) {
            if (item.matches("\\d+")) {
                //if the item is a number, push it into middle result list
                listMiddleResult.add(item);
            } else if (item.equals("(")) {
                //if the item is "(", push it into the operator stack
                stackOperator.push(item);
            } else if (item.equals(")")) {
                //if the item is ")", pop the items in middle result until we meet a "("
                //push all the popped items into operator stack, then throw the pair of "()"
                while (!stackOperator.peek().equals("(")) {
                    listMiddleResult.add(stackOperator.pop());
                }
                stackOperator.pop();
            } else {
                //When the priority of the item is less than
                //the priority of the element at the top of the operator stack
                //pop the operator stack, add it into list, and compare it with the next top on in the stack
                //finally push the item in the operator stack
                while (stackOperator.size() != 0 &&
                        OperationPriority.getValue(stackOperator.peek()) >= OperationPriority.getValue(item)){
                    listMiddleResult.add(stackOperator.pop());
                }
                stackOperator.push(item);
            }
        }

        //pop the items in stack into the result list
        while (stackOperator.size()!=0){
            listMiddleResult.add(stackOperator.pop());
        }

        return listMiddleResult;
    }

    /**
     * turn a string to a infix expression list
     *
     * @param s string to be turned
     * @return infix expression list
     */
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;  //pointer
        String multiDigit;  //used for the joint of multi-digit
        char c;
        do {
            // if c is not a number
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                multiDigit = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    multiDigit += c;
                    i++;
                }
                ls.add(multiDigit);
            }
        } while (i < s.length());
        return ls;
    }

    public static List<String> getListString(String suffixNotaion) {
        String[] split = suffixNotaion.split(" ");
        List<String> list = new ArrayList<String>();
        for (String element : split) {
            list.add(element);
        }
        return list;
    }

    //    RPN: from left to right
    public static int calculate(List<String> list) {
        //only need one stack
        Stack<String> strings = new Stack<>();
        for (String s : list) {
            //regex
            if (s.matches("\\d+")) {//multi-number
                //push in numbers
                strings.push(s);
            } else { //when it comes to operator
                //calculate 2 numbers, then push in the result
                int num2 = Integer.parseInt(strings.pop());
                int num1 = Integer.parseInt(strings.pop());
                int result = 0;
                switch (s) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "%":
                        result = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("There's something wrong with the operator.");
                }
                strings.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(strings.pop());
    }
}

class OperationPriority {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("ERROR.");
                break;
        }

        return result;
    }
}

