package DataStructure.recursion;

/**
 * Created on 2019/10/1 15:46
 * �˻ʺ�����
 *
 * @author Haiyang He
 * @version 1.0
 */
public class Queue {

    //����һ��max����ʾ���ж��ٸ��ʺ�
    int max = 8;
    //��������array, ����ʺ����λ�õĽ��,���� arr = {0 , 4, 7, 5, 2, 6, 1, 3} 
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        //���ԣ� 8�ʺ��Ƿ���ȷ
        Queue queue8 = new Queue();
        queue8.check(0);
        System.out.printf("һ����%d�ⷨ,", count);
        System.out.printf("һ���жϳ�ͻ�Ĵ���%d��", judgeCount); // 1.5w
    }

    /**
     * ���õ�n���ʺ�
     * ע�⣺
     * check �� ÿһ�εݹ�ʱ�����뵽check�ж��� for(int i=0,i < max;i++) ,��˻��л���
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) {  //n = 8 , ��ʵ8���ʺ���Ѿ��ź�
            print();
            return;
        }
        //���η���ʺ󣬲��ж��Ƿ��ͻ
        for (int i = 0; i < max; i++) {
            //�Ȱѵ�ǰ����ʺ� n , �ŵ����еĵ�1��
            array[n] = i;
            //�жϵ����õ�n���ʺ�i��ʱ���Ƿ��ͻ
            if (judge(n)) { // ����ͻ
                //���ŷ�n+1���ʺ�,����ʼ�ݹ�
                check(n + 1);
            }
            //�����ͻ���ͼ���ִ�� array[n] = i; ������n���ʺ󣬷����ڱ��е� ���Ƶ�һ��λ��
        }
    }

    /**
     * �鿴���õ�n���ʺ�ʱ��ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��Ƿ��ͻ
     *
     * @param n
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //1.array[i] == array[n]  ��ʾ�ж� ��n���ʺ��Ƿ��ǰ���n-1���ʺ���ͬһ��
            //2.Math.abs(n-i) == Math.abs(array[n] - array[i]) ��ʾ�жϵ�n���ʺ��Ƿ�͵�i�ʺ��Ƿ���ͬһб��
            //3.�ж��Ƿ���ͬһ��
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //���ʺ�ڷŵ�λ�ô�ӡ����
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}