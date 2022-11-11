package leetcode;

import java.util.HashMap;

/**
 * @author zzl
 * @Description
 * @date 2021/10/31 - 19:47
 */
public class Keyboard_Row {
    public static String[] findWords(String[] words) {
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        HashMap<String,Integer> map3 = new HashMap<>();
        for(int i = 0;i < str1.length();i++){
            map1.put(String.valueOf(str1.charAt(i)),i);
        }
        for(int i = 0;i < str2.length();i++){
            map2.put(String.valueOf(str2.charAt(i)),i);
        }
        for(int i = 0;i < str3.length();i++){
            map3.put(String.valueOf(str3.charAt(i)),i);
        }
        int[] count = new int[words.length];
        int num = 0;
        int index,flag = 0;
        for(int i = 0;i < words.length;i++){
            if(words[i].length()==1) {
                num++;
                count[i] = 1;
                continue;
            }
            index = 1;flag = 1;
            if(map1.containsKey(String.valueOf(words[i].charAt(0)).toLowerCase())){
                while(index<words[i].length()){
                    if(!map1.containsKey(String.valueOf(words[i].charAt(index++)).toLowerCase()))
                    {
                        flag = 0;
                        break;
                    }
                }
            }
            if(map2.containsKey(String.valueOf(words[i].charAt(0)).toLowerCase())){
                while(index<words[i].length()){
                    if(!map2.containsKey(String.valueOf(words[i].charAt(index++)).toLowerCase()))
                    {
                        flag = 0;
                        break;
                    }
                }
            }
            if(map3.containsKey(String.valueOf(words[i].charAt(0)).toLowerCase())){
                while(index<words[i].length()){
                    if(!map3.containsKey(String.valueOf(words[i].charAt(index++)).toLowerCase()))
                    {
                        flag = 0;
                        break;
                    }
                }
            }
            if(flag == 1){
                count[i] = 1;
                num++;
            }
        }
        index = 0;
        String[] strs = new String[num];
        for(int i = 0;i<words.length;i++){
            if(count[i]==1)
                strs[index++] = words[i];
        }
        return strs;
    }

    public static void main(String[] args) {
        String[] words = {"Aasdfghjkl","Qwertyuiop","zZxcvbnm"};
        String[] strs = findWords(words);
        for (String str : strs) {
            System.out.print(str+"  ");
        }
    }
}
