package DataStructure.recursion;

/**
 * Created on 2019/9/30 11:39
 * �Թ�����
 * @author Haiyang He
 * @version 1.0
 */
public class Maze {
    public static void main(String[] args) {
        // �ȴ���һ����ά���飬ģ���Թ�����ͼ��
        int[][] map = new int[8][7];
        // ʹ��1 ��ʾǽ������ȫ����Ϊ1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // ����ȫ����Ϊ1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //���õ���, 1 ��ʾ
        map[3][1] = 1;
        map[3][2] = 1;
//		map[1][2] = 1;
//        map[2][2] = 1;

        // �����ͼ
        System.out.println("��ͼ�����:");
        showMap(map);

        //ʹ�õݹ���ݸ�С����·
        setWay2(map,1,1);

        //����µĵ�ͼ��С���߹������ұ�ʶ���ĵ�ͼ
        System.out.println("��ͼ�����:");
        showMap(map);

    }

    /**
     * ��ʾ��ͼ
     * @param map
     */
    public static void showMap(int[][] map){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * ʹ�õݹ���ݸ�С����·
     * ˵����
     *      1.map��ʾ��ͼ
     *      2.i��j��ʾ�ӵ�ͼ���ĸ�λ�ÿ�ʼ������1��1��
     *      3.���С���ܵ� map[6][5] λ�ã���˵��ͨ·�ҵ�.
     *      4.Լ���� ��map[i][j] Ϊ 0 ��ʾ�õ�û���߹� ��Ϊ 1 ��ʾǽ  �� 2 ��ʾͨ·������ �� 3 ��ʾ�õ��Ѿ��߹��������߲�ͨ
     *      5.�����Թ�ʱ����Ҫȷ��һ������(����) ��->��->��->�� , ����õ��߲�ͨ���ٻ���
     * @param map ��ʾ��ͼ
     * @param i ��ʾ���ĸ�λ�ÿ�ʼ
     * @param j
     * @return �ҵ�ͨ·�ͷ���true  �Ҳ����ͷ���false
     */
    public static boolean setWay(int[][] map,int i ,int j){
        if (map[6][5] == 2){    //map[6][5]ͨ·�Ѿ��ҵ�
            return true;
        }else {
            if (map[i][j] == 0) {   //��ʾ�õ�û���߹�
                //�����ƶ��Ĳ��� ��->��->��->��  ��
                map[i][j] = 2; // �ٶ��õ��ǿ�����ͨ.
                if(setWay(map, i+1, j)) {//������
                    return true;
                } else if (setWay(map, i, j+1)) { //������
                    return true;
                } else if (setWay(map, i-1, j)) { //����
                    return true;
                } else if (setWay(map, i, j-1)){ // ������
                    return true;
                } else {
                    //˵���õ����߲�ͨ������·
                    map[i][j] = 3;
                    return false;
                }
            }else { //���map[i][j] != 0 �������� 1�� 2�� 3
                return false;
            }
        }
    }

    /**
     * �޸���·�Ĳ��ԣ��ĳ� ��->��->��->��
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if(map[6][5] == 2) { // ͨ·�Ѿ��ҵ�ok
            return true;
        } else {
            if(map[i][j] == 0) { //�����ǰ����㻹û���߹�
                //���ղ��� ��->��->��->��
                map[i][j] = 2; // �ٶ��õ��ǿ�����ͨ.
                if(setWay2(map, i-1, j)) {//������
                    return true;
                } else if (setWay2(map, i, j+1)) { //������
                    return true;
                } else if (setWay2(map, i+1, j)) { //����
                    return true;
                } else if (setWay2(map, i, j-1)){ // ������
                    return true;
                } else {
                    //˵���õ����߲�ͨ������·
                    map[i][j] = 3;
                    return false;
                }
            } else { // ���map[i][j] != 0 , ������ 1�� 2�� 3
                return false;
            }
        }
    }
}