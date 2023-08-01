package com.edu.homework.homework13;

/*
    1. Student class, name,gender,age, stu_id. methods including study
    2. Teacher class, name,gender,age, work_age. methods including teach
    3. Student and Teacher have common method name play. Student play basketball, Teacher play football.
    and play return a string. Return template is "xx play basketball" or "xx play football".
    play method need to define in Person class.
    4. Person class, encapsulate common properties and methods.
    5. Student and Teacher have printInfo method to print all message.
    6. Define polymorphism array, store two students and two teacher, sort by age base on descending
    7. Define a method, formal argument is Person, function is calling study method of student
     or teach method of teacher.
 */
public class Homework13 {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Student("tom", "boy", 11, 123);
        people[1] = new Student("bob", "girl", 12, 456);
        people[2] = new Teacher("marry", "boy", 22, 10);
        people[3] = new Teacher("Jeff", "girl", 33, 5);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

        people[0].printInfo();
        people[3].printInfo();

        Homework13 homework13 = new Homework13();
        homework13.bubbleSort(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);

            homework13.doing(people[i]);
        }
    }
    // sort
    public void bubbleSort(Person[] persons) {
        Person temp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].getAge() < persons[j + 1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    public void doing(Person p){
        if (p instanceof Student){
            ((Student) p).study();
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        } else {
            System.out.println("do something...");
        }
    }
}
