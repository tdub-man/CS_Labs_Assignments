package bankAccount;

/**
 * Created by Ben on 8/24/2015.
 */
public class BankAccount extends Object {
    private String accountId;  // can't be changed
        // accountId must be assigned in a constructor
    private double balance;
        // only change through withdraw and deposit
    private Person owner;


    public BankAccount(String theAccountId) {
        this.accountId = theAccountId;
        balance = 0.0;
    }

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        balance = initialBalance;
    }

//    public BankAccount() {
//
//    }
//
//    public void setId(String id) {
//        accountId = id;
//    }
    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person newOwner) {
        owner = newOwner;
    }

    /**
     * Deposit the given amount to this account.
     *
     * @param amount
     */
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        } else {
            System.out.println("amount to depsoit was not positive: " + amount);
            System.exit(1);
        }
    }

    public void withdraw(double amount) {
        if(amount < 0 || amount > balance) {
            // error!!!
            System.out.println("amount to withdraw is incorrect: " + amount);
            System.exit(1);
        } else {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "account balance " + getBalance() + " owner " + getOwner().getName();
    }
}







