package DataStructure.queue;

/**
 * Created on 2019/9/23 17:14
 *
 * @author Haiyang He
 * @version 1.0
 */
//ʹ������ģ����У���дһ��ArrayQueue����
class ArrayQueue {
    private int maxSize; //��ʾ�������������
    private int front;//ͷ
    private int rear;//β
    private int[] arr;

    //�������й�����
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //ָ�����ͷ��
        rear = -1;  //ָ����е�β����ֻ�����β�������ݣ����������һ�����ݣ�
    }

    //�ж϶����Ƿ�������
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return front == rear;
    }

    //�������������
    public void addQueue(int n) {
        //�����ж϶����ǲ������ģ���������Ļ����Ͳ����ټ�������
        if (isFull()) {
            System.out.println("�����������޷��ټ�������");
            return;
        }
        rear++; //βָ�����
        arr[rear] = n;
    }

    //��ȡ���е�����
    public int getQueue() {
        //ȡ����ʱ�����ж϶����Ƿ�Ϊ��
        if (isEmpty()) {
            //ͨ���׳��쳣ʵ��
            throw new RuntimeException("���пգ��޷�ȡ����");
        }
        front++;
        return arr[front];
    }

    //��ʾ���е���������
    public void showQueue() {
        //����
        if (isEmpty()) {
            System.out.println("�����ǿյģ�������");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //��ʾ���е�ͷ���ݣ���ȡ���ݲ�ͬ��
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("�����ǿյģ�������");
        }
        return arr[front + 1];
    }
}