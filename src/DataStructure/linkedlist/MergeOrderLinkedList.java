package DataStructure.linkedlist;

/**
 * Created on 2019/9/25 15:50
 * 合并两个有序的单链表
 *
 * @author Haiyang He
 * @version 1.0
 */
public class MergeOrderLinkedList {

    /**
     * 以递归的方式合并两个有序的单链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeTwoLinkedListRecursive(Node head1, Node head2) {
        //判断边界条件
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //合并后得到链表
        Node head = null;
        if (head1.data > head2.data) {
            head = head2;
            head.next = mergeTwoLinkedListRecursive(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoLinkedListRecursive(head1.next, head2);
        }
        return head;
    }

    /**
     * 以非递归的方式实现两个有序单链表的合并
     *
     * @param head1
     * @param head2
     * @return 合并后的单链表
     */
    public static Node mergeTwoLinkedListNonRecursive(Node head1, Node head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //temp为用于合并链表的临时节点
        Node temp = new Node(0,null);
        Node result = temp;
        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        //由于是链表，所以直接指向即可
        if (head1 == null){
            temp.next = head2;
        }
        if (head2 == null){
            temp.next = head1;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node3;
        node3.next = node5;
        node2.next = node4;

        //Node node = mergeTwoLinkedListRecursive(node1, node2);
        Node node = mergeTwoLinkedListNonRecursive(node1, node2);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}

class Node {
    public int data;
    public Node next;

    /**
     * 构造方法，初始化时即可赋值
     *
     * @param data
     * @param o
     */
    public Node(int data, Object o) {
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}