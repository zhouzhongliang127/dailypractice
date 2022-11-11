package practice;

/**
 * @author zzl
 * @Description
 * @date 2021/9/28 - 14:22
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAccount(Account acct){
        this.account = acct;
    }
    public Account getAccount(){
        return account;
    }
}
