package DataStructure.stack;

/**
 * Created on 2019/9/29 8:26
 * ����������ģ��ջ�Ĳ���
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

        System.out.println("�鿴ջ��Ԫ�أ������Ƴ���");
        Node topNode = stack.peak();
        System.out.println(topNode);
        System.out.println();
        stack.showLinkedListStack();



    }
}

class LinkedListStack{
    //��ʼ�������ͷ�ڵ�
    public Node head = new Node(0);
    public Node getHead(){
        return head;
    }

    /**
     * ��������ģ����ջ����
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
     * �鿴��������һ���ڵ�
     * @return
     */
    public Node peak(){
        if (head.next == null){
            System.out.println("ջ�ǿյģ�");
        }
        Node temp = head.next;
        while (true){
            //�ж��Ƿ񵽴������β��
            if (temp.next == null){
                return temp;
            }
            temp = temp.next;
        }
    }

    /**
     * ��ʾ����ջ���е�����Ԫ��
     */
    public void showLinkedListStack(){
        if (head.next == null){
            System.out.println("ջ�ǿյģ�");
        }
        Node temp = head.next;
        while (true){
            //�ж��Ƿ񵽴������β��
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/**
 * ��������Ľڵ�
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