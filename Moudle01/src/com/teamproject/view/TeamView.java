package com.teamproject.view;

import com.teamproject.domain.Employee;
import com.teamproject.domain.Programmer;
import com.teamproject.service.NameListService;
import com.teamproject.service.TeamException;
import com.teamproject.service.TeamService;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 13:43
 */
public class TeamView {
    NameListService listSvc =new NameListService();
    TeamService TeamSvc = new TeamService();
    Employee[] employees = listSvc.getAllEmployees();

    private void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            listAllEmployees();
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出");
            char c = TSUtility.readMenuSelection();
            switch (c){
                case '1':getTeam();break;
                case '2':addMember();break;
                case '3':deleteMember();break;
                case '4':{
                    System.out.println("确认是否退出（Y/N):");
                    char c1 = TSUtility.readConfirmSelection();
                    if(c1 == 'Y')
                    {
                        isFlag = false;
                    }
                }
            }


        }

    }

    private void listAllEmployees(){
        System.out.println("--------------------开发团队调度软件--------------------");
        System.out.println("ID\t\t姓名\t年龄\t工资\t职位\t状态\t奖金\t\t股票\t设备");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
        System.out.println("-------------------------------------------------------");
    }

    private void getTeam(){
        System.out.println("---------------团队列表---------------");
        if(TeamSvc.getTotal() == 0){
            System.out.println("团队暂无成员！");
            TSUtility.readReturn();
            return;
        }
        Programmer team[] = TeamSvc.getTeam();
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t\t股票\t设备");
        for (int i = 0; i < TeamSvc.getTotal(); i++) {
            System.out.println(team[i].getMemberId()+"/"+team[i].toString());
        }
        System.out.println("-------------------------------------------");
        TSUtility.readReturn();
    }

    private void addMember(){
        System.out.println("---------------添加成员---------------");
        while (true) {
            try {
                System.out.println("请输入要添加的员工号");
                int id = TSUtility.readInt();
                TeamSvc.addMember(employees[id-1]);
                System.out.println("添加成功");
                TSUtility.readReturn();
                break;
            } catch (TeamException e) {
                System.out.println(e.getMessage());
                if(e.getMessage().equals("成员已满，无法添加！")){
                    break;
                }
            }
        }
    }

    private void deleteMember(){
        System.out.println("---------------删除成员---------------");
        if(TeamSvc.getTotal() == 0){
            System.out.println("团队暂无成员！");
            TSUtility.readReturn();
            return;
        }
        while (true){
            try {
                System.out.println("请输入你想删除的TID：");
                int memberId = TSUtility.readInt();
                System.out.println("确认是否删除（Y/N):");
                char c = TSUtility.readConfirmSelection();
                if(c == 'N')
                {
                    System.out.println("取消删除");
                    TSUtility.readReturn();
                    return;
                }
                TeamSvc.removeMember(memberId);
                System.out.println("删除成功");
                TSUtility.readReturn();
                break;
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TeamView v = new TeamView();
        v.enterMainMenu();
    }


}
