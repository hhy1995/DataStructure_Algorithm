package Algorithm.PointToOffer;

/**
 * �ո���滻
 * Created on 2020/1/3 20:39
 *
 * @author Haiyang He
 * @version 1.0
 */

public class Test02 {
    public static String replaceSpace(StringBuffer str) {
        String newString = str.toString();
        char strArray[] = newString.toCharArray();
        //����StringBuffer���ж�ת���������Ԫ���Ƿ�����ո���������ո�Ļ�������append��������result��׷��'%20'�ַ�
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
		//�����ж������Ƿ�Ϸ�
		if (string == null && string.length < length)
			return null ;
		int numberOfBlank = 0;
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				numberOfBlank++;
			}
		}
		//����ת������ַ�����
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