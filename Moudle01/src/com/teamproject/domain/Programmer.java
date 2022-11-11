package com.teamproject.domain;

import com.teamproject.service.Data;
import com.teamproject.service.Status;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 8:52
 */
public class Programmer extends Employee{

    private int memberId;//团队中的id
    Status status =Status.FREE;
    private Equipment equipment;//该成员领用的设备


    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
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
        return getDetails()+occupation+"\t"+status+"\t"+"\t\t\t\t\t"+equipment.getDescription();
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }



}
