package com.exerporject01;

/**
 * @author zzl
 * @Description
 * @date 2021/9/28 - 17:52
 */
public class CustomerView {

    private CustomerList customers = new CustomerList(10);


    public CustomerView() {
        Customer cust = new Customer("张三", '男', 30, "010-56253825",
                "abc@email.com");
        customers.addCustomer(cust);
    }

    /**
     * 功能描述: <br>
     * <显示主界面的方法>
     *
     * @param
     * @Return: void
     * @Author: zzl
     * @Date: 2021/9/28 18:30
     */
    public void enterMainMenu() {
        boolean loopFlag = true;
        while (loopFlag) {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CMUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("手机号码：");
        String phone = CMUtility.readString(20);
        System.out.print("email：");
        String email = CMUtility.readString(20);
        Customer cust = new Customer(name,gender,age,phone,email);
        boolean flag = customers.addCustomer(cust);
        if(flag) System.out.println("---------------------添加完成---------------------");
        else
            System.out.println("---------------------客户已满，无法添加---------------------");
    }

    private void modifyCustomer() {
        Customer cust = null;
        int index;
        System.out.println("---------------------修改客户信息---------------------");
        System.out.println("请输入你要修改的客户所在位置：(-1退出)");
        while (true){
             index = CMUtility.readInt();
            if (index == -1) return;
             cust = customers.getCustomer(index-1);
            if(cust == null) System.out.println("该客户不存在");
            else break;
        }
        System.out.println("姓名：");
        String name = CMUtility.readString(4,cust.getName());
        System.out.print("性别：");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄：");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("手机号码：");
        String phone = CMUtility.readString(20,cust.getPhone());
        System.out.print("email：");
        String email = CMUtility.readString(20,cust.getEmail());
        cust = new Customer(name,gender,age,phone,email);
        boolean flag = customers.replaceCustomer(index-1,cust);
        if (flag) System.out.println("修改成功！");
        else System.out.println("修改失败！");

    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        int index = 0;
        Customer cust = null;
        System.out.println("请输入你想要删除的客户号：(-1退出)");
        while (true){
            index = CMUtility.readInt();
            if (index == -1) return;
            cust = customers.getCustomer(index-1);
            if(cust == null) System.out.println("该客户不存在");
            else break;
        }
        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'N')
            return;
        boolean flag = customers.deleteCustomer(index-1);
        if (flag) System.out.println("删除成功！");
        else System.out.println("删除失败！");
    }

    private void listAllCustomers() {
        Customer[] custs = customers.getAllCustomer();
        if(custs.length == 0) System.out.println("没有客户记录");
        else{
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
                System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
            }

        }



    public static void main(String[] args) {

        CustomerView v = new CustomerView();
        v.enterMainMenu();
    }
}
