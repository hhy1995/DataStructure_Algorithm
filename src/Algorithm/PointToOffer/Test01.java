package Algorithm.PointToOffer;

/**
 * 01.��ά�����еĲ���
 * �����Ͻǿ�ʼ���½��в��ң���ȥ���������������л�����
 * Created on 2020/1/3 20:37
 *
 * @author Haiyang He
 * @version 1.0
 */
public class Test01 {
    public static boolean Find(int target, int[][] array) {
        // ���Ƚ����ٽ��������жϣ��ж�����Ĳ����Ƿ�Ϸ�
        if (array[0].length == 0 || array.length == 0) {
            return false;
        }
        boolean flag = false;// Ĭ��target����array����
        int rows = array.length - 1;
        int cols = array[0].length - 1;

		/*
		//ѡȡ���Ͻǽ��в���
		int i = 0;
		int j = cols;
		while ((i<=rows) && (j>=0)) {
			if (target == array[i][j]) {
				flag = true;
				break;
			}else if (target < array[i][j]) {
				j--;
			} else if (target > array[i][j]){
				i++;
			}
		}*/
        //ÿһ��ѡȡ���½ǿ�ʼ���в��ң����������ƣ�˼��Ҳ������С���ҵķ�Χ
        int i = rows;
        int j = 0;
        while((i >= 0)&&( j <= cols)){
            if (target == array[i][j]) {
                flag = true;
                break;
            }else if(target < array[i][j]) {
                i--;
            }else if(target > array[i][j]){
                j++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Find(7, array));    // ����Ҫ���ҵ�����������
        System.out.println(Find(5, array));    // ����Ҫ���ҵ�������������
        System.out.println(Find(1, array));    // ����Ҫ���ҵ�������������С������
        System.out.println(Find(15, array));   // ����Ҫ���ҵ�������������������
        System.out.println(Find(0, array));    // ����Ҫ���ҵ�������������С�����ֻ�С
        System.out.println(Find(16, array));   // �������ݱ����鵱������ֵ��Ҫ��
        System.out.println(Find(16, null));    // ��������Ϊ�յ����
    }
}