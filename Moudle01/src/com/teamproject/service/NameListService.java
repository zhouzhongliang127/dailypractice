package com.teamproject.service;

import com.teamproject.domain.*;

import static com.teamproject.service.Data.*;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 9:01
 */
public class NameListService {
    private Employee[] employees = new Employee[12];

    public NameListService() {

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            //提取员工类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            //普通员工的初始化
            //Employee  :  10, id, name, age, salary
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                //程序员的初始化
                //Programmer:  11, id, name, age, salary +equipment
                case PROGRAMMER: {
                    //此处对设备对象的获取最好封装到方法里，根据不同的类型返回new好的对象
                    Equipment equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                }
                //设计师
                //Designer  :  12, id, name, age, salary, bonus  +equipment
                case DESIGNER: {
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    Equipment equipment = createEquipment(i);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                }
                //架构师
                //Architect :  13, id, name, age, salary, bonus, stock
                case ARCHITECT: {
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    Equipment equipment = createEquipment(i);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
                }
            }
        }

    }

    public Equipment createEquipment(int i){
        switch (Data.EQUIPMENTS[i][0]) {
            case "21":
                return new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
            case "22":
                double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                return new NoteBook(Data.EQUIPMENTS[i][1], price);
            case "23":
                return new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException{
        if( id < 0 || id >= employees.length)
            throw new TeamException("找不到指定员工！");
        return employees[id-1];
    }

}
