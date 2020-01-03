package DataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2019/9/29 11:16
 * �沨�����ʽ������
 *
 * @author Haiyang He
 * @version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        /*
             ��һ����׺���ʽת�ɺ�׺���ʽ�Ĺ���
            ˵����
                1.����1+((2+3)��4)-5�� -- �� ת����"1 2 3 + 4 �� + 5 �C"
                2.��Ϊֱ�Ӷ�һ���ַ������в��������Ǻܷ��㡣�Ƚ���1+((2+3)��4)-5��ת����׺�ı��ʽ��Ӧ��List
                    ������1+((2+3)��4)-5��   ת��  ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
                3.���õ�����׺���ʽ��Ӧ��List ת���� ��׺���ʽ��Ӧ��List
                    ������ ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =�� ArrayList [1,2,3,+,4,*,+,5,�C]

         */
        String expression = "1+((2+3)*4)-5";//ע����ʽ
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("��׺���ʽ��Ӧ��List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("��׺���ʽ��Ӧ��List=" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,�C]
        System.out.printf("expression=%d", calculate(suffixExpreesionList)); //


        //�ȶ���һ���沨�����ʽ
        /*
            1. 1+((2+3)��4)-5 => ת��  1 2 3 + 4 �� + 5 �C
            2.
        */
        //String suffixExpression = "3 4 + 5 * 6 -";
        // String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        /*
            ˼·��
                1.�Ƚ���3 4 + 5 �� 6 - �� ����һ��ArrayList����
                2.��ArrayList���ݸ�һ������������ArrayList  ���  ջ��ɼ���
         */
        //List<String> list = getListString(suffixExpression);
        //System.out.println("list:" + list);

        //int result = calculate(list);
        //System.out.println("����Ľ���ǣ�" + result);
    }

    /**
     * ���������õ�����׺���ʽ��Ӧ��List => ��׺���ʽ��Ӧ��List
     * �� ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =�� ArrayList [1,2,3,+,4,*,+,5,�C]
     *
     * @param list ��Ӧ����׺���ʽ
     * @return
     */
    public static List<String> parseSuffixExpreesionList(List<String> list) {
        //����ջ
        Stack<String> operatorStack = new Stack<String>();
        //����һ��List�������м�������ջ�Ļ�����΢�鷳һЩ����󻹵����������
        List<String> resultList = new ArrayList<String>();
        for (String item : list) {
            if (item.matches("\\d+")) {  //�����һ��������ֱ�Ӽ��뵽resultList����
                resultList.add(item);
            } else if (item.equals("(")) {   //�����������ջ
                operatorStack.push(item);
            } else if (item.equals(")")){   //�����������")",�����ε�������ջջ��������������ҽ�����뵽resultList����
                while (!operatorStack.peek().equals("(")){
                    resultList.add(operatorStack.pop());
                }
                operatorStack.pop();    //�������ŵ������������ʽ���е�����
            } else {
                //��item�����ȼ�С�ڵ���s1ջ�������, ��s1ջ������������������뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚ�
                while (operatorStack.size() != 0 && Operation.getValue(operatorStack.peek()) >= Operation.getValue(item)){
                    resultList.add(operatorStack.pop());
                }
                //����while�ж��꣬�����������󣬻���Ҫ��
                operatorStack.push(item);
            }
        }
        while (operatorStack.size()!= 0){
            resultList.add(operatorStack.pop());
        }

        return resultList;
    }


    /**
     * ����������׺���ʽת���ɶ�Ӧ��List
     *
     * @param s
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        //����һ��List�������׺���ʽ��Ӧ������
        List<String> list = new ArrayList<String>();
        int index = 0; //���ڱ�����׺���ʽ�ַ���
        String str;//���ڶԶ�λ������ƴ��
        char c; //������ÿһ���ַ�
        do {
            //�����һ�������֣���Ҫ���뵽list����
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
                list.add("" + c);
                index++; //��������ƶ�
            } else {//��������֣�����Ҫ���Ƕ�λ�������
                str = ""; //�Ƚ�str �ó�"" '0'[48]->'9'[57]
                while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
                    str += c;//ƴ��
                    index++;
                }
                list.add(str);
            }
        } while (index < s.length());
        return list;
    }


    /**
     * ��һ���沨�����ʽ�����ν����ݺ������ ���뵽ArrayList����
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        //��suffixString�ָ�
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String element : strings) {
            list.add(element);
        }
        return list;
    }

    /*
        ��ɶ��沨�����ʽ������:
        1)��������ɨ�裬��3��4ѹ���ջ��
        2)����+���������˵���4��3��4Ϊջ��Ԫ�أ�3Ϊ�ζ�Ԫ�أ��������3+4��ֵ����7���ٽ�7��ջ��
        3)��5��ջ��
        4)�������ǡ����������˵���5��7�������7��5=35����35��ջ��
        5)��6��ջ��
        6)�����-������������35-6��ֵ����29���ɴ˵ó����ս��
     */
    public static int calculate(List<String> list) {
        //����һ��ջ
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            if (item.matches("\\d+")) { // ƥ����Ƕ�λ��
                // ��ջ
                stack.push(item);
            } else {
                // pop���������������㣬 ����ջ
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
                    throw new RuntimeException("���������");
                }
                //��res ��ջ
                stack.push("" + result);
            }
        }
        //�������stack�е�������������
        return Integer.parseInt(stack.pop());
    }
}

/**
 * �� Operation ���Է���һ������� ��Ӧ�����ȼ�
 */
class Operation {
    //�Ӽ�ͬ���ȼ�
    private static int ADD = 1;
    private static int SUB = 1;
    //�˳�ͬ���ȼ�
    private static int MUL = 2;
    private static int DIV = 2;

    //дһ�����������ض�Ӧ�����ȼ�����
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
