package com.exerproject03;

/**
 * @author zzl
 * @Description
 * @date 2021/10/1 - 23:09
 */
public class SalariedEmployee extends Employee{

    private int monthlySalary;


    public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int earnings() {

        return  monthlySalary;
    }

    @Override
    public String toString() {
        return "[ name:"+getName()+", number:"+getNumber()+",birthday:"+getBirthday().toDateString()+"]";
    }
}
