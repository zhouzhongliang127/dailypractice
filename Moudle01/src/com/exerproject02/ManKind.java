package com.exerproject02;

/**
 * @author zzl
 * @Description
 * @date 2021/9/29 - 10:21
 */
public class ManKind {
    private int sex;
    private int salary;

    public void manOrWoman(){
        if(sex == 1) System.out.println("man");
        else if(sex == 0) System.out.println("woman");
    }

    public void employed(){
        if(salary == 0) System.out.println("no job");
        else if(salary != 0) System.out.println("job");

    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
