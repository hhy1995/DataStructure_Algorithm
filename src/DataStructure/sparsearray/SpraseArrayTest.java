package DataStructure.sparsearray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 2019/9/23 10:05.
 *
 * @author Haiyang He
 * @version 1.0
 */
public class SpraseArrayTest {

    private static Object SpraseArray;

    public static void main(String[] args) throws Exception {
        //�ڵ�ǰĿ¼�´����ļ�
        String filePath = "E:\\Code\\DataStructure&Algorithm\\src\\DataStructure\\sparsearray\\sprasearray.txt";
        File file = new File(filePath);
        if (!file.exists()){
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //���´������ļ���д������
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);

        SpraseArray();
    }

    private static void SpraseArray() {

    }
}