package com.exerproject06;

import static java.lang.Thread.sleep;

/**
 * @author zzl
 * @Description
 * @date 2021/10/4 - 20:38
 */

class Account{
    private double balance;

    public Account(double balance){
        this.balance = balance;

    }

    //存钱
    public synchronized void deposit(double amt){//acct做为锁
        if (amt > 0){
            balance += amt;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
        }

    }

}

class Customer implements Runnable{
    private Account acct;


    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }


}
public class AccountTest {

    public static void main(String[] args) {
        Account acct = new Account(1000);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();


//        c1.setName("甲");
//        c2.setName("乙");
//
//        c1.start();
//        c2.start();
    }

}
