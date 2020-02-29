package Algorithm.AlgorithmBook.LinkedList;

/**
 * @Description
 * �ݹ鷨��������
 * @auther hehaiyang
 * @create 2020-02-28 22:51
 */
public class ReverseSingleLinkedList_2 {

    /**
     * ����Ľ��
     */
    static class LNode {
        int data;
        LNode next;
    }

    /**
     * �Բ���ͷ���ĵ������������
     * @param head
     * @return
     */
    public static LNode RecursiveReverse(LNode head){
        if (head == null || head.next == null){
            return head;
        }else {
            //��ת����Ľ��
            LNode newhead = RecursiveReverse(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }

    /**
     * �Դ�ͷ���ĵ������������
     * @param head
     */
    public static void Reverse(LNode head){
        if (head == null){
            return;
        }
        LNode firstNode = head.next;
        LNode newhead = RecursiveReverse(firstNode);
        head.next = newhead;
    }

    /**
     * ���ò��뷨��ʵ�ֵ����������
     *      ������ĵڶ����ڵ㿪ʼ�����������Ľ����뵽ͷ�ڵ��β����ֱ����������
     */
    public static void InsertReverse(LNode head){
        if (head == null || head.next == null){
            return ;
        }
        LNode curNode = null;
        LNode nextNode = null;
        //����ĵڶ������Ϊ��ǰ���
        curNode = head.next.next;
        //��������ĵ�һ�����Ϊ���ս����β�ڵ�
        head.next.next = null;
        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = head.next;
            head.next = curNode;
            curNode = nextNode;
        }
    }


    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode tempNode = null;
        LNode curNode = head;
        //���쵥����
        for (int i = 0; i < 8; i++) {
            tempNode = new LNode();
            tempNode.data = i;
            tempNode.next = null;
            curNode.next = tempNode;
            curNode = tempNode;
        }

        System.out.println("����ǰ");
        for (curNode = head.next; curNode != null; curNode = curNode.next) {
            System.out.print( curNode.data +" ");
        }
        System.out.println();
//        Reverse(head);
        InsertReverse(head);
        System.out.println("�����");
        for (curNode = head.next; curNode != null; curNode = curNode.next) {
            System.out.print( curNode.data +" ");
        }
    }
}
