package DataStructure.linkedlist;

import java.util.Stack;

/**
 * Created on 2019/9/23 19:17
 *
 * @author Haiyang He
 * @version 1.0
 */
public class StackList {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        // ��ջ
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // ��ջ
        // smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop���ǽ�ջ��������ȡ��
        }
    }
}