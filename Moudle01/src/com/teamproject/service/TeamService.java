package com.teamproject.service;

import com.teamproject.domain.Architect;
import com.teamproject.domain.Designer;
import com.teamproject.domain.Employee;
import com.teamproject.domain.Programmer;

import static com.teamproject.service.Status.BUSY;
import static com.teamproject.service.Status.FREE;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 10:32
 */
public class TeamService {
    public static int counter = 1;//用于生产memberId
    public static final int MAX_MEMBER = 5;//团队最大人数

    public static int programmerAmount = 0;
    public static int designerAmount = 0;
    public static int architectAmount = 0;



    Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;//记录团队实际人数

    public TeamService() {
    }

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[this.team.length];
        for (int i = 0; i < total; i++) {
            team[i]  = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException{
        if(total == 5){
            throw new TeamException("成员已满，无法添加！");
        }else if(Data.EMPLOYEES[e.getId()-1][0].equals("10")){
            throw new TeamException("该成员不是开发人员，无法添加！");
        }else if(((Programmer)e).getStatus() == BUSY){
            throw new TeamException("该成员已在组内，无法重复添加！");
        }else if(Data.EMPLOYEES[e.getId()-1][0].equals("11")&&programmerAmount == 3){
            throw new TeamException("团队程序员人数已满");
        }else if(Data.EMPLOYEES[e.getId()-1][0].equals("12")&&designerAmount == 2){
            throw new TeamException("团队设计师人数已满");
        }else if(Data.EMPLOYEES[e.getId()-1][0].equals("13")&&architectAmount == 1){
            throw new TeamException("团队架构师人数已满");
        }
        //也可每次进入之前遍历获取各种工种的员工数量，范围小的在前面
        if(Data.EMPLOYEES[e.getId()-1][0].equals("11")){
            Programmer p = (Programmer)e;
            p.setMemberId(counter++);
            team[total++] = p;
            programmerAmount++;
            p.setStatus(BUSY);
        }
        if(Data.EMPLOYEES[e.getId()-1][0].equals("12")){
            Designer p = (Designer) e;
            p.setMemberId(counter++);
            team[total++] = p;
            designerAmount++;
            p.setStatus(BUSY);
        }
        if(Data.EMPLOYEES[e.getId()-1][0].equals("13")){
            Architect p = (Architect)e;
            p.setMemberId(counter++);
            team[total++] = p;
            architectAmount++;
            p.setStatus(BUSY);
        }
    }
//这里应该是根据TID进行删除，不可直接按顺序位置删
    //应该根据memberId找到index，然后向前覆盖，如果找不到就throw
    public void removeMember(int memberId) throws TeamException {
        if (memberId < 0 || memberId > total)
            throw new TeamException("找不到该成员！");
        if (Data.EMPLOYEES[team[memberId - 1].getId() - 1][0].equals("11")) {
            programmerAmount--;
            team[memberId - 1].setStatus(FREE);

        }
        if (Data.EMPLOYEES[team[memberId - 1].getId() - 1][0].equals("12")) {
            designerAmount--;
            team[memberId - 1].setStatus(FREE);
        }
        if (Data.EMPLOYEES[team[memberId - 1].getId() - 1][0].equals("13")) {
            architectAmount--;
            team[memberId - 1].setStatus(FREE);
        }


            for (int j = memberId; j < total; j++)
                team[j - 1] = team[j];

            team[--total] = null;

    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
