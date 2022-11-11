import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author zzl
 * @Description
 * @date 2021/11/8 - 8:45
 */
public class Exercise_01 {
    public static String fileMatch(String str) {
        BufferedReader br = null;
        try {
            File file = new File("document");
            File[] subFiles = file.listFiles();
            //遍历该文件夹下文件
            for (File subFile : subFiles) {
                if(subFile.isFile()){
                    br = new BufferedReader(new FileReader(subFile));
                    String contentLine ;
                    //如果一行过长，可以提前拆分成多行
                    while ((contentLine = br.readLine()) != null) {
                        contentLine.toLowerCase();
                        if(contentLine.contains(str)){
                            System.out.println(subFile.getName());
                            break;
                        }
                        // 读取每一行，并输出
                        //System.out.println(contentLine);
                        String[] lineWords = contentLine.split(" ");
                        for (String lineWord : lineWords) {
                            if(lineWord.endsWith(".")){
                                lineWord = lineWord.substring(0,lineWord.length()-1);
                            }
                            //这里涉及到匹配度的问题，如果输入的单词比较短？
                            if(str.equals(lineWord) || lineWord.contains(str) || str.contains(lineWord)){
                                System.out.println(subFile.getName());
                                break;
                            }
                        }
                    }

                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Test
   public void test1(){
        //单词，词组，模糊匹配
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter a word:");
        String str = sc.nextLine();
        str = str.toLowerCase();
        System.out.println(str);
        try {
            fileMatch(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
