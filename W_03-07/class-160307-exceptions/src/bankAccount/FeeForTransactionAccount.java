package bankAccount;

/**
 * This is a bank account but there is a fee charged for each deposit
 * and each withdrawal.
 *
 * FeeForTrnaasactionAccount is a subclass of BankAccount
 *
 *
 * Created by Ben on 8/24/2015.
 */
public class FeeForTransactionAccount extends  BankAccount {

    private double depositFee;
    private double withdrawalFee;

    public FeeForTransactionAccount(String accountId) {
        super(accountId);
    }

    public FeeForTransactionAccount(String accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    public double getDepositFee() {
        return depositFee;
    }

    public void setDepositFee(double depositFee) {
        this.depositFee = depositFee;
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

    @Override
    public void deposit(double amount) {
        if(amount > 0 && (getBalance() + amount >= depositFee)) {
            super.deposit(amount);
            super.withdraw(depositFee);
        } else {
            System.out.println("amount of deposit should be positive " +
                    "and sufficient to cover the deposit fee: " + amount);
            System.exit(1);
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0 && (getBalance() >= amount + withdrawalFee)) {
            super.withdraw(amount);
            super.withdraw(withdrawalFee);
        } else {
            System.out.println("amount of withdrawal should be positive " +
                    "and the balance should be sufficient to cover " +
                    "that amount and the withdrawal fee: " + amount);
            System.exit(1);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " deposit fee " + getDepositFee();
    }
}
