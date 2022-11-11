package com.exerproject02;

/**
 * @author zzl
 * @Description
 * @date 2021/9/29 - 10:26
 */
public class KidTest {
    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.setYearsOld(8);
        someKid.setSalary(100);
        someKid.setSex(1);
        someKid.printOld();
        someKid.manOrWoman();
        someKid.employed();
    }
}
