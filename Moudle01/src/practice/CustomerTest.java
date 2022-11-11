package practice;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @author zzl
 * @Description
 * @date 2021/9/28 - 14:24
 */
public class CustomerTest {
    public static void main(String[] args) {

        Customer cust = new Customer("Jane","Smith");

        Account acct = new Account(1000, 2000,0.0123);
        cust.setAccount(acct);

        cust.getAccount().deposit(100);
        cust.getAccount().withdraw(960);
        cust.getAccount().withdraw(2000);
        System.out.println("Customer[" + cust.getLastName() + "," + cust.getFirstName()
                + "] has a account : id is " + cust.getAccount().getId() + ", annualInterestRate is " +
                cust.getAccount().getAnnualInterestRate() * 100 + "%, balance is :" + cust.getAccount().getBalance()
        );

    }
}
