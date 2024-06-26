package com.edu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class SmallChangeSys {

    // 1. do UI, and select menu.
    // 2. show 1. small change detail
    // 3. 2. income
    // 4. 3. outcome
    // 5. exit.
    // 6. exit warning. if input 4, give warning "do you want to exit? y/n". must be correct.
    // otherwise warning again until correct answer.
    // 7. verify monty is reasonable.
    // 8. rewrite Procedure oriented to Object oriented.


    public static void main(String[] args) {

        // define variable
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        // 2. show 1. small change detail
        // idea:(1) use array to store data. (2) use object to store data(3) most simple, use String to contact.
        // this case use (3), just for an exercise.
        String detail = "--------small change detail--------";

        // 3. 2. income
        // define variables, money, date, balance
        double money = 0;
        double balance = 0;
        Date date = null;
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        // 4. 3. outcome
        // define variable outComeItem
        String outComeItem = "";


        do {
            System.out.println("\n------------Small Change menu--------");
            System.out.println("\t\t1. small change detail");
            System.out.println("\t\t2. income");
            System.out.println("\t\t3. outcome");
            System.out.println("\t\t4. exit");

            System.out.print("Please select(1-4):");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.print("Please input this income:");
                    money = scanner.nextDouble();
                    // money verify
                    // a program tip, find error case is easy to read code.
                    if (money <= 0) {
                        System.out.println("input money error, should be > 0;");
                        break;
                    }
                    balance += money;

                    date = new Date(); // current date
                    dateStr = sdf.format(date);

                    detail += "\nincome\t+" + money + "\t" + dateStr + "\t" + balance;
                    break;
                case "3":
                    System.out.print("Please input this outcome:");
                    money = scanner.nextDouble();
                    // money verify
                    // a program tip, find error case is easy to read code.
                    if (money <= 0 || money > balance) {
                        System.out.println("output money error, should be > 0 and " + balance);
                        break;
                    }
                    balance -= money;

                    System.out.print("Please input outcome note:");
                    outComeItem = scanner.next();
                    date = new Date(); // current date
                    dateStr = sdf.format(date);

                    detail += "\n" + outComeItem + "\t-" + money + "\t" + dateStr + "\t" + balance;
                    break;
                case "4":
                    // 5. exit.
                    // 6. exit warning. if input 4, give warning "do you want to exit? y/n". must be correct.
                    // otherwise warning again until correct answer.
                    // (1) define a variable to store input text.
                    // (2) loop warning until input is correct
                    // (3) after exit loop warning, doing exit whole system.
                    String choice = "";
                    String exitYes = "y";
                    String exitNo = "n";

                    while (true) { // only do loop warning until input is correct not add other logic
                        System.out.print("do you want to exit? y/n :");
                        choice = scanner.next();
                        if (exitYes.equals(choice) || exitNo.equals(choice)) {
                            break;
                        }
                    }

                    if (exitYes.equals(choice)) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("input error.");
            }
        } while (loop);
    }
}
