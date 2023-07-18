> 20230621

## 一、JDK, JRE, JVM
1. JDK(Java Development Kit, Java开发工具包) = JRE + 开发工具集(例如 javac, java编译工具等)
2. JRE(Java Runtime Environment, Java 运行环境) = JVM + Java SE 标准类库(核心类库)
3. JVM(Java Virtual Machine Java 虚拟机) 一种能够执行Java字节码的虚拟机。

## 二、转义字符
1. \t: 一个制表位，实现对齐的功能
2. \n: 换行符
3. \\: 一个\
4. \": 一个"
5. \': 一个’
6. \r: 一个回车

## 三、注释
1. 单行注释 //
2. 多行注释 /* 注释文字 */
3. 文档注释 
```java
  /**
   * @author xx
   * @version 1.0
   * /
```


javadoc -d 输出的文件夹 -xx -yy xx.java 输出某个java文件的文档注释

## 四、java代码规范
1. 类，方法注释，用文档注释来写
2. 源文件使用UTF-8
3. 行宽度不超过80个字符
4. 行尾风格和次行风格


# Chapter 3
## 一、变量
1. 变量: 表示内存中的一个存储区域，不同变量，类型不同，占用空间大小不同
2. 该区域有自己的名称和类型
3. 变量必须先声明再使用
4. 该区域的数据可以在同一类型范围内不断变化
5. 变量在同一作用域内不能重名
6. 变量 = 数据类型 + 变量名 + 变量值

## 二、数据类型
1. 基本数据类型
    1. 数值型
        1. 整数类型，存放整数(byte[1],short[2],int[4],long[8])
        2. 浮点(小数)类型(float[4],double[8])
    2. 字符串 char[2], 存放单个字符 'a
    3. 布尔型 boolean[1], 存放true, false
2. 引用数据类型
    1. 类(class)
    2. 接口(interface)
    3. 数组([])

3. 整数的类型
    1. 整数的空间大小
        |类型|占用存储空间|范围|
        |----|----|----|
        |byte[字节]|1|-128~127|
        |short[短整型]|2|-32768~32767|
        |int[整型]|4|-2147483648~2147483647|
        |long[长整形]|8||
    2. 整数的细节
        1. 各整数类型有固定范围和长度，不受os影响
        2. 整数变量默认为int，声明long型常量需要在后面加"L"或者"l"
        ```java
          int n1 = 1;
          int n2 = 1l; // error, long can't store in int
          long n3 = 1l;
        ```
        3. 常用int声明，不足采用long, 尽量使用小的类型，保小不保大。
        4. bit: 计算机中最小的存储单位，byte：计算机中基本存储单元，1 byte = 8 bit。
> 20230622
4. 浮点数
    1. 分类
        |类型|占用存储空间|范围|
        |----|----|----|
        |单精度float|4|-3.403e38~3.403e38|
        |双精度double|8|-1.798e308~1.798e308|

        - 浮点数在机器中存放形式的简单说明，浮点数 = 符号位+指数位+尾数位
        - 尾数部分可能丢失，造成精度损失。
    2. 细节
        1. 有固定范围和长度，不受具体os影响。
        2. 默认为double型，声明float通常加"f"或者"F"
        3. 通常两种表示形式
            1. 十进制: 5.12 512.0f .512
            2. 科学计数法: 5.12e2 ==>> 5.12 * 10的2次方 5.12E-2 ==>> 5.12 / 10的2次方
        4. 通常情况下使用double，比float精确。
            ```java
            double num1 = 2.1234567851; // output； 2.1234567851, not loss
            float num2 = 2.1234567851F; // output: 2.1234567, loss some decimal, 851
            float num3 = 1.1; // error, double assign to float;
            double num4 = 1.1f; // ok, float transform to double;
            ```
        5. 浮点数使用陷阱
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