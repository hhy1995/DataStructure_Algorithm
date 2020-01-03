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
        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // 出栈
        // smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }
    }
}