package com.edu.poly_.polyarr_;

/*
     one person, two students, two teachers. call say method in each object.
     student should call study method
     teacher should call teach method
*/
public class PolyArr {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("smith",1);
        persons[1] = new Student("bob",21,20);
        persons[2] = new Student("linda",11,32);
        persons[3] = new Teacher("Thomas",30,2000);
        persons[4] = new Teacher("lucy",33,2300);

        for (int i = 0; i < persons.length; i++) {
            Person p = persons[i];
            System.out.println(p.say());

            if (p instanceof Student) { // downcasting to instance of student
                ((Student) p).study();
            } else if (p instanceof Teacher) {// downcasting to instance of teacher
                ((Teacher) p).teach();
            }
        }
    }
}
