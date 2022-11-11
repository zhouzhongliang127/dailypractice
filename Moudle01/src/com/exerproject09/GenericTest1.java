package com.exerproject09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zzl
 * @Description
 * @date 2021/10/10 - 22:08
 */
public class GenericTest1 {
    @Test
    public void test1(){
        Order<String> order = new Order<>();
        order.setOrderT("ko");
        order.setOrderT("ACB");

        String[] stars = new String[10];
        ArrayList<String> strings = new ArrayList<>();
        Arrays.asList(stars);
    }
}
