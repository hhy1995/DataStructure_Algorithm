package DataStructure.linkedlist;

import java.util.Stack;

/**
 * Created on 2019/9/23 19:27
 *
 * @author Haiyang He
 * @version 1.0
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        //���в���
        // �ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����һ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //���ձ�ŵ�˳����뵽��������
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.showList();
        System.out.println("�޸Ľڵ�����ƣ�");
        //�����޸Ľڵ�Ĵ���
        HeroNode newHeroNode = new HeroNode(2, "¬����", "������666");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.showList();
        System.out.println("����ɾ���ڵ㣺");

        //����ɾ��һ���ڵ�
        singleLinkedList.del(3);
        singleLinkedList.showList();

        System.out.println("���������Ч����Ϊ��" + getLength(singleLinkedList.getHead()));

        //�����Ƿ�õ�������k���ڵ�
        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("lastIndexNode:" + lastIndexNode);

        System.out.println("δ��תǰ������");
        singleLinkedList.showList();
        System.out.println("��ת�������");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.showList();

        System.out.println("��β��ͷ�����򣩴�ӡ������");
        reversePrint(singleLinkedList.getHead());
    }

    /**
     * ˼�룺��β��ͷ��ӡ�����������ȷ�ת�ٴ�ӡ���������ƻ�ԭʼ����Ľṹ��
     * ����ջ������ݽṹ���������ڵ�ѹ��ջ�У�Ȼ������ջ���ص㣬������ʵ���������ӡ������
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return; //����Ϊ�գ����ܴ�ӡ
        }
        //����һ��������ʱ��Žڵ��ջ
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        //�������еĽڵ���ջ
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;   //��ǰ�ڵ���ƣ������Ϳ���ѹ����һ���ڵ�
        }
        //�������еĽڵ���г�ջ
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * ����������з�ת
     *
     * @param head
     */
    public static void reverseList(HeroNode head) {
        //�����ǰ����Ϊ�ջ���ֻ��һ���ڵ㣬ֱ�ӷ��أ������κβ���
        if (head.next == null || head.next.next == null) {
            return;
        }
        //����һ������ָ�룬�������Ǳ���ԭ�ȵ�����
        HeroNode curNode = head.next;
        HeroNode nextNode = null;   //ָ��ǰcurNode�ڵ����һ���ڵ�
        HeroNode reverseHead = new HeroNode(0, "", "");
        //����ԭ�ȵ�����ÿ����һ���ڵ㣬����ȡ���������ҷ����µ�����reverseHead����ǰ��
        while (curNode != null) {
            nextNode = curNode.next; //��ʱ���浱ǰ�ڵ����һ���ڵ㣬��Ϊ��������
            curNode.next = reverseHead.next; //��curNode����һ���ڵ�ָ���µ��������ǰ��
            reverseHead.next = curNode;//��curNode���ӵ��µ�����
            curNode = nextNode;//�� curNode ����
        }
        //��head.next ָ�� reversedHead.next
        head.next = reverseHead.next;
    }


    /**
     * ���������ҵ������еĵ�����K���ڵ�
     * ˼·��
     * 1.��дһ������������head�ڵ㣬ͬʱ����һ��index
     * 2.index ��ʾ�ǵ�����index���ڵ�
     * 3.�Ȱ������ͷ��β���б������õ�������ܳ���length���������ͨ�������getLength�����õ���
     * 4.�õ����Ⱥ����Ǵ�����ĵ�һ���ڵ㿪ʼ������size - index���Σ��Ϳ��Եõ�������k���ڵ�
     *
     * @param head  �������ͷ�ڵ�
     * @param index ��K���ڵ���±�
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //�ж������ǲ���Ϊ�ա����Ϊ�յĻ�ֱ�ӷ���null
        if (head.next == null) {
            return null;
        }
        //��һ�α�����ֱ�ӵõ�����ĳ��ȣ�Ҳ��������Ľڵ�ĸ�����
        int size = getLength(head);
        //�ڶ��α��� size - index λ�ã����ǵ����ĵ�k���ڵ㡣
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode curNode = head.next;
        for (int i = 0; i < size - index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    /**
     * ��������ȡ������ĳ��� [ע�⣺��ͷ���Ͳ���ͷ���������ע���¼���]
     *
     * @param head �����ͷ�ڵ�
     * @return ���ص�������Ч�ڵ�ĸ���
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode current = head.next;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}


//����SingleLinkedList ����Ӣ������
class SingleLinkedList {
    //1.���ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��
    public HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //��ӽڵ㵽��������
    /*
    ˼·��
    1.�ҵ���ǰ��������ڵ�
    2.���������ڵ��nextָ���µĽڵ�
     */
    public void add(HeroNode heroNode) {
        //��Ϊhead�ڵ㲻�ܶ������������Ҫһ����������temp
        HeroNode temp = head;
        //���������ҵ����
        while (true) {
            //�ҵ���������
            if (temp.next == null) {
                break;
            }
            //���û���ҵ����ͽ�temp����
            temp = temp.next;
        }
        //���˳�whileѭ����ʱ��temp��ָ������������
        temp.next = heroNode;
    }

    /*
        ɾ���ڵ�
        ˼·: 1. head ���ܶ������������Ҫһ��temp�����ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ� temp.next = temp.next.next;
              2. ˵�������ڱȽ�ʱ����temp.next.no ��  ��Ҫɾ���Ľڵ��no�Ƚ�
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
        while (true) {
            if (temp.next == null) { //�Ѿ�����������
                break;
            }
            if (temp.next.no == no) {
                //�ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
                flag = true;
                break;
            }
            temp = temp.next; //temp���ƣ�����
        }
        //�ж�flag
        if (flag) { //�ҵ�
            //����ɾ��
            temp.next = temp.next.next;
        } else {
            System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
        }
    }

    //�ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��(�������������������ʧ�ܣ���������ʾ)
    public void addByOrder(HeroNode heroNode) {
        //��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ���ҵ���ӵ�λ��
        HeroNode temp = head;
        boolean flag = false; //��ʾ��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
        while (true) {
            //˵���Ѿ�����������
            if (temp.next == null) {
                break;
            }
            //λ���ҵ�������temp�ĺ���
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;//˵����Ŵ���
                break;
            }
            temp = temp.next; //���ƣ�������ǰ������
        }
        //�ж�flag��ֵ
        if (flag) {//������ӣ�˵����Ŵ���
            System.out.printf("׼������ڵ�ı�ţ�%d �Ѿ������ˣ��������ظ�����\n", heroNode.no);
        } else {
            //���뵽�����У�temp�ĺ���
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //�޸Ľڵ����Ϣ�����ݱ��no�������޸ģ���no��Ų��ܸ���
    //˵��
    //1.����newHeroNode �ı�� no���޸�
    public void update(HeroNode newHeroNode) {
        //�ж������ǲ���Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        //�ҵ���Ҫ�޸ĵĽڵ㣬����no���
        //����һ����������
        HeroNode temp = head.next;
        boolean flag = false;   //��ʾ�Ƿ��ҵ��ýڵ�
        while (true) {
            if (temp == null) {
                break;  //�����Ѿ���������
            }
            if (temp.no == newHeroNode.no) {
                //�Ѿ��ҵ�
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //���ݱ�־λflag���ж��Ƿ��ҵ���Ҫ�޸ĵĽڵ�
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {//û�ҵ�
            System.out.printf("û�ҵ����Ϊ%d �Ľڵ�\n", newHeroNode.no);
        }
    }

    //��ʾ����[����]
    public void showList() {
        //�ж������ǲ���Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊ�Ǵ�ͷ���ĵ�����ͷ�ڵ㲻�ܶ������Ǵ�ʱ��Ҫһ���������������б���
        HeroNode temp = head.next;
        while (true) {
            //�ж��Ƿ�����������β��
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //temp����
            temp = temp.next;
        }
    }
}

//����HeroNode��ÿ���������һ���ڵ�
class HeroNode extends SingleLinkedList {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//ָ����һ���ڵ�

    //������
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //Ϊ����ʾ���㣬��дtoString����
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}