import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * @author zzl
 * @Description
 * @date 2021/11/15 - 8:44
 */

public class Exercise_02 {
    public static void creatInvertedIndex(String filePath){
        Map<String,Info> map = new HashMap<>();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File file = new File("document");
            bw = new BufferedWriter(new FileWriter("document//indexFile"));
            File[] subFiles = file.listFiles();
            //记录当前遍历到的文件下标
            int fileIndex = 0;
            //遍历该文件夹下文件
            for (File subFile : subFiles) {
                if(subFile.isFile()){
                    fileIndex++;
                    br = new BufferedReader(new FileReader(subFile));
                    String contentLine ;
                    //如果一行过长，可以提前拆分成多行
                    while ((contentLine = br.readLine()) != null) {
                        contentLine = contentLine.toLowerCase();
                        // 读取每一行，并输出
                        //System.out.println(contentLine);
                        String[] lineWords = contentLine.split(" ");
                        for (String lineWord : lineWords) {
                            if(lineWord.endsWith(".")){
                                lineWord = lineWord.substring(0,lineWord.length()-1);
                            }
                            //存储word
                            if(!map.containsKey(lineWord)){
                                map.put(lineWord,new Info(1,fileIndex));
                            }else {
                                Info temp = map.get(lineWord);
                                //是否在当前文档记录过该单词
                                if (!temp.list.contains(fileIndex)) {
                                    temp.freq++;
                                    temp.list.add(fileIndex);
                                }
                            }
                        }
                    }
                }
            }
            //遍历map,写入文件
            Set<String> keywords = map.keySet();
            for (String keyword : keywords) {
                StringBuilder str = new StringBuilder();
                str.append(keyword+" ");
                str.append(map.get(keyword).freq+" ");
                List<Integer> list = map.get(keyword).list;
                for (Integer position : list) {
                    str.append(position+" ");
                }
                System.out.println(str);
                bw.write(str.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void search(String str){
        BufferedReader br = null;
        Map<String,Info> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("document//indexFile"));
            String line;
            while ((line = br.readLine()) != null){
                String[] lineWords = line.split(" ");
                Info temp = new Info();
                temp.freq = Integer.parseInt(lineWords[1]);
                for (int i = 2; i < lineWords.length; i++) {
                    temp.list.add(Integer.parseInt(lineWords[i]));
                }
                map.put(lineWords[0],temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(map.containsKey(str)){
            StringBuilder s = new StringBuilder();
            s.append(str).append(" ");
            s.append("freq：").append(map.get(str).freq).append(" ");
            s.append("position—list:");
            List<Integer> list = map.get(str).list;
            for (Integer position : list) {
                s.append(position).append(" ");
            }
            System.out.println(s);
        }else {
            System.out.println("未找到");
        }
    }

    @Test
    public void test1(){

        //creatInvertedIndex("document");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("please enter a word:");
            String str = sc.nextLine();
            str = str.toLowerCase();
            if(str.endsWith(".")){
                str = str.substring(0,str.length()-1);
            }
            System.out.println(str);
            try {
                search(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
