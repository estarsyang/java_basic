package com.edu.homework;

/*
    1. Expand BankAccount class, each deposit and withdraw will cost 1 dollar in new class CheckingAccount.
    2. Expand BankAccount class, new class SavingsAccount will generate interest every month(call earnMonthlyInterest), and three times free fee in each
    month of deposit or withdraw. Reset operation times in method earnMonthlyInterest.
    3. Magic of override
 */
public class Homework8 {
    public static void main(String[] args) {
        // 1
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(10); // 1000 + 10 - 1 = 1009
        System.out.println(checkingAccount.getBalance());
        checkingAccount.withdraw(100); // 1009 - 100 - 1 = 908
        System.out.println(checkingAccount.getBalance());

        // 2
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(10);
        savingsAccount.deposit(10);
        savingsAccount.deposit(10);
        System.out.println(savingsAccount.getBalance()); // 1030

        savingsAccount.deposit(10); // 1039
        savingsAccount.earnMonthlyInterest(); // 1039 + 1039 * 0.1 = 1142.9

        savingsAccount.withdraw(10); // 1132.9
        savingsAccount.withdraw(10); // 1122.9
        savingsAccount.withdraw(10); // 1112.9
        savingsAccount.withdraw(10); // 1101.9, cost 1 dollar
        System.out.println(savingsAccount.getBalance()); // 1030.9


    }
}


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // deposit
    public void deposit(double amount) {
        balance += amount;
    }

    // withdraw
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) { // deposit cost 1
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {// withdraw cost 1
        super.withdraw(amount + 1);
    }
}

class SavingsAccount extends BankAccount {
    private int count = 3;
    private double rate = 0.1;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount - 1);
        }
        count--;
    }

    public void earnMonthlyInterest() {
        count = 3;
        super.deposit(getBalance() * rate);
    }
}