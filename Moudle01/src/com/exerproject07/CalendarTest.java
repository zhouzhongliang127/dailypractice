package com.exerproject07;

import java.util.Calendar;

/**
 * @author zzl
 * @Description
 * @date 2021/10/6 - 21:19
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.DAY_OF_YEAR,3);
        System.out.println(calendar.getTime());


    }
}
