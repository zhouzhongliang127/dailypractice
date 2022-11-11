package practice;

/**
 * @author zzl
 * @date 2021/9/20 - 16:43
 */
public class FamilyAccount {
    public static void main(String[] args){
        boolean isFlag = true;
        //用于记录用户的收入和支出的详情
        String details = "收支\t账户金额\t收支金额\t说    明\n";
        //初始金额
        int balance = 10000;

        while (isFlag) {
            System.out.println("-----------------家庭收支记账软件-----------------\n");
            System.out.println("                    1 收支明细");
            System.out.println("                    2 登记收入");
            System.out.println("                    3 登记支出");
            System.out.println("                    4 退    出\n");
            System.out.print("                    请选择(1-4)：");
            //获取用户输入
            char selection = Utility.readMenuSelection();
            switch (selection)
            {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);

                    System.out.println();
                    System.out.println("---------------------------------------------");

                    break;
                case '2':
                    System.out.println("收入情况");
                    System.out.print("本次收入金额：");
                    int money_in = Utility.readNumber();
                    balance += money_in;

                    System.out.print("本次收入说明：");
                    String info_in = Utility.readString();

                    details += "收入\t"+balance+"\t"+money_in+"\t\t"+info_in+"\n";

                    break;
                case  '3':
                    System.out.println("支出情况:");
                    System.out.print("本次支出金额：");
                    int money_out = Utility.readNumber();
                    balance -= money_out;

                    System.out.print("本次支出说明：");
                    String info_out = Utility.readString();

                    details += "支出\t"+balance+"\t"+money_out+"\t\t"+info_out+"\n";
                    break;

                case '4':
                    System.out.println("你确认要退出嘛？（y/n)");
                    char y_n = Utility.readConfirmSelection();

                    if(y_n == 'Y') {
                        isFlag = false;

                    }
                    break;
            }

        }
    }
}
