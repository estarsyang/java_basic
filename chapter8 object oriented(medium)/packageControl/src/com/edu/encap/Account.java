package com.edu.encap;

public class Account {
    /*
        two class, `Account`, `AccountTest`.
        1. `Account`: name(2-4), balance(>20), password(6 numbers). if not, show warning and assign default.
        2. Assign value base on setXxxx.
        3. Test in `AccountTest`.
     */

    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int len = name.length();
        if (len >= 2 && len <= 4) {
            this.name = name;
        } else {
            System.out.println("length of name must be 2 - 4, default name 'anonymous' is assigned");
            this.name = "anonymous";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 20) {
            this.balance = balance;
        } else {
            System.out.println("balance must be greater than or equal to 20 , default value 0 is assigned");
            this.balance = 0.0;
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("the length of password must be 6 , default password 000000 is assigned");
            this.password = "000000";
        }
    }

    public void showInfo() {
        System.out.println("name is " + name + ", balance is " + balance + ", password is " + password);
    }
}
