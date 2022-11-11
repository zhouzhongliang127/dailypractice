package com.exerproject07;

import java.util.Arrays;

/**
 * @author zzl
 * @Description
 * @date 2021/10/5 - 19:49
 */
public class StringTest {

    public String trim(String str){
        int front = 0,rear = str.length()-1;
        if (str.length() == 0) return null;
        char[] c = new char[str.length()];
        c = str.toCharArray();
       while (front < rear){
            if (c[front] == ' ') {
                front++;
            }
            if (c[rear] == ' ') {
                rear--;
            }
            if (c[front] != ' '&& c[rear] != ' ') break;
        }
        return str.substring(front,rear);
    }


   /**
    * 功能描述: <br>
    * <判断短串在长串中出现的次数>
    * @param str1
 * @param str2
    * @Return: int
    * @Author: zzl
    * @Date: 2021/10/5 20:38
    */
    public int similarCount(String str1,String str2){
        int count = 0;
        int index = 0;
        if(str2.startsWith(str1)) count++;
        while (true){
            //indexOf是在前串中找后串，即后串在前串中的下标
            index = str2.indexOf(str1,index+str1.length());
            if(index > 0) count++;
            else break;
        }
        return count;
    }

    public String sub(String str1,String str2){
        String str = "";
        if (str1.indexOf(str2) != 0) return str2;
        for (int i = str2.length()-1; i > 0 ; i--) {
            for (int j = 0; j <= str2.length()-i; j++) {
                //subString的endindex不会切入返回值
                 str = str2.substring(j , j + i );
                if(str1.indexOf(str) != 0){
                    return str;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        StringTest t = new StringTest();
//        String str = "  hello world!   ";
//        System.out.println("str1 = " + str+"---");
//        System.out.println("---"+t.trim(str)+"---");
//
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(t.sub(str1,str2));
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        System.out.println(s);
    }

}
