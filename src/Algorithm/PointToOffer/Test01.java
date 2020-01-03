package Algorithm.PointToOffer;

/**
 * 01.二维数组中的查找
 * 从右上角开始往下进行查找，逐步去掉不满足条件的行或者列
 * Created on 2020/1/3 20:37
 *
 * @author Haiyang He
 * @version 1.0
 */
public class Test01 {
    public static boolean Find(int target, int[][] array) {
        // 首先进行临界条件的判断，判定输入的参数是否合法
        if (array[0].length == 0 || array.length == 0) {
            return false;
        }
        boolean flag = false;// 默认target不在array当中
        int rows = array.length - 1;
        int cols = array[0].length - 1;

		/*
		//选取右上角进行查找
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
        //每一次选取左下角开始进行查找，和上述类似，思想也是逐步缩小查找的范围
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
        System.out.println(Find(7, array));    // 测试要查找的数在数组中
        System.out.println(Find(5, array));    // 测试要查找的数不在数组中
        System.out.println(Find(1, array));    // 测试要查找的数是数组中最小的数字
        System.out.println(Find(15, array));   // 测试要查找的数是数组中最大的数字
        System.out.println(Find(0, array));    // 测试要查找的数比数组中最小的数字还小
        System.out.println(Find(16, array));   // 测试数据比数组当中最大的值还要大
        System.out.println(Find(16, null));    // 测试数组为空的情况
    }
}