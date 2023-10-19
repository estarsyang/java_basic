# chapter12 Exception

1. Introduction: Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program's instructions.
2. types:
   1. error: JVM can't solve these problems, i.e. JVM system error, resource run out, for example, StackOverflowError and OOM(out of memory). Error is a serious problems, program will stop.
   2. exception: coding error or other case will lead some problems but not important, can be fix by special code. for example, null pointer, read don't exist files, network loss and so on.
      1. types:
         1. unchecked(run time) exception: NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException and so on...
         2. checked(complier time) exception: FileNotFoundException and so on.
3. try catch
   1. quick wordf: command+option+t
      p 446
