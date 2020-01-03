package DataStructure.queue;

import java.util.Scanner;

/**
 * Created on 2019/9/23 12:56.
 * @author Haiyang He
 * @version 1.0
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        //����һ������
        ArrayQueue queue = new ArrayQueue(10);
        char key = ' '; //�����û�������ַ�
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //���һ���˵�
        while (loop) {
            System.out.println("s(show): ��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");
            key = scanner.next().charAt(0);//����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //ȡ������
                    try {
                        int res = queue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //�鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //�˳�
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳�!");
    }
}

