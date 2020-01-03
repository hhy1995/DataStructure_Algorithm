package DataStructure.stack;

/**
 * Created on 2019/9/29 8:26
 * 利用链表来模拟栈的操作
 * @author Haiyang He
 * @version 1.0
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        LinkedListStack stack = new LinkedListStack();

        stack.push(node1);
        stack.push(node2);
        stack.showLinkedListStack();

        System.out.println("查看栈顶元素，但不移除：");
        Node topNode = stack.peak();
        System.out.println(topNode);
        System.out.println();
        stack.showLinkedListStack();



    }
}

class LinkedListStack{
    //初始化链表的头节点
    public Node head = new Node(0);
    public Node getHead(){
        return head;
    }

    /**
     * 用链表来模拟入栈操作
     * @param node
     */
    public void push(Node node){
        Node temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 查看链表的最后一个节点
     * @return
     */
    public Node peak(){
        if (head.next == null){
            System.out.println("栈是空的！");
        }
        Node temp = head.next;
        while (true){
            //判断是否到达链表的尾部
            if (temp.next == null){
                return temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 显示链表栈当中的所有元素
     */
    public void showLinkedListStack(){
        if (head.next == null){
            System.out.println("栈是空的！");
        }
        Node temp = head.next;
        while (true){
            //判断是否到达链表的尾部
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/**
 * 定义链表的节点
 */
class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}