package com.teamproject.domain;

import com.teamproject.service.Data;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 8:59
 */
public class Architect extends Designer{

    private int stock;//公司奖励的股票数量


    public Architect(int id, String name, int age, double salary,Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary,equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
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
        return getDetails()+occupation+"\t"+status+"\t"+getBonus()+"\t\t"+stock+"\t"+getEquipment().getDescription();
    }
}
