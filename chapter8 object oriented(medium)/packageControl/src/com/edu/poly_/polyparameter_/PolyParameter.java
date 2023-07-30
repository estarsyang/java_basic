package com.edu.poly_.polyparameter_;
/*
    2. Test class add one methods named `showEmpAnnual(Employee e)` to get one employee's annual salary,
    and call this method in main function.
    3. Test class add one methods name `testWork`, if pass one worker, call `work` method. if pass one manager,
    call `manage` method.
 */
public class PolyParameter {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 3000);
        Manager bob = new Manager("bob", 5000, 30000);
        PolyParameter polyParameter = new PolyParameter();
        polyParameter.showEmpAnnual(tom);
        polyParameter.showEmpAnnual(bob);

        polyParameter.testWork(tom);
        polyParameter.testWork(bob);
    }

    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker){
            ((Worker) e).work();
        } else if (e instanceof Manager){
            ((Manager) e).manage();
        }
    }
}
