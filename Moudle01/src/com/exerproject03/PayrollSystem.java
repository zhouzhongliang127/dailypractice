package com.exerproject03;

/**
 * @author zzl
 * @Description
 * @date 2021/10/1 - 23:29
 */
public class PayrollSystem {

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new SalariedEmployee("zzl",1001,new MyDate(1999,11,27),30000);
        employees[1] = new HourlyEmployee("zk",1002,new MyDate(1999,11,27));
        HourlyEmployee em1 = (HourlyEmployee)employees[1];
        em1.setWage(20);
        em1.setHour(10);


        System.out.println(employees[1].toString());
    }
}
