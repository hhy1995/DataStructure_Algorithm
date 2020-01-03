package DataStructure.queue;

/**
 * Created on 2019/9/23 17:14
 *
 * @author Haiyang He
 * @version 1.0
 */
//使用数组模拟队列，编写一个ArrayQueue的类
class ArrayQueue {
    private int maxSize; //表示数组的最大的容量
    private int front;//头
    private int rear;//尾
    private int[] arr;

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部
        rear = -1;  //指向队列的尾部，只想队列尾部的数据（即队列最后一个数据）
    }

    //判断队列是否是满的
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据至队列
    public void addQueue(int n) {
        //首先判断队列是不是满的，如果是满的话，就不能再加入数据
        if (isFull()) {
            System.out.println("队列已满，无法再加入数据");
            return;
        }
        rear++; //尾指针后移
        arr[rear] = n;
    }

    //获取队列的数据
    public int getQueue() {
        //取数据时，先判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常实现
            throw new RuntimeException("队列空，无法取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列是空的，无数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据（与取数据不同）
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，无数据");
        }
        return arr[front + 1];
    }
}