package com.exerproject10;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zzl
 * @Description
 * @date 2021/10/13 - 19:09
 */
public class WordCount {

    @Test
    public void test1() {
        Map<Character,Integer> map = new HashMap<>();
        BufferedReader bf = null;
        BufferedWriter bw = null;
        try {//一开始用的main方法的相对路径在project下，所以找不到文件
            bf = new BufferedReader(new FileReader("孔乙己.txt"));
            bw = new BufferedWriter(new FileWriter("WordCount.txt"));

            int len;
            char[] chars = new char[10];
            while ((len = bf.read(chars)) != -1){
                for (char aChar : chars) {
                    if(!map.containsKey(aChar)){
                        map.put(aChar,1);
                    }else {
                        int count = map.get(aChar) + 1;
                        map.put(aChar, count);
                    }
                }
            }
            Set<Map.Entry<Character,Integer>> set = map.entrySet();
            for (Map.Entry<Character, Integer> entry : set) {
                char c = entry.getKey();
                //System.out.println(c);
                switch (c){
                    case ' ':
                        bw.write("空格："+entry.getValue());
                        break;
                    case '\t':
                        bw.write("制表符："+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行:"+entry.getValue());
                        break;
                    case '\r':
                        bw.write("换行："+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
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
}
