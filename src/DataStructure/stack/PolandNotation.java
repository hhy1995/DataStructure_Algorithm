package DataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2019/9/29 11:16
 * 逆波兰表达式计算器
 *
 * @author Haiyang He
 * @version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        /*
             将一个中缀表达式转成后缀表达式的功能
            说明：
                1.将“1+((2+3)×4)-5” -- 》 转化成"1 2 3 + 4 × + 5 –"
                2.因为直接对一个字符串进行操作，不是很方便。先将“1+((2+3)×4)-5”转成中缀的表达式对应的List
                    即：“1+((2+3)×4)-5”   转成  ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
                3.将得到的中缀表达式对应的List 转化成 后缀表达式对应的List
                    即：即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]

         */
        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式对应的List=" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]
        System.out.printf("expression=%d", calculate(suffixExpreesionList)); //


        //先定义一个逆波兰表达式
        /*
            1. 1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
            2.
        */
        //String suffixExpression = "3 4 + 5 * 6 -";
        // String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        /*
            思路：
                1.先将”3 4 + 5 × 6 - “ 放在一个ArrayList当中
                2.将ArrayList传递给一个方法，遍历ArrayList  配合  栈完成计算
         */
        //List<String> list = getListString(suffixExpression);
        //System.out.println("list:" + list);

        //int result = calculate(list);
        //System.out.println("计算的结果是：" + result);
    }

    /**
     * 方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
     * 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
     *
     * @param list 对应的中缀表达式
     * @return
     */
    public static List<String> parseSuffixExpreesionList(List<String> list) {
        //符号栈
        Stack<String> operatorStack = new Stack<String>();
        //定义一个List来保存中间结果（用栈的话会稍微麻烦一些，最后还得逆序输出）
        List<String> resultList = new ArrayList<String>();
        for (String item : list) {
            if (item.matches("\\d+")) {  //如果是一个数，就直接加入到resultList当中
                resultList.add(item);
            } else if (item.equals("(")) {   //左括号入符号栈
                operatorStack.push(item);
            } else if (item.equals(")")){   //如果收右括号")",则依次弹出符号栈栈顶的运算符，并且将其加入到resultList当中
                while (!operatorStack.peek().equals("(")){
                    resultList.add(operatorStack.pop());
                }
                operatorStack.pop();    //将左括号弹出，消除表达式当中的括号
            } else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                while (operatorStack.size() != 0 && Operation.getValue(operatorStack.peek()) >= Operation.getValue(item)){
                    resultList.add(operatorStack.pop());
                }
                //上述while判断完，不满足条件后，还需要把
                operatorStack.push(item);
            }
        }
        while (operatorStack.size()!= 0){
            resultList.add(operatorStack.pop());
        }

        return resultList;
    }


    /**
     * 方法：将中缀表达式转化成对应的List
     *
     * @param s
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> list = new ArrayList<String>();
        int index = 0; //用于遍历中缀表达式字符串
        String str;//对于对多位数进行拼接
        char c; //遍历的每一个字符
        do {
            //如果是一个非数字，需要加入到list当中
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
                list.add("" + c);
                index++; //索引向后移动
            } else {//如果是数字，还需要考虑多位数的情况
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
                    str += c;//拼接
                    index++;
                }
                list.add(str);
            }
        } while (index < s.length());
        return list;
    }


    /**
     * 将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList当中
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        //将suffixString分割
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String element : strings) {
            list.add(element);
        }
        return list;
    }

    /*
        完成对逆波兰表达式的运算:
        1)从左至右扫描，将3和4压入堆栈；
        2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
        3)将5入栈；
        4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
        5)将6入栈；
        6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (item.equals("+")) {
                    result = num1 + num2;
                } else if (item.equals("-")) {
                    result = num1 - num2;
                } else if (item.equals("*")) {
                    result = num1 * num2;
                } else if (item.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + result);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}

/**
 * 类 Operation 可以返回一个运算符 对应的优先级
 */
class Operation {
    //加减同优先级
    private static int ADD = 1;
    private static int SUB = 1;
    //乘除同优先级
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
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
                break;
        }
        return result;
    }
}
