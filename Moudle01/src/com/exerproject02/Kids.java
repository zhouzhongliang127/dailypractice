package com.exerproject02;

/**
 * @author zzl
 * @Description
 * @date 2021/9/29 - 10:24
 */
public class Kids extends ManKind{
    private int yearsOld;

    public void printOld(){
        System.out.println("age = "+yearsOld);

    }
    public void setYearsOld(int age){
        this.yearsOld = age;
    }
    public int getYearsOld(){
        return yearsOld;
    }
}
