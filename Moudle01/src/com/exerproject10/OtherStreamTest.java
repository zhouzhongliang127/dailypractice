package com.exerproject10;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zzl
 * @Description
 * @date 2021/10/13 - 21:28
 */
public class OtherStreamTest {

    @Test
    public void test1(){
        BufferedReader bfr = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);

            bfr = new BufferedReader(isr);

            while (true){
                System.out.println("请输入字符：");
                String str = bfr.readLine();
                if("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)){
                    System.out.println("程序结束");
                    break;
                }else {
                    System.out.println(str.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
