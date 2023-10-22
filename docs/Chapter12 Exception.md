# chapter12 Exception

1. Introduction: Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program's instructions.
2. types:
   1. error: JVM can't solve these problems, i.e. JVM system error, resource run out, for example, StackOverflowError and OOM(out of memory). Error is a serious problems, program will stop.
   2. exception: coding error or other case will lead some problems but not important, can be fix by special code. for example, null pointer, read don't exist files, network loss and so on.
      1. types:
         1. unchecked(run time) exception: NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException and so on. Run time exception have default handle if no one to handle it.
         2. checked(complier time) exception: FileNotFoundException, SQLException, IOException and so on. must be handled since it no default handle.
3. Exception handle

   1. try catch finally

      1. hot key: command+option+t
      2. Basic grammer

         ```java
         try {
            // some code may throw a error
         } catch (Exception e) {
            // do hanle when error happen
            // when error happen, code in this block will be executed
         }
         finally {
            // always exeute these code in this block
         }
         ```

      3. tips:

         1. could be more `catch`, catch differents errors. Using different error catch data type to catch. Only one catch will be matched. subclass is written in the top position, superclass in the bottom position.

            ```java
            // main
            try {
               Person person = new Person();
               person = null;
               System.out.println(person.getName())

               int n1 = 10;
               int n2 = 0;
               int res = n1 / n2;
            } catch (NullPointerException e) {
               // catch null pointer
            } catch (ArithmeticException e) {
               // catch arithmeti exception
            } catch (Exception e) {
               // catch all exception
            }
            ```

         2. can only use `try{} finally{}`. if error happen in `try`, the program will be stop.

   2. throws
      1. introduciton: if a method may cause a exception but the method doesn't want to deal or doesn't know how to deal with the exception, it can throw the exception to the method's caller. The caller will deal with the exception.
      2. Could use `throws` to define which exception when define a method. Type of exception could be the actual exception, and also could be super class.
         ```java
         public void f2() throws FileNotFoundException {
            FileInputStream fis = new FileInputStream("aa.txt");
         }
         ```
      3. `throws` could throw more exceptions.

4. tips:

   1. for the run time exception, must be handled by using `try catch` or `throws`.
   2. for the run time exception, if not using `try catch` to handle this exception, by default, it will be handled by `throws`
   3. Subclass `Override` super class's method, for the exception, the exception of the subclass throws either the same as super class or the sonClass of the super class's exception.

      ```java
      class Father {
         public void m1() throws RuntimeException{}
      }

      class Son extends Father{
         // RuntimeException is ok
         @Override
         public void m1() throws RuntimeException {

         }

      }

      // not ok
      class Son extends Father{
         // Exception is not ok since Exception is super class of RuntimeException not subClass.
         @Override
         public void m1() throws Exception {

         }

      }
      ```

   4. when using `try catch` no need to using `throws`.

5. Custom exception
   1. introduction: sometimes we need ot custom our exceptions, so need to create a new class extend `RuntimeException`. Why `RuntimeException`? Since we need to the default handle to deal with exception.
   2. demo
      ```java
      class AgeException extends RuntimeException {
         public AgeException(String message) {
            super(message);
         }
      }
      ```
6. `throw` vs `throws`
   | | mean|position|which follow it|
   | ---- | ---- | ---- | ---- |
   | throw | key word of generating a exception object | method body|exception object|
   | throws | a method of exception handle |method define|exception type|
