package DataStructure.linkedlist;

/**
 * Created on 2019/9/25 17:31
 *
 * @author Haiyang He
 * @version 1.0
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        System.out.println("˫������Ĳ��ԣ�");
        // �ȴ����ڵ�
        HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
        HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");

        //����һ��˫������
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        //�����޸�
        HeroNode2 newHeroNode = new HeroNode2(4,"lalala","666");
        doubleLinkedList.update(newHeroNode);
        System.out.println("�޸ĺ������");
        doubleLinkedList.list();

        System.out.println("���������ɾ����");
        doubleLinkedList.del(1);
        doubleLinkedList.list();


    }
}

//����һ��˫���������
class DoubleLinkedList{
    //��ʼ��ͷ�ڵ㣬ͷ�ڵ㲻�ܶ�������ž��������
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    /*
        ��˫��������ɾ���ڵ�
        ˼·: 1.����˫���������ǿ���ֱ���ҵ���Ҫɾ�����Ǹ��ڵ�
              2.�ҵ�������ɾ������
     */
    public void del(int no) {
        //�жϵ�ǰ�����Ƿ�Ϊ��
        if (head.next == null){
            System.out.println("����Ϊ�գ��޷�ɾ��");
            return;
        }
        HeroNode2 temp = head.next; //����ָ��
        boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
        while (true) {
            if (temp == null) { //�Ѿ�����������ڵ��next��
                break;
            }
            if (temp.no == no) {
                //�ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
                flag = true;
                break;
            }
            temp = temp.next; //temp���ƣ�����
        }
        //�ж�flag
        if (flag) { //�ҵ�
            temp.pre.next = temp.next;
            //���������
            //��������һ���ڵ�Ͳ���ִ���������,�������ֿ�ָ���쳣��
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
        }
    }

    /*
    �޸�һ���ڵ�����ݣ�˫������Ľڵ����ݵ��޸Ļ����͵����������һ��
     */
    //1.����newHeroNode �ı�� no���޸�
    public void update(HeroNode2 newHeroNode) {
        //�ж������ǲ���Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        //�ҵ���Ҫ�޸ĵĽڵ㣬����no���
        //����һ����������
        HeroNode2 temp = head.next;
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

    /*
    ��ӽڵ㵽˫�������β��
    ˼·��
    1.�ҵ���ǰ��������ڵ�
    2.���������ڵ��nextָ���µĽڵ�
     */
    public void add(HeroNode2 heroNode) {
        //��Ϊhead�ڵ㲻�ܶ������������Ҫһ����������temp
        HeroNode2 temp = head;
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
        //�γ�һ��˫������
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * ���ݱ�ŵ�˳������ӽڵ�
     * @param heroNode2
     */
    public void addByOrder(HeroNode2 heroNode2){
        //��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ���ҵ���ӵ�λ��
        HeroNode2 temp = head;
        boolean flag = false; //��ʾ��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
        while (true) {
            //˵���Ѿ�����������
            if (temp.next == null) {
                break;
            }
            //λ���ҵ�������temp�ĺ���
            if (temp.next.no > heroNode2.no) {
                break;
            } else if (temp.next.no == heroNode2.no) {
                flag = true;//˵����Ŵ���
                break;
            }
            temp = temp.next; //���ƣ�������ǰ������
        }
        //�ж�flag��ֵ
        if (flag) {//������ӣ�˵����Ŵ���
            System.out.printf("׼������ڵ�ı�ţ�%d �Ѿ������ˣ��������ظ�����\n", heroNode2.no);
        } else {
            //���뵽�����У�temp�ĺ���
           heroNode2.pre = temp.next;
           heroNode2.next = temp.pre.next;
        }
    }

    //��ʾ����[����]
    public void list() {
        //�ж������ǲ���Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊ�Ǵ�ͷ���ĵ�����ͷ�ڵ㲻�ܶ������Ǵ�ʱ��Ҫһ���������������б���
        HeroNode2 temp = head.next;
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

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;//ָ��Ϊǰһ���ڵ㣬Ĭ��Ϊnull
    public HeroNode2 next;//ָ��Ϊ��һ���ڵ㣬Ĭ��Ϊnull

    /**
     * ������
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * ������ʾ����дtoString����
     * @return
     */
    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}