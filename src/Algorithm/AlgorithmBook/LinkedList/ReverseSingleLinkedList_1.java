package Algorithm.AlgorithmBook.LinkedList;

import java.sql.SQLOutput;

/**
 * @Description
 * 单链表的逆序输出，就地逆序
 *      核心思想：修改当前节点的指针域的指向，让其指向他的前驱节点
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
        //定义前驱、当前以及后继节点
        ListNode preNode = null;
        ListNode curNode = null;
        ListNode nextNode = null;

        //将链表的首节点当作尾节点
        curNode = head.next;
        nextNode = curNode.next;
        curNode.next = null;
        preNode = curNode;
        curNode = nextNode;

        //使当前节点遍历到的节点curNode指向其前驱节点
        while (curNode.next != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = curNode.next;
            curNode = nextNode;
        }

        //节点的最后一个结点指向原来的倒数第二个结点
        curNode.next = preNode;
        //链表的头节点指向原来链表的尾节点
        head.next = curNode;

    }


    public static void main(String[] args)
    {
        ListNode head = new ListNode();
        head.next = null;
        ListNode tempNode = null;
        ListNode curNode = head;
        //构造单链表
        for (int i = 0; i < 8; i++) {
            tempNode = new ListNode();
            tempNode.data = i;
            tempNode.next = null;
            curNode.next = tempNode;
            curNode = tempNode;
        }

        System.out.println("逆序前");
        for (curNode = head.next; curNode != null; curNode = curNode.next) {
            System.out.print( curNode.data +" ");
        }
        System.out.println();
        ReverseList(head);
        System.out.println("逆序后");
        for (curNode = head.next; curNode != null; curNode = curNode.next) {
            System.out.print( curNode.data +" ");
        }
    }
}



