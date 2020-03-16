package Algorithm.AlgorithmBook.LinkedList;

/**
 * @Description
 * 递归法逆序单链表
 * @auther hehaiyang
 * @create 2020-02-28 22:51
 */
public class ReverseSingleLinkedList_2 {

    /**
     * 链表的结点
     */
    static class ListNode {
        int data;
        ListNode next;
    }

    /**
     * 对不带头结点的单链表进行逆序
     * @param head
     * @return
     */
    public static ListNode RecursiveReverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }else {
            //反转后面的结点
            ListNode newhead = RecursiveReverse(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }

    /**
     * 对带头结点的单链表进行逆序
     * @param head
     */
    public static void Reverse(ListNode head){
        if (head == null){
            return;
        }
        ListNode firstNode = head.next;
        ListNode newhead = RecursiveReverse(firstNode);
        head.next = newhead;
    }

    /**
     * 利用插入法，实现单链表的逆序
     *      从链表的第二个节点开始，将遍历到的结点插入到头节点的尾部，直到遍历结束
     */
    public static void InsertReverse(ListNode head){
        if (head == null || head.next == null){
            return ;
        }
        ListNode curNode = null;
        ListNode nextNode = null;
        //链表的第二个结点为当前结点
        curNode = head.next.next;
        //设置链表的第一个结点为最终结果的尾节点
        head.next.next = null;
        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = head.next;
            head.next = curNode;
            curNode = nextNode;
        }
    }


    public static void main(String[] args) {
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
//        Reverse(head);
        InsertReverse(head);
        System.out.println("逆序后");
        for (curNode = head.next; curNode != null; curNode = curNode.next) {
            System.out.print( curNode.data +" ");
        }
    }
}
