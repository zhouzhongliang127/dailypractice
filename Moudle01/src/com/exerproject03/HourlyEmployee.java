package com.exerproject03;

/**
 * @author zzl
 * @Description
 * @date 2021/10/1 - 23:26
 */
public class HourlyEmployee extends Employee{

    private int wage;
    private int hour;

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    @Override
    public int earnings() {
        return wage*hour;
    }

    @Override
    public String toString() {
        return "[ name:"+getName()+", number:"+getNumber()+",birthday:"+getBirthday().toDateString()+"]";
    }
}
