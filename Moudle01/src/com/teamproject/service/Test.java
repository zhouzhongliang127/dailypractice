package com.teamproject.service;

import com.teamproject.domain.Employee;
import com.teamproject.domain.Programmer;
import com.teamproject.view.TSUtility;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 9:56
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        NameListService v =new NameListService();
        TeamService t = new TeamService();
        Employee[] employees = v.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
//        try {
//            System.out.println(v.getEmployee(3).toString());
//        } catch (TeamException e) {
//            System.out.println(e.getMessage());
//        }
        boolean iscontinue = true;
        while (iscontinue){

            try {
                System.out.println("请输入要添加的员工号");
                int id = TSUtility.readInt();
                t.addMember(employees[id-1]);
                Programmer team[] = t.getTeam();
                for (int i = 0; i < t.getTotal(); i++) {
                    System.out.println(team[i].toString());
                }
                System.out.println("请输入你想删除的员工号：");
                id = TSUtility.readInt();
                t.removeMember(id);
                team = t.getTeam();
                for (int i = 0; i < t.getTotal(); i++) {
                    System.out.println(team[i].toString());
                }
                System.out.println("--------------------------");
                for (int i = 0; i < employees.length; i++) {
                    System.out.println(employees[i].toString());
                }

            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }

        }


    }
}
