package Algorithm.PointToOffer;

/**
 * 空格的替换
 * Created on 2020/1/3 20:39
 *
 * @author Haiyang He
 * @version 1.0
 */

public class Test02 {
    public static String replaceSpace(StringBuffer str) {
        String newString = str.toString();
        char strArray[] = newString.toCharArray();
        //采用StringBuffer，判断转化后的数组元素是否包含空格，如果包含空格的话，采用append方法，向result中追加'%20'字符
        StringBuffer result = new StringBuffer();
        int len = strArray.length;
        for (int i = 0; i < len; i++) {
            if (strArray[i] == ' ') {
                result.append("%20");
            }else {
                result.append(strArray[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        sb1.append("hello 666");
        System.out.println(replaceSpace(sb1));
        StringBuffer sb2 = new StringBuffer();
        sb2.append("hello666");
        System.out.println(replaceSpace(sb2));
        StringBuffer sb3 = new StringBuffer();
        sb3.append(" ");
        System.out.println(replaceSpace(sb3));
    }

	/*public static String replaceSpace(char string[],int length){
		//首先判断输入是否合法
		if (string == null && string.length < length)
			return null ;
		int numberOfBlank = 0;
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				numberOfBlank++;
			}
		}
		//计算转换后的字符长度
		int newLength = length + numberOfBlank * 2;
		if (newLength > length) {
			return null ;
		}
		int indexOfOrigin = length;
		int indexOfNew = newLength;
		while((indexOfOrigin >=0) && (indexOfNew > indexOfOrigin)){
			if (string[indexOfOrigin] == ' ') {
				string[indexOfNew--] = '0';
				string[indexOfNew--] = '2';
				string[indexOfNew--] = '%';
			}else {
				string[indexOfNew--] = string[indexOfOrigin];
			}
			indexOfOrigin--;
		}
		String result = string.toString();
		return result;
	}
	public static void main(String[] args) {
		char[] string = new char[50];
		string[0] = ' ';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = ' ';
		string[4] = 'r';
		string[5] = 'e';
		string[6] = ' ';
		string[7] = ' ';
		int length = string.length;
		System.out.println(replaceSpace(string, length));
	}*/
}