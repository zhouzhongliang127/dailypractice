package com.teamproject.domain;

import com.teamproject.service.Data;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 8:58
 */
public class Designer extends Programmer{


    private double bonus;//奖金


    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }



    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public String toString(){
        String occupation = "";
        if(Data.EMPLOYEES[getId()-1][0].equals("11")){
            occupation = "程序员";
        }
        if(Data.EMPLOYEES[getId()-1][0].equals("12")){
            occupation = "设计师";
        }
        if(Data.EMPLOYEES[getId()-1][0].equals("13")){
            occupation = "架构师";
        }
        return getDetails()+occupation+"\t"+status+"\t"+bonus+"\t\t\t\t"+getEquipment().getDescription();
    }
}
