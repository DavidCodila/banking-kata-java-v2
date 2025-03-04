package au.com.auspost.account;

import java.security.InvalidParameterException;

public class Account {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.validateAmount(amount);
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.validateWithdrawal(amount);
        this.balance += amount;
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new InvalidParameterException("Amount can not be less than 1");
        }
    }

    private void validateWithdrawal(int amount) {
        validateAmount(amount);
        if (amount > this.balance) {
            throw new RuntimeException("Insufficient funds");
        }
    }

}
