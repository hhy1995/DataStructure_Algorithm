package DataStructure.linkedlist;

/**
 * Created on 2019/9/25 17:31
 *
 * @author Haiyang He
 * @version 1.0
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        System.out.println("双向链表的测试：");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        //测试修改
        HeroNode2 newHeroNode = new HeroNode2(4,"lalala","666");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表：");
        doubleLinkedList.list();

        System.out.println("测试链表的删除：");
        doubleLinkedList.del(1);
        doubleLinkedList.list();


    }
}

//创建一个双向链表的类
class DoubleLinkedList{
    //初始化头节点，头节点不能动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    /*
        从双向链表当中删除节点
        思路: 1.对于双向链表，我们可以直接找到需要删除的那个节点
              2.找到后，自我删除即可
     */
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next; //辅助指针
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp == null) { //已经到链表的最后节点的next域
                break;
            }
            if (temp.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            temp.pre.next = temp.next;
            //这边有问题
            //如果是最后一个节点就不能执行下面这句,否则会出现空指针异常，
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /*
    修改一个节点的内容，双向链表的节点内容的修改基本和单向链表基本一致
     */
    //1.根据newHeroNode 的编号 no来修改
    public void update(HeroNode2 newHeroNode) {
        //判断链表是不是为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;   //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;  //链表已经遍历结束
            }
            if (temp.no == newHeroNode.no) {
                //已经找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据标志位flag，判断是否找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {//没找到
            System.out.printf("没找到编号为%d 的节点\n", newHeroNode.no);
        }
    }

    /*
    添加节点到双向链表的尾部
    思路：
    1.找到当前链表的最后节点
    2.将最后这个节点的next指向新的节点
     */
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到，就将temp后移
            temp = temp.next;
        }
        //当退出while循环的时候，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 根据编号的顺序来添加节点
     * @param heroNode2
     */
    public void addByOrder(HeroNode2 heroNode2){
        //因为头节点不能动，因此我们仍然通过一个辅助指针找到添加的位置
        HeroNode2 temp = head;
        boolean flag = false; //表示添加的编号是否存在，默认为false
        while (true) {
            //说明已经到链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面
            if (temp.next.no > heroNode2.no) {
                break;
            } else if (temp.next.no == heroNode2.no) {
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前的链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号存在
            System.out.printf("准备插入节点的编号：%d 已经存在了，不允许重复插入\n", heroNode2.no);
        } else {
            //插入到链表中，temp的后面
           heroNode2.pre = temp.next;
           heroNode2.next = temp.pre.next;
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是不是为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为是带头结点的单链表，头节点不能动。我们此时需要一个辅助变量来进行遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否遍历到链表的尾部
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;//指向为前一个节点，默认为null
    public HeroNode2 next;//指向为后一个节点，默认为null

    /**
     * 构造器
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
     * 方便显示，重写toString方法
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