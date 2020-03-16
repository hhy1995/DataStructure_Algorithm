package Algorithm.AlgorithmBook.LinkedList;

import java.sql.SQLOutput;

/**
 * @Description
 * �����������������͵�����
 *      ����˼�룺�޸ĵ�ǰ�ڵ��ָ�����ָ������ָ������ǰ���ڵ�
 * @auther hehaiyang
 * @create 2020-02-28 16:05
 */
public class ReverseSingleLinkedList_1 {
    /**
     * LinkedList Node
     */
    static class ListNode
    {
        int data;
        ListNode next;
    }

    public static void ReverseList(ListNode head){
        if (head == null || head.next == null){
            return ;
        }
        //����ǰ������ǰ�Լ���̽ڵ�
        ListNode preNode = null;
        ListNode curNode = null;
        ListNode nextNode = null;

        //��������׽ڵ㵱��β�ڵ�
        curNode = head.next;
        nextNode = curNode.next;
        curNode.next = null;
        preNode = curNode;
        curNode = nextNode;

        //ʹ��ǰ�ڵ�������Ľڵ�curNodeָ����ǰ���ڵ�
        while (curNode.next != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = curNode.next;
            curNode = nextNode;
        }

        //�ڵ�����һ�����ָ��ԭ���ĵ����ڶ������
        curNode.next = preNode;
        //�����ͷ�ڵ�ָ��ԭ�������β�ڵ�
        head.next = curNode;

    }


    public static void main(String[] args)
    {
        ListNode head = new ListNode();
        head.next = null;
        ListNode tempNode = null;
        ListNode curNode = head;
        //���쵥����
        for (int i = 0; i < 8; i++) {
            tempNode = new ListNode();
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
        ReverseList(head);
        System.out.println("�����");
        for (curNode = head.next; curNode != null; curNode = curNode.next) {
            System.out.print( curNode.data +" ");
        }
    }
}



