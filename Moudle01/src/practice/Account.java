package practice;

/**
 * @author zzl
 * @Description
 * @date 2021/9/27 - 23:33
 */
public class Account{
    private int id;
    private double balance;
    private double annualInterestRate;


    public Account(int id,double balance,double annualInterestRate){

        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }


    public void deposit(double amount){
        this.balance += amount;
        System.out.println("存款成功！当前可用余额为："+balance);
    }


    public void withdraw(double amount){
        if(amount <= balance)
        {
            this.balance -= amount;
            System.out.println("取款成功，当前余额要求为："+balance);
        }

        else
            System.out.println("余额不足，取款失败！");

    }
}
