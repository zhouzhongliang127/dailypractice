import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author zzl
 * @Description
 * @date 2021/11/22 - 8:31
 */
public class Exercise_03 {
    public static List<Integer> getContainsDocsIndex(String str) {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = null;
        Map<String, Info> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("document//indexFile"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split(" ");
                Info temp = new Info();
                temp.freq = Integer.parseInt(lineWords[1]);
                for (int i = 2; i < lineWords.length; i++) {
                    temp.list.add(Integer.parseInt(lineWords[i]));
                }
                map.put(lineWords[0], temp);
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
        if (map.containsKey(str)) {
            list = map.get(str).list;
            return list;
        } else {
            System.out.println("未找到");
        }
        return null;
    }

    public static List<Integer> getCommonList(List<Integer> list1, List<Integer> list2){
        if(list1 == null || list2 == null) return null;
        List<Integer> commonList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        //index最多到size - 1
        for(;index1 < list1.size() && index2 < list2.size();){
            if(list1.get(index1) == list2.get(index2)){
                commonList.add(list1.get(index1));
                index1++;
                index2++;
            }else{
                if (list1.get(index1) < list2.get(index2)) {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        return commonList;
    }
    @Test
    public void test1(){

        //creatInvertedIndex("document")];
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("please enter  words:");
            String str = sc.nextLine();
            str = str.toLowerCase();
            if(str.endsWith(".")){
                str = str.substring(0,str.length()-1);
            }
            String[] strs = str.split(" ");
            String[] words = new String[strs.length];
            //取输入前的前两个单词，以空格分隔
            for (int i = 0; i < words.length; i++) {
                words[i] = strs[i];
                if(words[i].endsWith(".")){
                    words[i] = words[i].substring(0,words[i].length()-1);
                }
            }

            List<Integer> list1 = getContainsDocsIndex(words[0]);
            List<Integer> list2 = getContainsDocsIndex(words[1]);
            List<Integer> commonList = getCommonList(list1,list2);
            //该commonList与包含后面单词的集合依次取交集
            for (int i = 2; i < words.length; i++) {
                list1 = getContainsDocsIndex(words[i]);
                commonList = getCommonList(commonList,list1);
            }
            System.out.print("docList:");
            if(commonList != null){
                for (Integer integer : commonList) {
                    System.out.print(integer+" ");
                }
            }else{
                System.out.print("null");
            }
            System.out.println("\n");
        }

    }
}

