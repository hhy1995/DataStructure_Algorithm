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
        //����   ArrayStack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;    //�����Ƿ��˳��˵�
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show:��ʾջ��ȫ��Ԫ��");
            System.out.println("exit���˳�");
            System.out.println("push:��ջ");
            System.out.println("pop:��ջ");
            System.out.println("������ѡ��Ĳ�����");
            key = scanner.next();
            switch (key) {
                //��ʾջ��ȫ��Ԫ��
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("����һ������");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("��ջ�������� %d\n", res);
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

//����һ��ArrayStack ��ʾջ
class ArrayStack {
    private int maxSize;//ջ�Ĵ�С
    private int[] stack;//��������ģ��ջ
    private int top = -1;//top��ʾջ������ʼ��Ϊ-1

    //������
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //ջ��
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    //��ջ
    public void push(int value) {
        if (isFull()) {
            System.out.println("ջ������");
            return;
        }
        top++;
        stack[top] = value;
    }

    //��ջ(��ջ�������ݵ���)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("ջ�ǿյ�,�����ݣ�");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //��ʾջ�����������ջ��,����ʱ��Ҫ��ջ����ʼ��ʾ����
    public void showStack() {
        if (isEmpty()) {
            System.out.println("ջ�գ������ݣ�");
            return;
        }
        //��Ҫ��ջ����ʼ��ʾ����
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}