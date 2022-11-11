package com.test;

import org.junit.jupiter.api.Test;

/**
 * @author zzl
 * @Description
 * @date 2021/9/30 - 15:39
 */
public class WrapperTest {
    @Test
    public void test1(){
        Float f1 = new Float(12.3);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);

        Integer num = 10;
        int i = num;
        System.out.println("num = " + num);
        System.out.println("i = " + i);
    }
}
