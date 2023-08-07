# Introduction
This is a basic java notes. inorder to be a entry-level java programmer. [Video link](https://www.bilibili.com/video/BV1fh411y7R8/?spm_id_from=333.999.0.0&vd_source=d71377f649cfc8d319aa45ec353a83f5)

## JDK, JRE, JVM
1. JDK(Java Development Kit, Java develop tool packages) = JRE + develop tools(javac, java compile tools, etc.)
2. JRE(Java Runtime Environment, Java running environment) = JVM + Java SE standard library(core library)
3. JVM(Java Virtual Machine Java) one virtual machine to run Java  bytecode。

## Escape Character
1. \t: table
2. \n: new line
3. \\: a special symbol \
4. \": a special symbol "
5. \': a special symbol ’
6. \r: a entry

## Comment
1. single line comment //
2. multiple line comment /* abcsdf */
3. document comment
```java
  /**
   * @author xx
   * @version 1.0
   * /
```


javadoc -d output path -xx -yy xx.java output a java file的document comment.

## Java code standard.
1. Annotate class, method by using document comment.
2. Encoded in UTF-8
3. Width of one line may not exceed 80 character


# Chapter 3 variable
## Variable
1. Variable: Variables are containers for storing data values，different variables have different size in momery.


## Data types
1. Primitive
    1. Number
        1. Int data type，store int number(byte[1],short[2],int[4],long[8])
        2. Float(decimal)data type(float[4],double[8])
    2. String data type, char[2], store single character, like 'a', 'b', 'c', ...
    3. Boolean data type, boolean[1], store true and false
2. Non-primitive(reference data type)
    1. class
    2. Interface
    3. Arrays, like []
    4. String

3. Int data type
    1. Size in momery
        |type|size|range|
        |----|----|----|
        |byte|1|-128~127|
        |short|2|-32768~32767|
        |int|4|-2147483648~2147483647|
        |long|8||
    2. Detail of int data type
        1. Fix size and range, not affect by os.
        2. Int number default is int, define a long variable need to add `L` or `l` at the end of number.
        ```java
          int n1 = 1;
          int n2 = 1l; // error, long can't store in int
          long n3 = 1l; // define long variable, add l or L at the end.
        ```
        3. Define usually using int, if `int` can't be enough, using `long`.
        4. bit: smallest size in momery，byte：basic store unit in momery, 1 byte is equal to 8 bits。
4. Float number
    1. type
        |type|size in momery|range|
        |----|----|----|
        |float|4|-3.403e38~3.403e38|
        |double|8|-1.798e308~1.798e308|
    2. Detail
        1. Fix size and range, not affect by os.
        2. Default float number is `double`, define a `float` variable need to add `f` or `F` at the end of number.
        3. Two representations
            1. Decimal: 5.12 512.0f .512
            2. scientific notation: 5.12e2 ==>> 5.12 * (10 to the power of 2), 5.12E-2 ==>> 5.12 / (10 to the power of 2)
        4. Usually use `double`, `double` is more precision than `float`.
            ```java
            double num1 = 2.1234567851; // output； 2.1234567851, not loss
            float num2 = 2.1234567851F; // output: 2.1234567, loss some decimal, 851
            float num3 = 1.1; // error, double assign to float;
            double num4 = 1.1f; // ok, float transform to double;
            ```
        5. Trap in using float number
            ```java
            // 2.7 vs 8.1/3
            double num1 = 2.7; // output: 2.7
            double num2 = 8.1/3; // output: almost equal to 2.7;
            if(num1 == num2) { // so it's not equal; never;
              System.out.println("equals")
            }

            // how to compare two computed results which it's double, using minnus. Using an constant value, if result less than it, that will be equal, otherwise, that will be not equal;
            double V = 0.00001
            if(Math.abs(num1 - num2) < V){
              // num1 is equal to num2 even them is not equal;
            }
            ```
5. char
    1. introduce: char can be represent single word, its type is char. chart is two byte(could be store Chinese), multiple char can be used String to present.
        ```java
        char c1 = 'a';
        char c2 = '\t';
        char c3 = '中';
        char c4 = 97; // number couble be assigned to char, cuz a letter could be represented by number. ASCII 97 is present a.
        ```

    2. detail
        1. char using single quote('), for example, char c1 = 'a';
        2. allow using escape character("\\") to reprent special value.
            ```java
            char c1 = '\n';
            char c2 = '1';
            System.out.print(c1); // equal to println, c1 is \n.
            System.out.print(c2);
            ```
        3. the root of char is a number, when it is output, it will using the word base on Unicode.
        4. can be assigned a number to char, when it is output, it will output a word base on Unicode. for example, 97 is the lower letter 'a' base on Unicode.
        5. char could be calculated, cuz it base on Unicode.
        6. special code list.
            1. ASCII, a byte can represent 256 words, but it only uses 128 words.
            2. Unicode, fix size. All letter and Chinese are using 2 bytes.
            3. UTF-8, flex size, code list,a letter using 1 byte, a Chinese using 3 bytes.
            4. gbk, represent Chinese, a letter using 1 byte, Chinese using 2 bytes.
            5. gb2312, same to gbk but the number of Chinese is less than gbk.
            6. big5, represent traditional Chinese

6. boolean
    1. introduce: boolean, value is only true and false. 1 byte. it is usually using logical control, like flows control.
        1. if
        2. while
        3. do-while
        4. for
    2. detail
        1. 0 and 1 can't be present false and true, boolean can be only present true and false.

## 3 primitive data type auto transformer
1. Auto Transformer
    1. introduce: when java is calculated or assigned, low-precision types will be automatically converted to high-precision types.
    2. Sort by ascending base on Precision.
        1. char -> int -> long -> float -> double
        2. byte -> short -> int -> long -> float -> double
            ```java
            int a = 'c'; // ok, char to int
            double b = 80; // ok, int to double
            ```
    3. detail
        1. When multiple data types are computed together, System will auto turn all data types to the data type that highest-precision, and then compute.
            ```java
            int n1 = 10;
            float d1 = n1 + 1.1; // error, 1.1 is double, can not be assign to float. 
            // decimial's default is double, float must need to write f or F. for example, 1.1f;
            ```
        2. Turn high-precision to low-precision, it will be error.
        3. byte and short will be not convert to char.
            ```java
            byte b1 = 10; // the range of byte is -128 ~ 127. so it is correct.
            char c1 = b1; // error
            ```
        4. byte, short, char can be computed together, all of them will be converted to int.
            ```java
            byte b1 = 1;
            byte b2 = 2;
            short s1 = 3;

            short s2 = b1 + s1;// error
            int n1 = b1 + s1; // ok
            
            byte b3 = b1 + b2; // error,
            ```
        5. boolean can not be converted.
            ```java
            boolean t1 = true;
            int n1 = t1; // error
            ```

2. Forced Convert.
    1. introduce: high-precision data convert to low-precision data, need to add forced mark `()`, and it will may lost precision or out of memory.
            ```java
            int i = (int) 1.9; // i is  1;
            
            int n2 = 2000;
            byte b1 = (byte) n2; // max number of byte is 127, so it will be out of memory
            ```
    2. detail:
        1. big data to small data, will be forced convert.
        2. forced symbol '()' is effect the closest operation, so sometimes need a bracket to raise priority.
            ```java
            int x = (int) 10 * 3.5 + 6 * 1.5; // error, final result is double cannot be assign to int.
            int y = (int)(10 * 3.5 + 6 * 1.5); // ok
            ```
        3. char can be stored the value of int, but cannot be stored the variable of int, need to be converted.
            ```java
            char c1 = 100; // ok
            int m = 100;
            char c2 = m; // error, int cannot be assign to char.
            char c3 = (char) m; // ok, output is d that ASCII is 100;
            ```
        4. Whether byte or short is computed, it will be treated as int.
## Convert between primitive data and String.
1. primitive data to String
    1. add `""` Symbol.
        ```java
        int n1 = 1;
        float f1 = 1.1f;

        // convert
        String s1 = n1 + ""; // String 1
        String s2 = f1 + ""; // String 1.1
        ```
2. String to primitive data.
    1. using parseXX funcion in primitive type;
        ```java
        String s1 = "1";
        int n1 = Integer.parseInt(s1); // int 1
        ```
    2. String to char.
        ```java
        String s1 = "123";
        char c1 = s1.chatAt(0); // char 1
        ```

# chapter 4 Operators

## Operators
1. introduction: a special symbol, used to indicate d data compute, assign and compare.
2. type:
    1. arithmetic operators
    2. assignment operators
    3. relational operators
    4. logical operators
    5. bitwise operators
    6. conditional operators
## Arithmetic operators
1. type:
    1. +(plus), - (minus), / (division), % (remainder), * (time), ++(increment operator), -- (decrement operator)
2. Special Case.
    ```java
    10.0 / 4; // 2.5
    10 / 4; // 2

    // remider operator %
    // % is equal to  a % b -->> a - a / b * b, so
    -10 % 3; // -1, -10 - (-10) / 3 * 3
    10 % -3; // 1, 10 - 10/(-3) * -3
    -10 % -3; // -1, -10 - (-10) / (-3) * (-3)
    ```
3. Exercise01
    ```java
    int i = 1;
    i = i++; // (1) temp = i; (2) i = i + 1; (3) i = temp; so, result is the data of temp, it's 1.
    System.out.println(i); // 1

    // another case
    int i = 1;
    i = ++i; // (1) i = i + 1;(2) temp = i;  (3) i = temp; so, result is the data of temp, it's 1.
    System.out.println(i); // 2
    ```
4. Exercise02
    ```java
    // convert Fahrenheit to Celsius. its formular is 5/9*(Fahrenheit-100)
    double fahrenheitDegree = 245.6;
    double temperture = 5/9*(fahrenheitDegree-100);
    System.out.println(temperture); // 0.0, why? cuz 5/9 is 0, so 0 times anythins is 0. how to fix it.

    double fahrenheitDegree = 245.6;
    double temperture = 5.0/9*(fahrenheitDegree-100); // modify formular, int to double.
    System.out.println(temperture); // 80.88888888888

    ```

## Relational operators
1. type:
    1. ==
    2. !=
    3. <
    4. >
    5. <=
    6. >=
    7. instanceof

## Logical operators
1. Introduction: using to connect more Ternary, final result is a boolean value.
2. Type
    1. AND &&, both sides are true, result is true
    2. OR ||, one side is true, result is true.
    3. NOT !, !true is false, !false is true.

## Assignment operators
1. Introduction: assign value to a variable.
2. Special case.
    1. muplite assignment will be transformed.
    ```java
    byte b = 3;
    b += 2; // ok, equal to b = (byte)(b + 2);
    b++; // ok, equal to b = (byte)(b + 1);

    // but if u do this, it will be error.
    byte a = 3;
    a = a + 2; // error, int can't be assign to byte.
    ```

## Ternary operators
1. Introduction: basic expression is `condition expression ? expression1 : expression2;` if condition is true, expression1 will be executed. otherwise, expression2 will be executed.
    ```java
    int a = 4;
    int b = 5;
    int c = a < b ? 10 : 20;
    System.out.println(c); // 10
    ```

2. Max number(three number)
    ```java
    int n1 = 1;
    int n2 = 2;
    int n3 = 3;

    // good, easy to understand
    int max1 = n1 > n2 ? n1 : n2;
    int max2 = max1 > n3 ? max1 : n3;
    System.out.println(max2);

    // bad, difficult to understand
    int max = (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3
    ```

## Operators precedence(Descending)
![Operators precedence](./images/Operators%20precedence.png)



## Identifier
1. Introduction: Identifiers in Java are a sequence of characters to identify something in a program. They are names given to a `class, variable, package, method, or interface` and allow the programmer to refer to the specific item from any place in the program.
1. Rules:
    1. Consist of letters, numbers, `_` or `$`.
    2. Can't start with number, ```int 3ab = 1; // error```
    3. Can't use keyword or reserved word.
    4. Strictly case sensitive, but the length is not limit.
    5. Can't use space. ```int a b = 90; // error```

2. Standard
    1. Package Name: multiple words, lower case.```aaa.bbb.ccc; // com.hsp.crm;```
    2. Class name, interface name: multiple words, all words start with uppper case(UpperCamelCase). ```XxxYyyZzz; // TankShotGame```
    3. Variable, function name: multiple words, first word uses lower case, the other words start with uppper case(lowerCamelCase).```xxxYyyZzz; // tankShotGame```
    4. Constant name: all words need to be upper case.```XXX_YYY_ZZZ; // TAX_RATE```
    5. more detail show team's standard.


## KeyWord
1. Types:
    1. class
    2. int
    3. if  
    4. ...

## Reserved Word
1. Types:
    1. byValue
    2. cast
    3. goto
    4. ...

## Keyboard input
1. Introduction: Programs sometimes need to accept input data by the user, then it need to a ```Scanner```.
2. Scanner:
    1. Steps:
        1. Import the package. ```java.util.*```.
        2. Create the Object(declare variables)
        3. Executed the funtion.

## Hexadecimal
1. Types:
    1. Binary: 0 or 1. Start with ```0b``` or ```0B```.
    2. Decimal: 0 ~ 9.
    3. Octal: 0 ~ 7. Start with ```number 0```.
    4. Hexadecimal: 0 ~ F. Start with ```0X``` or ```0x```.
2. Convert.
    1. ...

## Bit operations.
1. ...

## True Form, 1's Complement Code and 2's Complement Code.


# Chapter 5 Control
1. Type:
    1. Sequence control
    2. Branch control
    3. loop control
    4. break
    5. continue
    6. return
2. Sequence control
    1. Introduction: normal code, no branches control, loop control and so on.
        ```java
        int a = 1;
        int b = 2;
        ...
        ```

3. Branch control
    1. Single Branch
    2. Double branches
    3. Nesting branches. (no more than 3 branches.)
    4. Switch
4. Loop control
    1. for
    2. while
    3. do while
    4. Special case(an empty stars)
        ```java
        /**
         *          *
         *      *       *
         *  *               *
         * *******************
         * // just like above output
         */
        ```
5. Break
    1. Introduction: jump out of a loop.
    2. label, don't use if possible because reading is bad.
6. Continue
    1. Introduction: breaks one iteration (in the loop)
7. Return
    1. Introduction: jump out of a function or a program.

# Chapter6 Array, sort and find.

## Array

1. Introduction: Store multiple same data types data. It also is an reference type.
2. Array initialization.
    1. Dynamic initialization:
        1. method 1: ```dataType arrayName[] = new dataType[size]```
            ```java
            int a[] = new int[5];
            ```
        2. method 2: ```dataType arrayName[]``` or ```dataType[] arrayName```
            ```java
            int a[];
            a = new int[5];

            // or
            int[] b;
            b = new int[5];
            ```
    2. Static initialization.
        1. Grammar: ```dataType arrayName[] = {element1,..., elementN};```
            ```java
            int a[] = {1,2,3,4,5,6};
            ```
3. Notes:
    1. Array store same type data unless auto convert.
    2. it will has a default value without assignment after initialization. ```int 0, short 0, byte 0, long 0, float 0.0, double 0.0, char \u0000, boolean false, String null```
    3. Careful out of boundary.

4. Array reverse
    ```java
    int arr[] = {11,22,33,44,55,66};
    // rules
    // swap arr[0] and arr[5], {66,22,33,44,55,11}
    // swap arr[1] and arr[4], {66,55,33,44,22,11}
    // swap arr[2] and arr[3], {66,55,44,33,22,11}
    // only need three times, length / 2
    // swap index is arr[i] and arr[arr.length - 1 - i];
    int temp = 0;
    int len = arr.length;
    for(int i = 0; i < len / 2; i++) {
        temp = arr[len - 1 - i];
        arr[len - 1 - i] = arr[i];
        arr[i] = temp;
    }
    ```
5. Array resize
    1. Resize factor
    2. loop
    3. arraycopy

6. Bubble Sort

7. Search
    1. SequenceSearch: loop to find and return index. If not, return -1;
    2. BinarySearch(Algorithm)

## multi-dimentional array

1. Two dimentional array.
	```java
	/*
		output below base on two dimentional array
		0 0 0 0 0 0
		0 0 1 0 0 0
		0 2 0 3 0 0
		0 0 0 0 0 0
	*/
	int[][] arr = {{0, 0, 0, 0, 0, 0},{0, 0, 1, 0, 0, 0},{0, 2, 0, 3, 0, 0},{0, 0, 0, 0, 0, 0}};
	
	for(int i = 0;i < arr.length;i++){
		
		for(int j = 0; j < arr[i].length;j++){
			System.out.print(arr[i][j] + "\t");
		}
		System.out.println();
	}
	```
2. Initialization
	1. Dynamic initialization 1. ```dataType[][] ArrayName = new dataType[size][size]```
    ```java
    int a[][] = new int[2][3];

    // or
    int[][] b = new int[2][3];
    ```
    2. Dynamic initialization 2. ```dataType[][] ArrayName; ArrayName = new dataType[size][size]```

    3. Dynamic initialization 3, length of each array is not equal.
    ```java
    /*
    print by using two dimentional array.
    1
    2 2
    3 3 3

    */

    int[][] arr = new int[3][];
    for(int i = 0; i < arr.length;i++) {

        arr[i] = new int[i + 1];
        for(int j = 0; j < arr[i].length;j++){
            arr[i][j] = i + 1;
        }
    }

    for(int i = 0; i < arr.length;i++) {
        for(int j = 0; j < arr[i].length;j++){
            System.out.print(arr[i][j] + "\t");
        }
        System.out.println();
    }
    
    ```

    4. Static initialization,```dataType[][] ArrayName = {{},{},{},...{}}```
    ```java
    int arr[][] = {{1,1,1}, {8,8,9},{100}};
    ```

5. YangHui's triangle or Pascal's triangle
    ```java
    /*
        output 10 level reuslt like this:
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        ...

        rules:
        1. First and last item is 1 in each level.
        2. The number of item in each level is equal to the number of the level.
        3. Except the first and last item, each item is equal to previous item plus the current item in previous level. for example, level 5, 3rd item, 6 = 3 + 3.( level 4, 2nd item + 3rd item).
        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
    */
    int level = 10;
    int arr[][] = new int[level][];

    for (int i = 0;i < arr.length;i++) {
        arr[i] = new int[i + 1];

        for (int j = 0;j < arr[i].length;j++){
            if (j == 0 || j == arr[i].length - 1){
                arr[i][j] = 1;
            } else {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
    }
    ```

# Chapter 7 Object oriented

## Object

1. Why need object?
    1. Easy to represent a multiple data, action. for example, a man, he has age, name, tail, weight. Other data structures are not easy to present. And then, person has actions, like play basketball, eatting. primary data can not present this. array is also.

2. Object
    1. Property
    2. Action

3. Class and object relationship
    1. Class is one data type, like Cat, Dog....
    2. Object is the instance of class
4. Class and object example
    ```java
    /* Tom has two cats, one is bengal, 2 years old, yellow. 
    Other one is ragoll, 3 years old, white. when you input the name of cat, print the property of the cat. 
    if name is not exist, print name is not exist.
    */

    // no class and object.
    String cat1Name = "bengal";
    int cat1Age = 2;
    Color cat1Color = "yellow";

    String cat2Name = "ragoll";
    int cat2Age = 3;
    Color cat2Color = "white";

    String inputName = "bengal";

    if(inputName == cat1Name) {
        System.out.println(cat1Name);
        System.out.println(cat1Age);
        System.out.println(cat1Color);
    } else if(inputName == cat1Name) {
        // ... the same as cat1XX
    } else {
        System.out.println(inputName + "is not exist").
    }

    // it's so long and ugly. And the number of cat is less(if 100 cats need 300 variables). 
    // the most important is not easy to present actions(eat, jump and so on...), but class and object can do all this easily.

    // class and object.
    // 1. define a class, Cat
    class Cat {
        // property
        String name;
        int age;
        String color;
    }

    // 2. Instantiate cats
    Cat cat1 = new Cat();
    cat1.Name = "bengal";
    cat1.age = 2;
    cat1.color = "yellow";


    Cat cat1 = new Cat();
    cat2.Name = "ragoll";
    cat2.age = 3;
    cat2.color = "white";

    if(inputName == cat1.name) {
        System.out.println(cat1.name);
        System.out.println(cat1.age);
        System.out.println(cat1.color);
    } else if (intpuName == cat2.name) {
        // the same as cat1
    } else {
        System.out.println(inputName + "is not exist").
    }

    // above code show more structur, and object easily 
    // adding property and actions. Cat add properties and 
    // actions, all instances has properties and actions. 
    // no need to define more variables.

    ```

5. Field or Property
    1. Grammer: Access modifier + Property type + Property name.
    2. Access modifier:
        1. public
        2. proctected
        3. default
        4. private
    3. Property type: could be any type
    4. Property is not assigned, it has default value. the rules same like array. ``` int 0, short 0,...boolean false```

6. Create Class and access properties.
    ```java

    Cat myCat = new Cat();
    
    Cat myCat1;
    myCat1 = new Cat();

    // access
    myCat.name;
    // ...

    ```

7. Analy of structure of Java memory
    1. Stack: usually store primary data type(local variable)
    2. Heap: store Object(Cat, cat, array and so on)
    3. Method Area: Constant Pool(Class Constant Pool) store constant, like String. the information of Class.

8. Functions of Class
    ```java
    class Person {

        public void speak() {
            System.out.println("Hello");
        }
    }
    ```
    1. public: access modifier
    2. void: no return after execute this method, returen any data type will show the data type. int need return int, void no need to return.
    3. speak: method name.
    4. Method body({}): the detail of method

9. Advantance of functions
    1. DRY(don't not repeat yourself)
    2. Hide detail of implement, other person is easy to use.

10. Notes in using functions
    1. One functions could have 0 and many parameters, using commas to separated.
    2. Parameters could be any data type, including primivates and reference data type.
    3. Calling a method with parameters, the input parameters must be the same as the parameters of functions or compatible data type.
    4. When a function is called, the values passed to the function are known as actual arguments. The parameters specified in the function definition are called formal arguments. Data type, number, order must be same between formal arguments and actual arguments.
    5. Functions can be directly called in the same class.
    6. Functions in different class, it could be called base on className.function or (instance of class).function
    7. Calling different class's functions is limite by access modifier.

11. The root of the values passed in functions.
    1. Primitive data type
        1. Pass value into functions, modify formal arguments could not affect actual arguments.
    2. Reference data type
        1. Pass reference address into functions, When the value of reference data is changed in function, the value of outsite of reference data is also changed. Modify formal arguments could affect actual arguments.

## Recursion

## Introduction
method call itself, each time pass into different variable.

## Example

1. factorial
    ```java
    public int factorial(int n) {
        if(n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
    ```

## Notes

1. Setting base rules

setting base rules prevent StackOverflowError

## Exercises

1. Fibonacci
    ```java
    // use recusion to implement fibonacci.
    // 1 1 2 3 5 8 ...
    /*
    rules:
    1. n = 1, result is 1
    2. n = 2, result is 1
    3. n = 3, result is 2
    4. n = 4, result is 3
    5. ....
    When n >= 3, the result of n is equal to sum of the result of n - 2 and the result of n - 1
    */

    public int fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
            
    }
    ```

2. Number of peach
    ```java
    /* There are lots of peaches, a monkey fisrt day eats half of the peaches, and eats more one.
    In the following days the monkey eat half of 
    peaches and more one. When in the 10th day, there are only one peach. 
    Question: what's the number of peaches?

    Analysis: reverse
        day         peach       
    1. 10th day    1 peach
    2. 9th day     (day10 + 1) * 2 = 4
    3. 8th day     (day9 + 1) * 2 = 10
    4. ...
    The pattern is the number of peaches at nth day  = (the number of peaches at (n+1) day + 1) * 2

    */
    public int peach(int day) {
        if(day == 10) {
            return 1;
        } else {
            return (peach(day + 1) + 1) * 2;
        }
    }

    peach(1); // 1534
    peach(9); // 4
    ```
## Games base on recursion

1. Maze
2. Tower of Hanoi
3. Eight queens

## Overload

1. Introduction: Same function name but formal can't be the same. for example, 
    ```java
    System.out.println(5);// int 
    System.out.println("hello"); // string
    // println could be passed into int, string and so on. there is a example for overload
    ```
2. Advantage
    1. Increasing the readability of program
    2. Provides flexibility
    3. Make code clean
    4. Use code again which save memory.

3. Notes
    1. Function name: msut be same
    2. Formal argument list: must be different.(order or data type or number must be different)
    3. Retrun type: no request

## Variable parameters
1. Introduction: Java allow the same class has multiple functions which the same name, same function but number of arguments are different to encapsulate.

2. Grammer
    ```java
    // access modifier + return data type + function name(dataType... formalName){}
    ```

3. Example
    ```java
    /*
    Calculate sum of two, three, four numbers. And so on....
    */
    // 1. ... represent access variable parameters, int... represent access int variable parameters
    // 2. Formal argument is an array-like which has length arrtribute.
    public int sum(int... nums) {

    }
    ```

4. Notes
    1. Actual arguments could be 0 or many variables.
        ```java
        public int vp(int... nums) {
            int res = 0;
            for(int i = 0;i < nums.length;i++) {
                res +=nums[i];
            }
            return res;
        }

        int sum = vp(1,2,3); // 6
        ```
    2. Actual arguments could be array.
        ```java
        public int vp(int... nums) {
            int res = 0;
            for(int i = 0;i < nums.length;i++) {
                res +=nums[i];
            }
            return res;
        }

        int[] arr = {1,2,3};
        int sum = vp(arr); // 6
        ```
    3. The root of variables parameters is array.
    4. Parameters and variable parameter could be together in a function, but the variable parameters must be the last position.
        ```java
        public int vp(int a, int... b){} // ok
        public int vp1(int... a, int b){} // error, variable parameters must be the last position if multiple formal arguments.
        ```
    5. One formal arguments list could only have one variable parameters. ```public int vp(int... a, int... b){} // error, only have one variable parameters```

## Scope

1. Introduction: Define where a certain varibale or method is accessible in a program.

2. Type:
    1. Gobal variable(it is usually properties in class)   
    properties, define in class. can directly assign a value or not. it has default value.
    ```java
    class Person {
        // age is gobal variable, could be using in class Person anywhere.
        int age = 10;
        int gobalNum;

        // n and name are local variable
        public void cry() {
            int n = 10;
            int name = "jack";
            System.out.println("age"); // ok
        }

        public void hi() {
            System.out.println(gobalNum); // ok, default value, 0
        }

    }
    ```
    
    2. Local variable   
    usually define in functions, outside can't be used. must be assigned before using.
    ```java
    class Person {
        int age = 10;

        // n and name are local variable, only can use in cry function. using in outside will be error.
        public void cry() {
            int n = 10;
            int name = "jack";
            System.out.println("age"); // ok
        }

        public void cry() {
            System.out.println(name); // error, can't find name.
        }

        public void hi() {
            int localNum;
            System.out.println(localNum); // error, not assign a inital value.
        }

    }
    ```

3. Notes
    1. Gobal and local variable could be the same name. Using the variable in which scope that the variable will be the value of the scope.
    2. Same scope can't be the same name. for example, Gobal scope, can't be the same name varibale.
    3. Gobal variable lifecycle is actived in the object until the object not use and GC recycle it. Local variable lifecycle is actived in function until function end of execution. GC recycle it.
    4. Gobal varibales/properties, could be used in its class and other class(xClass.xProperty or (instance of xClass).xProperty). Local variables can only use in its class's functions.
    5. Modifier: Gobal variables/properties can use modifier but local variables not.

## Constructor

1. Introduction: A special method is used to initialize objects. it can be used to set initial values for object properties.

2. Grammer: [modifier] functionName(formal arguments list){function body}
    1. Modifier can be default, public, protected, private.
    2. Constructor no return value.
    3. Function name and class name must be same.
    4. Arguments list and functions are the same rules.
    5. The calling of constructor by system. When Creating an object, system will be auto calling the constructor of the class to initialize object.

3. Example
    ```java
    class Person{
        String name;
        int age;

        public Person(String pName, int pAge) {
            name = pName;
            age = pAge;
        }
    }

    // main 

    Person p1 = new Person("tom", 12);
    // p1.name --> tom
    // p1.age --> 12
    ```

4. Notes
    1. One class could have many constructors, just like function overload.
        ```java
        class Person{
            String name;
            int age;

            public Person(String pName, int pAge) {
                name = pName;
                age = pAge;
            }
            // ok, overload
            public Person(String pName) {
                name = pName;
            }
        }
        ```
    2. Constructor name must be the same as class name.
    3. Constructor no return value.
    4. COnstructor initialize object not create object.
    5. Auto calling constructor when create object.
    6. If programmer doesn't write an constructor, system will be auto generate a default no arguments constructor. Using `javap` command to convert `class` file to `java` file to show the default constructor.
        ```java
        class Person{

            // will be auto generated an default constructor.
        }
        ```
    7. Once writing constructor of one class, there will be not default constructor unless define one empty constructor.
        ```java
        class Person{
            String name;
            // will be auto generated an default constructor.
            public Person(String pName) {
                name = pName;
            }
            // self define a default empty constructor
            public Person() {

            }
        }
        ```

5. Flow of creating an object.([demo link](https://www.bilibili.com/video/BV1fh411y7R8/?p=245&spm_id_from=pageDriver&vd_source=d71377f649cfc8d319aa45ec353a83f5))
    ```java
    /*
    Describe the flow of below code. Including heap, stack, method area and others.
    */
    class Person {
        int age = 90;
        String name;

        public Person(String n, int a) {
            name = n;
            age = a;
        }
    }

    // main
    Person p =  new Person("tom", 20);
    ```
    1. Method area import class information, including properties and functions, only once.
    2. Arrange an address in stack of this object.
    3. Finish initializing object.
        1. default initial: age = 0; name = null;
        2. Assign value: age = 90; name = null;
        3. Constructor initial: age = 20; name = "tom";
    4. Define a variable named `p` in heap, and assign the address which arrange in stack to `p`.

## This

1. Introduction: `this` keyword refers to **the current object** in a function or constructor. The most common use of the `this` keyword is **to eliminate the confusion between class attributes and parameters with the same name**. `this` can also be used to:
    1. Invoke current class constructor.
    2. Invoke current class function.
    3. Return the current class object.
    4. Pass an argument in the function call.
    5. Pass an argument in the constructor call.
    ```java
    // this example

    class Person {
        int age;
        String name;
        // strange, if formal argument name is the same as properties name is good.
        public Person(String pName, int pAge) { 
            name = pName;
            age = pAge;
        }

        // directly using the same name it can't work. Since name,age in this block are the formal argument not properties. Properties still have default value.
        public Person(String name, int age) { 
            name = name;
            age = age;
        }

        // using this can solve this.
        public Person(String name, int age) { 
            this.name = name;
            this.age = age;
        }
    }
    ```

2. Tips: If you want to compare two object is the same or not, use `hashCode` is one easy method to compare. Since each object has different hash code and object has the method name `hashCode` to return the hash code of the object.

3. Notes:
    1. `this` represnt object which calls functions.
        ```java
        Person p1 = new Person('tom');
        Person p2 = new Person('bob');
        Person p3 = new Person('kobe');

        
        public void cry() {
            System.out.println(this.name + " is crying");
        }

        p1.cry(); // tom is crying
        p2.cry(); // bob is crying
        p3.cry(); // kobe is crying

        // which one call function and this present which one.

        ```
    2. `this` can access the properties, functions, constructors.
    3. `this` can distinguish properties and local variables.
    4. Access functions grammer: this.functionName(arguments).
    5. Access constructor grammer: this(arguments); only using in constructor(call another constructor in an constructor). The position of `this(arguments)` must be in the top of function body.
        ```java
        class Person {

            String name;

            public Person() {
                this("tom"); 
                // call Person(String name){} function.
                // Call another constructor(base on the formal argument list) in one constructor.
            }

            public Person(String name) {
                this.name = name;
            }
        }

        ```
    6. `this` can't be used in outside of class, only using in functions in class.

4. Games base on object.
    1. Mora     
       mora between tom and computer, 0 - rock, 1 - paper, 2 - scissors. 3 times, output the number of win.

# Chapter 8 Object oriented(medium)

## IntelliJ ide
1. shortcut(macos)
    1. Delete line: `command + detele`
    2. Duplicate line: `command + d`
    3. Code completion: `control + space`
    4. Comments: `command+ + /`
    5. import utils in current line: `option + enter`
    6. Format code: `option + command + l`
    7. Quick run code: `command + r`
    8. Generate constructor: `option + enter or command + n`
    9. Show the hierarchy of class: `control + h`
    10. Quick find function in current position: `command + b`
    11. Auto assign variables name: the end of line add `.var`
    12. Clost other code tab: `command + w`
    13. Switch code tab: `control + left or control + right`
## Package
1. Introduction: used to group related class, avoid name conflictes and write a better maintainable code.
2. Grammer: `package` packageName, `package com.test`
    1. `package` is keyword.
    2. `com.test` is package name.
3. Root of package: create different folders or content to save class file.
4. Example  
    create two package to save the same name class `Dog`
5. Package name rules:  
    Only including number, letter, _, ., but can't start with number, no keyword and reserve word
    ```java
    // demo.class.exec1 // error, keyword
    // demo.12a // error, start with number
    // demo.ab12.oa // ok
    
    ```
6. Package name recommend:  
    small letter + `.`, usually `com.companyName.projectName.bussinessModulName`
    ```java
    // com.apple.crm.user
    // com.google.search.user
    ```
7. Java package(most common)
    1. java.lang.* (basic package, default import, no need import)
    2. java.util.* (util package)
    3. java.net.* (network package)
    4. java.awt.* (view package, GUI)
8. Import package: import as few package as possible
    1. `import java.util.Scannner;`
    2. `import java.util.*;`
9. Notes:
    1. The function of package is declare current class is belong to which package. 
    So only one package declare in an class file. And the declare must be top of files(except comments)
    2. `import` commands could be more and no order, but must under `package` declare.

## Access modifier

1. Introduction: java provide four asscess modifiers to control access of `functions` and `properties`.
2. Types:
    1. `public`: open to all.
    2. `protected`: open to subclass and the class in the same package.
    3. `default`: not access modifier is default, open to the class in the same package.
    4. `private`: only itself class could use it, don't open to anywhere.
3. rules    
    |type|same class|same package|subclass|different package|
    |----|----|----|----|----|
    |public|ok|ok|ok|ok|
    |protected|ok|ok|ok|x|
    |default|ok|ok|x|x|
    |private|ok|x|x|x|
4. Notes:
    1. Modifier could be modified properties, functions and class.
    2. Only `default` and `public` could be modified class! And obey the rules.

## Feature of object oriented - Encapsulation, Inheritance, Polymorphism

## Encapsulation
1. Introduction: is a mechanism of wrapping the data(variables) and code acting on the data(methods) together as single unit. In encpasulation, the varables of a class will be hidden from other class, and can be accessed only through the methods of their current class.
2. Case
    1. TV remote: TV is an encapsulation, throw out methods(TV remote) to access data and methods(TV remote can open/close TV, and access storage of TV).
3. Advantage
    1. Hide implementation detail.
    2. Verify data to ensure safe.
4. Step
    1. `private` properties can't not directly modify properties.
    2. Provide a **public** set method to verify and assign data.
        ```java
        public void setXxx(dataType argument) {
            // verify data logic
            property1 = argument
            // ...
        }
        ```
    3. Provide a **public** get method to get value of data.
        ```java
        public XX getXxx() {
            // access control logic
            return xx;
        }
        ```
5. Example
    1. Person detail    
    A person has name, age and salary, All properties will be reasonable, otherwise give default value. （implementation: chapter8 object oriented(medium)/packageControl/src/com/edu/encap/Encapsulation01.java)
        1. age: 1 - 120; default: 18;
        2. name: 2 - 6; default: anonymous.
        3. salary: can't directly access.
    2. Account implementation: chapter8 object oriented(medium)/packageControl/src/com/edu/encap/Account.java and AccountTest.java)
    two class, `Account`, `AccountTest`.
        1. `Account`: name(2-4), balance(>20), password(6 numbers). if not, show warning and assign default.
        2. Assign value base on setXxxx.
        3. Test in `AccountTest`.
6. Constructor with Encapsulation
    1. Introduction: Sometimes constructor will be directly initialized properties and don't verify data. To avoid this case, constructor directly call setXxx methods to initialize properties.
        ```java
        class Person{

            public Person(String name, int age, double salary) {
                this.setName(name);
                this.setAge(age);
                this.setSalary(salary);
            }
        }
        ```

## Inheritance
1. Introduction: is a mechanism in which one object acquires all the properties and behaviors of a parent object.
2. Why need it? For example, two calss, one is `Pupils`, other one is `Graduate`. There are many same properties and methods, if we all define them, they will cost many time and many memory. the important is, one thing is changed, you need to modify more. Base on above all, the advantages of inheritance are code reusability(save time and memory), easily maintain.
3. Grammer: `class subClassXXX extends paranetClassXXX {}`, subClass will be auto to inherit properties and methods of parentClass.
4. Notes
    1. SubClass inherit all properties and methods from parentClass. But `private` properties and methods can't access directly, need to call public methods to access.
    2. SubClass must call the constructor of parentClass to initialize parentClass.
    3. When create an object of subclass, the constructor which no argument constructor of parentClass will be automatically called. if parentClass has no none argument constructor and has arguments constructor, there will be necessary to call `super` methods in the subclass's constructor. if not, compile will be error. `super` represent that constructor of parentClass.
    4. If you want to call the constructor of parentClass, you need to call it by using `super(arguments)`.
    5. `super()` must be in the first line in the subclass constructor.
    6. `super()` and `this()` all must be in the first line in the constructor, so they can't exist together in one constructor.
    7. All class in java is subclass of `Object` class.
    8. Calling constructor of parentClass not only parent but grandparent and until `Object`. Calling order from top to bottom is `Object`, parentClas, subclass.
    9. Subclass can only inherit one class means that only one parentClass, java is single inheritance.
    10. Inheritance can't be abused, relationship between subclass and parentClass need to obey `is-a` relationship. For example, **Steve Jobs** is a person, Jobs can inherit `Person`, but he can't inherit `Plane`.
5. The theory of inheritance.
    ```java
    class GrandPa {
        String name = "grandPa";
        String hobby = "travel";
    }

    class Father extends GrandPa{
        String name = "father";
        int age = 39;
    }

    class Son extends Father {
        String name = "son";
    }
    ```
    Theory shows in below picture.
    ![inheritance](/images/jave%20memory-inheritance.png)
6. Exercise
    1. `B` extends `A`, what's the output?
        ```java
        class A {
            A() {
                System.out.print("A");
            }
            A(String name) {
                System.out.print("A name");
            }
        }

        class B extends A {
            B() {
                this("tom"); // call this() and will not call super() again.
                System.out.print("B");
            }
            B(String name) {
                // in this place will called super()
                System.out.print("B name");
            }
        }

        // main
        B b1 = new B();

        // output is
        // A B name B. Important, this() and super() can't exist same constructor. 
        ```
    2. `C` extends `B`, `B` extends `A`, what's the output?
        ```java
        class A {
            public A() {
                System.out.println("A");
            }
        }

        class B extends A {
            public B() {
                System.out.println("B");
            }
            
            public B(String name) {
                System.out.println(name + " B name");
            }
        }

        class C extends B {
            public C() {
                this("hello");
                System.out.println("B");
            }
            
            public C(String name) {
                super("hi");
                System.out.println(name + " C name");
            }
        }
        
        // main
        C c = new C();

        // output
        /*
            A
            hi B name
            hello C name
            B
        */ 
        ```

## super

1. Introduction: represent the reference of parentClass. use to access the properties, methods, constructor.
2. Grammer: 
    1. Access properties: `super.propterty`, but can't access `private` properites.
    2. Access methods: `super.method(arugemts)`, but can't access `private` methods.
    3. Access constructors: `super()` or `super(arguments)`, must be in the first line in subclass constructor. only call once.
3. Advantages:
    1. Call constructors of parentClass: initialize parents's properties by parents, initialize subclass's properties by subclass.
    2. Same properties and methods in subclass and parentClass, to access the properites and methods in parent class must use `super`. if not the same name, using `this` or `super` is ok.
    3. `super` not limit in parent class, if grandpa class or higer class have same name properties and methods and parent class doesn't have them, it will be access grandpa class or super-classes.
4. `this` and `super` compare
    |No.|type|this|super|
    |----|----|----|----|
    |1|access properties|current class if not exist and search parentClass until `Object`.|parent or super-classes|
    |2|methods call|current class,  if not exist and search parentClass until `Object`.| parent or super-classes|
    |3|constructor call|constructor in current class,must be in the first line in constructor|parent's constructor, must be in the first line in subclass's constructor|
    |4|others|represent current object|subclass access parent's object|

## Override

1. Introduction: allows a subclass or child class to provide a `specific implementation` of a method that is `already provided` by one of its super-classes or parent classes. Same name, same arguments.
    ```java
    // parent class
    public void bark(){};

    // subclass 
    @Override
    public void bark(){}; // override

    public void bark(String name){}; // not override, since arguemnts are different. overload

    
    
    ```
2. Notes
    1. Name, arguments of subclass's methods must be the same as parent class's.
    2. Same return data type or subclass of parent class return data type, for example, parent class return `Object`, and subclass return `String`, it's ok. Since `String` is the subclass of `Object`. But parent class return `String`, subclass return `Object`, it's error.
    3. Subclass can't narrow the scope of access, expand is ok.
        ```java
        // parent class
        public void bark(){};

        // subclass
        void bark(){}; // error, decrease access. public > default.
        ```
3. Override and overload
    ||scope|method name|arguments list|return|access modifier|
    |----|----|----|----|----|----|
    |overload|same class|must be same|must be different|no limit|no limit|
    |override|subclass and parent class|must be same|must be same|must be same or subclass(return data type of subclass must be subclass of return data type of parent class)|can't narrow the scope of parent class|

## Polymorphism

1. Introduction: is the ability of an object to take on `many forms`. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object. Any Java object that can pass more than one IS-A test is considered to be polymorphic
2. Why need polymorphim? for example, you(`master`) have many `animal`, many `food`. and you need to `feed`a special animal with a special food. like `cat` love `fish`, `dog` love `bone` and so on. what do you implememt this code? Base on above knowledges, you may write below code like this.
    ```java
    
    // Animal class
    class Animal { /**/}
    // Cat
    class Cat extends Animal {/**/}
    // Dog
    class Dog extends Animal {/**/}

    // Food class
    class Food { /**/}
    // Fish
    class Fish extends Food {/**/}
    // Bone
    class Bone extends Food {/**/}

    // Master
    class Master {
        // ...

        // bone to dog
        public void feed(Dog dog, Bone bone) {
            System.out.println(bone + "is fed to " + dog);
        }

        // fish to cat
        public void feed(Cat cat, Fish fish) {
            System.out.println(fish + "is fed to " + cat);
        }
        // ....
    }
    ```
But, there are many animals and many foods, you can't write a special `feed` to feed each animal with each food. there is awful. Boss will kill you. So we need `polymorphism`.
3. Example in polymorphism
    1. Overload and override
        ```java
        public void say(String name) {}
        public void say(String name, int age) {}

        // Person behavior
        Person p1 = new Person();
        p1.say("bob");
        p1.say("tom", 12);

        // say has many form.
        ```
4. Polymorphism in Object
    1. Compile-time type and run-time type could be different.
    2. Compile-time type is determinded when declare an object, it can't be changed.
    3. Run-time type can be changed.
    4. When a variable is declared, left of `=` is its compile-time type(never change), right of `=` is its run-time type(can change when running).
        ```java
        Animal animal = new Dog(); // animal's compile-time type is Animal, but run-time type is Dog.
        animal = new Cat(); // animal's compile-time type is Animal, but run-time is already Cat.
        ```
        1. Exampole
            ```java

            // Animal
            class Animal {
                // ...
                public cry() {
                    System.out.println("Animal cry");
                }
            }

            // Dog
            class Dog extends Animal {
                // ...
                public cry() {
                    System.out.println("Dog cry");
                }
            }

            // Cat
            class Cat extends Animal {
                // ...
                public cry() {
                    System.out.println("Cat cry");
                }
            }

            // main
            Animal animal = new Dog();
            animal.cry(); // Dog cry, run-time type change is Dog, so cry of Dog is called

            animal = new Cat();
            animal.cry(); // Cat cry, run-time type is changed to Cat, so cry of Cat is called
            ```
5. Fixed problem in **Master to feed animal**
    ```java
    // Master
    class Master {
        // ...

        // bone to dog
        public void feed(Dog dog, Bone bone) {
            System.out.println(bone + "is fed to " + dog);
        }

        // fish to cat
        public void feed(Cat cat, Fish fish) {
            System.out.println(fish + "is fed to " + cat);
        }
        // ....

        // ===================
        // use polymorphism

        public vod feed(Animal animal, Food food) {
            System.out.println(food + "is fed to " + animal);
        }
        // Animal is parent class of Dog, Cat and so on, Food also. So only need declare once, could apply many cases.

        // main
        Master master = new Master();
        Food fish = new Fish();
        Animal cat = new Cat();

        master.feed(cat, fish); // fish is fed to cat.
        
    }
    ```
6. Notes
    1. Polymorphism is base on inheritance. Two object exist inheritance relationship.
    2. Upcasting in polymorphism
        1. Introduction: is the typecasting from a subclass to a superclass(child to parent class). In this way, we can access the properties (methods and variables) of the superclass.
        1. root: a child object to a parent object. A subclass's reference address is assigned to a parent class variable.
        2. Grammer: ParentClass variableName = new subclass();
        3. Characteristics:
            1. When a variable is declared, left of `=` is its compile-time type(never change), right of `=` is its run-time type(can change when running).
            2. Could call all properties and methods in parent class(obey access rules).
            3. Can't call subclass special properties and methods.
                ```java
                // Animal
                class Animal{
                    // ...
                }

                // Cat
                class Cat extends Animal{
                    // ...

                    public void catCatchMouse(){}
                }

                // main
                Animal animal = new Cat();
                animal.catCatchMouse(); // error, compile error. Since compiler think `catCatchMouse` method doesn't exist in Animal class, so will be error, although run-time type is Cat that exist `catCatchMouse` method.
                ```
            4. Final run-time type base on implementation of subclass.
    3. Downcasting in polymorphism
        1. Introduction: is typecasting from a superclass to a subclass(parent to child class) so that we can access the methods of the subclass.
        2. Grammer: childClass variableName = (childClass) parentClass's reference.
        3. Only casting reference, can't not cast object of parent class.
        4. Parent class reference casting to subclass type.
            ```java
            Animal animal = new Cat(); // animal run-time type is a Cat
            Cat cat = (Cat) animal; // downcasting to Cat, is ok. So it can cast Animal to Cat.
            Dog dog = (Dog) animial; // error, it can't. Cat and Dog no relationship.
            ```
        4. After downcasting, can call all properties and methods of child class.
            ```java
            // Animal
            class Animal{
                // ...
            }

            // Cat
            class Cat extends Animal{
                // ...

                public void catCatchMouse(){}
            }

            // main
            Animal animal = new Cat();
            Cat cat = (Cat) animal; // downcasting
            cat.catCatchMouse(); // ok, 
            ```
    4. Properites's value is base on **compile-time type**
        ```java
        // Father
        class Father{
            int count = 10;
        }


        // Son
        class Son extends Father {
            int count = 20;
        }

        // main
        Father p1 = new Son(); // the compile-time type of p1 is Father, so its properties is Father's properties.
        System.out.println(p1.count); // 10;
        ```
    5. `instanceOf`
        1. Introduction: The java instanceof operator is used to test whether the object is an instance of the specified type (class or subclass or interface), test **run-time** type.
        2. Test:
            ```java
            
            class Father{}

            class Son extends Fahter{}

            // main
            Son p1 = new Son();
            System.out.println(p1 instanceof Son); // true
            
            Father p2 = new Son();
            System.out.println(p2 instanceof Father); // true
            
            Father p3 = new Son();
            System.out.println(p3 instanceof Son); // true

            ```
7. Exercises
    1. Output
        ```java
        // main
        double d = 13.4; // ok
        long l = (long) d; // ok
        System.out.println(l); // 13
        int in = 5; // ok
        boolean b = (boolean) in; // error, int to boolean
        Object obj = "hello"; // ok, upcasting
        String objStr = (String) obj; // ok, downcasting
        System.out.println(objStr); // hello
        Object objPri = new Integer(5); // ok, upcasting
        String str = (String) objPri; // error, int to string
        Integer str1 = (Integer) objPri; // ok, downcast
        ```
    2. Output
        ```java
        class Base {
            int count = 10;
            public void display(){
                System.out.println(this.count);
            }
        }

        class Sub extends Base {
            int count = 20;
            public void display(){
                System.out.println(this.count);
            }
        }

        // main
        Sub s = new Sub();
        System.out.println(s.count); // 20
        s.display(); // 20
        
        Base b = s; // upcast
        System.out.println(b == s); // true
        System.out.println(b.count); // 10
        b.display(); // 20

        ```
7. **Dynamic Binding(Important)**
    1. Introduction: Dynamic binding or runtime polymorphism allows the JVM to decide the method's functionality at **runtime**
    2. rules
        1. Call methods, binding runtime object.
        2. Call properties, no binding, the value of properties base on in which class.
            ```java
            // father
            class Father {
                int i = 10;

                public int getI() {
                    return i;
                }
                public int sum() {
                    return getI() + 10;
                }
                public int sum1() {
                    return i + 10;
                }
            }

            class Son extends Father {
                int i = 20;

                public int getI() {
                    return i;
                }
                public int sum() {
                    return getI() + 20;
                }
                public int sum1() {
                    return i + 10;
                }
            }

            // main
            // all is in Son not limit Father
            Father p1 = new Son();
            System.out.println(p1.sum()); // 20 + 20 = 40
            System.out.println(p1.sum1()); // 20 + 10 = 30
            ```
            but if modified Son, Annotate `sum` and `sum1`
            ```java
            // father
            class Father {
                int i = 10;

                public int getI() {
                    return i;
                }
                public int sum() {
                    return getI() + 10;
                }
                public int sum1() {
                    return i + 10;
                }
            }

            class Son extends Father {
                int i = 20;

                public int getI() {
                    return i;
                }
                /*
                public int sum() {
                    return getI() + 20;
                }
                public int sum1() {
                    return i + 10;
                }
                */
            }

            // main
            // not Son but also Father
            Father p1 = new Son();
            System.out.println(p1.sum()); // 20 + 10 = 30
            // p1.sum method is extended by Father, so focus on Father. sum method return getI() + 10; Since p1's run-time is Son and getI method exist in class Son, so getI is call in Son and return 20(the value of i in Son is 20), and final result is 20 + 10 = 30.

            System.out.println(p1.sum1()); // 10 + 10 = 20
            // p1.sum1 method is extended by Father, so focus on Father, sum1 method return i + 10; Since the scope is in class Father now, so i is 10, and return 10 + 10 = 20.
            ```
8. Applied in Polymorphism
    1. Polymorphism Array
        1. Introduction: the data type is parent class, and item is subclass.
        2. Example: 
            1. create one `Person` object, two `Student` objects and two `Teacher` objects, store in an array and call `say` method in each object. properties have `name` and `age`. `Student` has `score`, `Teacher` has `salary`. (store in `ployarr_` package which in `/chapter8 object oriented(medium)/packageControl/src/com/edu/poly_/polyarr_`)
            2. `Teacher` has `teach` method, `Student` has `study` method. also need to call.
                ```java
                // Person
                class Person {
                    private String name;
                    private int age;
                    // ...
                }

                // Student
                class Student extends Person {
                    private double score;

                    // constructor
                    public Student(String name, int age, double score) {
                        super(name, age);
                        this.score = score;
                    }

                    @Override
                    public String say() {
                        return super.say() + "score = " + score;
                    }

                    // study
                    public void study(){}
                    // ...
                }

                // Teacher
                public class Teacher extends Person {
                    private double salary;

                    public Teacher(String name, int age, double salary) {
                        super(name, age);
                        this.salary = salary;
                    }

                    @Override
                    public String say() {
                        return super.say() + "salary = " + salary;
                    }

                    // teach
                    public void teach(){}
                }

                // main
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
                
                ```
    2. Parametric polymorphism
        1. Introduction: a programming language technique that enables the **generic definition of functions and types**, without a great deal of concern for type-based errors. Formal arguments could be parent class, but actual arguments allow to be child class.
        2. Example:
            1. Definite `Employee`, including `name` and `salary`(private), also including `getAnnual` method. Worker and manager inherit `Employee`, manager has `bonus` property and `manage` method. Staff has `work` method. Worker and manager need to override `getAnnual` method.
            2. Test class add one methods named `showEmpAnnual(Employee e)` to get one employee's annual salary, and call this method in main function.
            3. Test class add one methods name `testWork`, if pass one worker, call `work` method. if pass one manager, call `manage` method.
        3. Implement code
            ```java
            // chapter8 object oriented(medium)/packageControl/src/com/edu/poly_/polyparameter_
            ```
## Object introduction

1. Methods
    1. equals
        1. `==` vs `equals`:
            - `==` is a java operator(can't be override), generally to compare primitive data type but can also be used to compare objects.
            - `==` compare the data for primitive data types and address for objects.
            - `equals` compare objects but can't compare primitive.
            - compare String object, `equals` compares them character by character as well if the memory location equality fails. `==` compare address
            - `==` compares two variables are not the same data type will throw a compile error but `equals` return `false`.
            - **case**
                ```java
                128 == 128; // false
                127 == 127; // true.
                // why?
                // Autoboxing caches -128 to 127, because the Integer type interns the values (by the static class IntegerCache) from -128 to 127. When u call `valueOf`, the Integer class checks whether value is in the cache or not.
                ```
            - Conclusion    
                A simple rule to remember when dealing with objects is use `equals` if you want to check if the two objects are "equal", use == when you want to see if they point to the same instance.
    2. finalize
    3. getClass
    4. hashCode
    5. toString
    6. ...

## Debugger
    1. Short cut
        1. F7: Step Into, into a method
        2. F8: Step Over, step over a method, not into method.
        3. Shift + F8: Step Out, step out a method.
        4. option + command + r:Resume, step to next break point.
        5. option + shift + F7: Force Step into, force into a method, Debugger usually don't step into a java library's method. if you want debugger the method, using force step into.

## Exercise Project
    1. SmallChangeSys.java: record money. money input, money ouput, detail, exit system.
        1. Procedure oriented (chapter8 object oriented(medium)/packageControl/src/com/edu/smallchange/SmallChangeSys.java)
        2. Obejct oriented (chapter8 object oriented(medium)/packageControl/src/com/edu/smallchange/oop)

# Chapter9 Project- house renting sysytem.

## Project Introduction:
1. Main menu
    1. add house
    2. find house
    3. remove house
    4. modify house msg
    5. house list
    6. exit
2. Add house
    1. house owner: String
    2. phone: String
    3. address: String
    4. rent: Number
    5. status: rent out or not rent, String
3. Find house
    1. Introduction: input the house id,if id exist, show the detail. otherwise, show no exist msg.
4. Remove house
    1. Introduction: input the house id, if id exist, show the remove confirm, "Y/N", Y, remove, N, do remove, 
    go back main menu. if id not exist, show msg id doesn't exist, please input again. if input id is -1, directly exit, go back main menu.
5. Modify house:
    1. Introduction: input the house id, if id not exist, show msg id doesn't exist, if input id is -1, directly exit, go back main menu. if id exist, show the detial of id. And then can directly input new value of each item.
    for example:
        ```java
        // the detial of house after input id in modify operation;
        // name(bob): tom
        // telephone(123): 116
        // ...
        ```
    if customer doesn't want to modify this item, directly Enter
6. House list
    1. Introduction: show house list. columns including id, name, telephone, address, rent, status(rent out/ unleased)
7. Exit
    1. Introduction: When customer input exit command, confirm,(Y/N). if input is Y, exit. if input is N, go back main menu. Other input show input error, please input again.
8. Tips
    1. Using array as a database, not consider array resize, fix array length, set a default length.
    2. Do basic data verify.

## Project design

1. Architecture
    1. Layered Architecture(Multi-tier Architecture)
2. Architecture Frame
    1. Contents
        1. System has which classes(file)
        2. Declare calling relationship between classes.
    2. detial
    ![Frame](/images/chapter9%20house%20renting%20frame.png)
        - HouseRentApp: to create house object, call house object, show main menu
        - HouseView: show main menu view, receive user input commands, call api from HouserService to operate House object
        - HouseService: do business, including crud.
        - House: model layer, a house object data structure. Modified by HouseService.  
    3. each layer create one package. Although there are one files, there will be more files in the future.
3. Import team `Utility` class.
4. Project function implementation steps
    1. which function.
    2. Analyse
    3. Coding
5. Model layer implementation - `House` class in House.java.
    1. Properties
        1. id
        2. name
        3. phone
        4. address
        5. rent
        6. state
    2. Constructure, get and set
    3. toString override.
6. Show main menu and exit function.
    1. Show main menu - `view layer`, `mainMenu` method in `HouseView.java`.
    2. exit - also in `mainMenu` method.
7. House list
    1. list - `view layer`, show all houses, `listHouse` method in `HouseView.java`.
    2. return all houses information - `service layer`, `list` method in `HouseService.java`.
    3. store houses information - `service layer`, base on array, defint `House[]` to store house object, in `HouseService.java`
8. Add house
    1. add house view - `view layer`, `addHouse` method, in `HouseView.java`.
    2. add house operation - `service layer`, `add` method, in `HouseService.java`
9. Delete house
    1. delete house view - `view layer`, `delHouse` method in `HouseView.java`.
    2. delete house operation- `service layer`, `detele` method, in `HouseService.java`
10. Exit
    1. exit - `view layer`, `exit` method in `HouseView.java`.
11. Find house:
    1. findHouse: `view layer`, `findHouse` method in `HouseView.java`.
    2. findById: `service layer`, `findById` method in `HouseService.java`
12. Update house:
    1. updateHouse: `view layer`, `updateHouse` method in `HouseView.java`.
13. `HouseRentApp` is the main input of the app.

# Chapter10 Obejct oriented(High)

## Class variable / static variable

1. Question: Many children play the game, and other children keep joining the game, how many children play the game?
    Basic previous study, we can define a varable name `count` to count the children number. like below coding...

        ```java
        class Children {
            private String name;
            // ...
            public void join(){
                // join the game..
            }
        }

        // main
        int count = 0;

        Children child1 =  new Children();
        child1.join();
        count++;
        
        Children child2 =  new Children();
        child2.join();
        count++;

        // ...
        ```
    Above code seems that solve the question, but it is not good. Since
    1. Varable `count` is independent of any object.
    2. Access `count` is troublesome, not use oop

    Base on these problems, we need to use **class variable** or **static varibale**. The feature of the variable is shared by all instances of class.

    ```java
        class Children {
            private String name;
            // add class variable / static variable
            public static int count = 0;

            public void join(){
                // join the game..
            }

            // main 
            Children child1 =  new Children();
            child1.join();
            child1.count++;
            
            Children child2 =  new Children();
            child2.join();
            child2.count++;

            // ...
        }
    ```
2. Introduciton: The static variable can be used to refer to the common property of all objects (which is not unique for each object). Anyone object of class to access the variable will return the same value, and anyone object to modify the variable will modify the same variable.
3. Grammar: 
    ```java
    // access modify + static + data type + variable name (recommend)
    public static int count;

    // or
    // static + access modify + data type + variable name
    static public int count;
    ```
4. Access static variable
    ```java
    // className.variable (recommend)
    Child.count;
    // ObjectName.variable
    child1.count
    ```
    1. example
        ```java
        // main
        System.out.println(A.name);

        // obejct.variable
        A a = new A();
        System.out.println(a.name);

        // class A
        class A{
            public static String name = "tom";
        }
        ```
5. Detail
    1. When to use: A variable need to common use.
    2. Different with non-static variable: static variable could be shared by all object of same class but non-static variable only could be use by its object.
    3. Static variable is initial when import class. Although don't new a object, you can use static variable.
    4. Lifecycle of static class start with class import, end with class recycle.
## Class method / static method.

1. Introduction
    1. A static method in Java is a method that is part of a class rather than an instance of that class.
    2. Every instance of a class has access to the method.
    3. Static methods have access to class variables (static variables) without using the class’s object (instance).
    4. Only static data may be accessed by a static method. It is unable to access data that is not static (instance variables).
    5. In both static and non-static methods, static methods can be accessed directly.
2. Program
    ```java
    // access modify + static + dataType + variableName (recommend)
    public static int test(){}

    // static + access modify + dataType + variableName
    public static int test(){}
    ```
3. Call static method
    ```java
    // className.staticMethod
    A.test();
    // or
    // ObjectName.staticMethod
    a.test();
    ```
4. Application scenario (Utils)     
    When a method don't hava any properties and methods of a class, the method usually to be a static method. like util library, `Math`, `Array`and so on.
    ```java
    class MyTool {
        public static int sum(double n1, double n2){
            return n1 + n2;
        }
    }
    ```
5. Notes:
    1. No `this` or `super` keywork in static method.
        ```java
        public static void test(){
            super.xxx // error
            this.xx // error
            
        }
        ```
    2. Could be call by class or object.
    3. Call non-static method need to use object, can't directly use class to call.
    4. Static method can only access static variables or methods.
    5. Non-static method can access non-static variable or method and static variable or method.
    6. Static can only access static, non-static can access static and non-static.

## Main method

1. Notes
    1. Who call main? JVM call `main` method, so main method must be public.
    2. JVM call `main` method no need to create object, so this method must be static.
    3. `main` method receive String formal arguments
    4. java java.file argument1 argument2 ....
        ```java
        // terminal
        java test a b c

        // main
        public static void main(String[] args){
            args[0]; // a
            args[1]; // b
            // ...
        }
        ```
    5. `main` is a static method, can access static properties and methods, but can't access non-static properties and methods. Must create a object to access.

## Code block

1. Introduction: code block also name intial block, belong to class member(part of class), it's the same as method, using `{}` to encase logic statment. But it's different to method, it doesn't have name, return value, arguments, only have method body. And it can't be called directly. When a class import or create a object, it will be called.
2. Grammar
    ```java
    [modifier]{
        // coding
    };

    // example
    static {
        System.out.println("hello world");
    }
    ```
3. Notes:
    1. modifier: only `static` or none.
    2. Executation is preferred over construction.
    3. Code block could be a complement of constuction.
    4. Static code block is used to initialize class, will be called in **import class**, only **once**. non-static code block will be executed in creating object every time.
    5. When os import a class?
        1. `new` operation
        2. Create subclass object, parent class will be imported.
        3. Using static member of class, class will be imported. Using `Cat.age` will lead to import `Cat` class, class import will be executed static code block.
            ```java
            class Cat {
                public static int age = 10;

                static{
                    System.out.println("123");
                }
            }

            // main
            System.out.println(Cat.age);
            // 123
            // 10
            ```
    6. Using static member of class, non-static code block will be not executed. Non-static code block will only be executed in creating object.

## Design Patterns

1. Singleton Pattern
    1. Introduction: This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
    2. How to do a singleton pattern?
        1. Method 1 - directly assign the instance to variable(may cause use memory but not work).
            1. private constructor.
            2. Create the class object in class. Using static to define the object.
            3. Define a static method which return the object. And export it.
                ```java
                // gf
                class GirlFriend {
                    private String name;
                    private static GirlFriend gf = new GirlFriend(); // create the object of class.

                    private void GirlFriend(String name){
                        this.name = name;
                    }
                    // ...
                    public static GirlFriend getInstance() {
                        return gf;
                    }
                }

                // main
                GirlFriend tom = GirlFriend.getInstance();
                ```
        2. Method 2 - lazy create, when use the method, create and assign it to variable(may cause thread safety problem).
            1. private constructor.
            2. Create the class object and assgin `null`;
            3. Define a static method and method check if the object is equal to `null`, assign a new instance of class to it. Finally, return instance.
                ```java
                // gf
                class GirlFriend {
                    private String name;
                    private static GirlFriend gf = null; // create the object of class.

                    private void GirlFriend(String name){
                        this.name = name;
                    }
                    // ...
                    public static GirlFriend getInstance() {
                        if(gf == null) {
                            gf = new GirlFriend("tom");
                        }
                        return gf;
                    }
                }

                // main
                GirlFriend tom = GirlFriend.getInstance();
                ```
            
## `final` keyword

1. Introduction: to restrict the user. It can be used in variable, method, class. It can be initialized in the constructor only.
2. Cases
    1. `final` a class and this class can't be inherted.
        ```java
        final class A{}
        class B extends A {} // error, can't be extended.
        ```
    2. `final` a method and this method can't be override, overload.
         ```java
        class A{
            public final void hi(){}
        }
        class B extends A {
            @Override
            public final void hi(){} // error, can't be override.
        } 
        ```
    3. `final` a property in class and this property can't be modified.
    4. `final` a variable and this variable can't be changed.

3. Grammar
    1. class: `final class Xxxx{}`
    2. method: `accessModifier + final + return dataType + methodName`
    3. property/variable: `accessModifier + final + dataType + variableName + = initial value`
4. Notes:
    1. `final` modified properties are also called constants, usually use XX_XX_XX to name. Can modify a formal argument in a method(Can not modify the argument in method body)
        ```java
        public int list(final int X) {
            ++X; // error, can not modify.
            return X + 1;
        }
        ```
    2. `final` modified one properties must assign an initial value. It can be assgin in these positions:
        1. Define: like `public final double TAX_RATE = 0.08;`
        2. In construction.
        3. In code block.
            ```java
            class AA {
                public final int AGE = 10;
                public final int AGE1;
                public final int AGE2;

                {
                    AGE2 = 30;
                }

                public AA {
                    AGE1 = 20;
                }
            }
            ```
    3. If property is static and use `final` to modify, It can be assgined in these positions:
        1. Define
        2. static code block.   
        can't assign value in construction.
            ```java
            class AA {
                public static final int AGE = 10;
                public static final int AGE1;
                public static final int AGE2;

                static {
                    AGE2 = 30;
                }

                public AA {
                    AGE1 = 20; // error
                }
            }
            ```
    4. `final` class can't be inhertited, but it can be instantiated object.
    5. If class is not `final` class, but it has `final` methods, so this method can't be override, but it can be inherited.
    6. If a class is `final` class, it's unnecessary to modify methods using `final`.
    7. `final` can not modify a construction.
    8. `final` usually modify a property with `static`, high efficient(Since don't import the class of the property).
    9. Integer, Double, Float, Boolean, String are also `final` class.

## Abstract class, Abstract method

1. Introduction: An abstract class is a class that is declared abstract—it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed. An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon).
2. Notes
    1. abstract class is also a class, it can have properties, `static` modify, methods and so on.
        ```java
        abstract class AA {
            public int age;
            public static String name = "Tom";

            void call(){
                // ....
            }

            public abstract void test();
            // ...
        }
        ```
    2. If a class extends a abstract class, it must implement all abstract methods, except it is also a abstract class.
    3. Abstract method can't use `private`, `final`, `static` to modify. Since these keywords are contrary to override. 
3. Best practics -- template design pattern
    1. Requirements
        1. Multiple classes, finish different jobs.
        2. Get cost time that finish all jobs
    2. Thinking: define a abstract class `Template`, to finish these functions.
        1. Define a method `calculateTime`, can calcualte cost time in running which code.
        2. Define a abstract method `job`.
        3. Define a subclass, inherit abstract class, and implement code method.
        4. Define a test class `TestTemplate` to check it.
    3. Implementation.
        ```java
        // abstract class Template
        abstract class Template {
            public abstract void job();

            public void calculateTime() {
                long start = System.currentTimeMillis();
                job();
                long end = System.currentTimeMillis();
                System.out.println("time is" + (start - end));
            }
        }
        // class AA
        class AA extends Template {
            // ...
            @Override
            public void job() {
                // ...
            }
        }

        // class BB
        class BB extends Template {
            // ...
            @Override
            public void job() {
                // ...
            }
        }
        ```

## Interface

1. Introduction: An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface. Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested types.
    1. Abstract methods.
    2. Collection of abstract methods.
    3. Class implements interface.
    4. Contain constants, `default` methods, `static` methods, and nested types.
        ```java
        public interface TestInter {
            public int n1 = 10;

            public void hi();

            public default hello() {
                System.out.println("hello");
            }

            public static sayHi() {
                System.out.println("hi");
            }
        }
        ```
    5. Most important, order rules to limit all implementations, all implementations need to obey rules.
2. Grammar: 
    ```java
        interface InterfaceName { 
            // properties and methods 
        }

        // class implement
        class className implements InterfaceName {
            // self properties
            // self methods
            // must implement interface's methods
        }
    ```
3. Notes
    1. Interface can not be instance.
    2. All methods in interface are modified by `public`. Abstract methods no need to use `abstract` keyword to declare.
    3. All methods must be implemented when a class implement an interface. // alt + enter quick short
    4. Abstract class no request to implement methods of interface.
    5. One class could implement multiple interfaces.
        ```java
        class Pig implements AI, BI {
            // ...
        }
        ```
    6. All properites of interface are `final`, `public`, `static`.
        ```java
        
        interface IB {
            int n1 = 10;
        }

        // main
        System.out.println(IB.n1); // static
        IB.n1 = 2; // error, final
        ```
    7. Access a property of interface by using `interfaceName.propertyName`, like `IB.n1`.
    8. Interface can not extend other class, but it can extends multiple interfaces.
        ```java
        interface A extends B, C {}
        ```
    9. Interface modifier must be `public` or `default`.
4. Test
    1. Below coding is correct or not? print output.
        ```java
        interface A {
            int a = 23; // public static final a = 23;
        }
        class B implements A {} // A no methods, it's ok.

        // main
        B b = new B();
        System.out.println(b.a); // 23
        System.out.println(A.a); // 23
        System.out.println(B.a); // 23
        ```
5. Implement interface vs extend class
    1. Interface is a **add** for class, it's a "like-a" relationship.
    2. Extend class is a "is-a" relationship. Subclass extend super class, it will auto obtain super class's properties and methods.
        ```java
        class Monkey {
            public void climb() {
                System.out.println("climbing");
            }
        }

        interface Ride {
            public void rideBike();
        }

        class LitterMonkey extends Monkey implements Ride{

            @Override
             public void rideBike(){
                // ....
             }
        }
        

        // main
        LitterMonkey wuKong = new LitterMonkey();
        wuKong.climb();
        wuKong.rideBike();
        ```
    3. Conclusion:
        1. Solve different problems.
            1. interface: Design rules and lead class to obey and implement. more flexible.
            2. extend: Solve coding reuseability and maintainability.
        2. Interface could do more in decoupling.
410