package com.edu.encap;

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account();
        account.setName("tom");
        account.setBalance(30);
        account.setPassword("123456");
        account.showInfo();

        Account bob = new Account("bob", 10, "23210381080");
        bob.showInfo();
    }
}
