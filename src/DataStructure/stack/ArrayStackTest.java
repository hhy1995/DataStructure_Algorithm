package DataStructure.stack;

import java.util.Scanner;

/**
 * Created on 2019/9/28 10:32
 *
 * @author Haiyang He
 * @version 1.0
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        //测试   ArrayStack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;    //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show:显示栈的全部元素");
            System.out.println("exit：退出");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入选择的操作：");
            key = scanner.next();
            switch (key) {
                //显示栈的全部元素
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) { // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

//定义一个ArrayStack 表示栈
class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//用数组来模拟栈
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈(将栈顶的数据弹出)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈是空的,无数据！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况（遍历栈）,遍历时需要从栈顶开始显示数据
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空，无数据！");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}