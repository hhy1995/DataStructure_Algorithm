package DataStructure.recursion;

/**
 * Created on 2019/9/30 11:01
 *
 * @author Haiyang He
 * @version 1.0
 */
public class RecursionTest {
    public static void main(String[] args) {
        //ͨ�������⣬�ع˵ݹ�ĵ��û���
       // test(10);
        int result = factorial(10);
        System.out.println(result);
    }

    /*
    ��ӡ����
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);

    }
    /*
    �׳�����
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}