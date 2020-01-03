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
        //进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //按照编号的顺序加入到单链表当中
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.showList();
        System.out.println("修改节点的名称：");
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "卢俊义", "玉麒麟666");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.showList();
        System.out.println("测试删除节点：");

        //测试删除一个节点
        singleLinkedList.del(3);
        singleLinkedList.showList();

        System.out.println("单链表的有效长度为：" + getLength(singleLinkedList.getHead()));

        //测试是否得到倒数第k个节点
        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("lastIndexNode:" + lastIndexNode);

        System.out.println("未反转前的链表：");
        singleLinkedList.showList();
        System.out.println("反转后的链表：");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.showList();

        System.out.println("从尾到头（逆序）打印单链表：");
        reversePrint(singleLinkedList.getHead());
    }

    /**
     * 思想：从尾到头打印单链表，不能先反转再打印，这样会破坏原始链表的结构。
     * 利用栈这个数据结构，将各个节点压入栈中，然后利用栈的特点，这样就实现了逆序打印单链表
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return; //链表为空，不能打印
        }
        //创建一个用于临时存放节点的栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        //将链表当中的节点入栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;   //当前节点后移，这样就可以压入下一个节点
        }
        //将链表中的节点进行出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 将单链表进行反转
     *
     * @param head
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空或者只有一个节点，直接返回，不做任何操作
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助指针，帮助我们遍历原先的链表
        HeroNode curNode = head.next;
        HeroNode nextNode = null;   //指向当前curNode节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原先的链表，每遍历一个节点，将其取出来，并且放在新的链表reverseHead的最前端
        while (curNode != null) {
            nextNode = curNode.next; //暂时保存当前节点的下一个节点，因为后面有用
            curNode.next = reverseHead.next; //将curNode的下一个节点指向新的链表的最前端
            reverseHead.next = curNode;//将curNode连接到新的链表
            curNode = nextNode;//让 curNode 后移
        }
        //将head.next 指向 reversedHead.next
        head.next = reverseHead.next;
    }


    /**
     * 方法：查找单链表当中的倒数第K个节点
     * 思路：
     * 1.编写一个方法，接收head节点，同时接收一个index
     * 2.index 表示是倒数第index个节点
     * 3.先把链表从头到尾进行遍历，得到链表的总长度length，这个可以通过下面的getLength方法得到。
     * 4.得到长度后，我们从链表的第一个节点开始遍历（size - index）次，就可以得到倒数第k个节点
     *
     * @param head  单链表的头节点
     * @param index 第K个节点的下标
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表是不是为空。如果为空的话直接返回null
        if (head.next == null) {
            return null;
        }
        //第一次遍历，直接得到链表的长度（也就是链表的节点的个数）
        int size = getLength(head);
        //第二次遍历 size - index 位置，就是倒数的第k个节点。
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
     * 方法：获取单链表的长度 [注意：带头结点和不带头结点有区别，注意下即可]
     *
     * @param head 链表的头节点
     * @return 返回单链表有效节点的个数
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


//定义SingleLinkedList 管理英雄人物
class SingleLinkedList {
    //1.首先初始化一个头节点，头节点不要动
    public HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    /*
    思路：
    1.找到当前链表的最后节点
    2.将最后这个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
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
        temp.next = heroNode;
    }

    /*
        删除节点
        思路: 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点 temp.next = temp.next.next;
              2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针找到添加的位置
        HeroNode temp = head;
        boolean flag = false; //表示添加的编号是否存在，默认为false
        while (true) {
            //说明已经到链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前的链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号存在
            System.out.printf("准备插入节点的编号：%d 已经存在了，不允许重复插入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据编号no来进行修改，即no编号不能更改
    //说明
    //1.根据newHeroNode 的编号 no来修改
    public void update(HeroNode newHeroNode) {
        //判断链表是不是为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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

    //显示链表[遍历]
    public void showList() {
        //判断链表是不是为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为是带头结点的单链表，头节点不能动。我们此时需要一个辅助变量来进行遍历
        HeroNode temp = head.next;
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

//定义HeroNode，每个对象就是一个节点
class HeroNode extends SingleLinkedList {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}