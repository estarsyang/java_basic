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

## Three primitive data type auto transformer
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

> p82 next lecture