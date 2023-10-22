package com.java.exception_;

public class Homeworkd01 {
    /**
     * 1. get a result of two number by using args
     * 2. define a method name cal
     * 3. consider exception
     */
    public static void main(String[] args) {


        try {
            // no two value input
            if (args.length != 2){
                throw new ArrayIndexOutOfBoundsException("number of args is wrong");
            }

            // can't convert into number
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1,n2);

            System.out.println("result is " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("number format is wrong, it should be number");
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

    public static double cal(int n1, int n2) {
        return n1/n2;
    }
}
