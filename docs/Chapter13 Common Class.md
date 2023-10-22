# Chapter13 Common Class

## Wrapper class

1. introduction: Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
   The table below shows the primitive type and the equivalent wrapper class:

   | Primitive Data Type | Wrapper Class |
   | ------------------- | ------------- |
   | byte                | Byte          |
   | short               | Short         |
   | int                 | Integer       |
   | long                | Long          |
   | float               | Float         |
   | double              | Double        |
   | boolean             | Boolean       |
   | char                | Character     |

2. Why use wrapper classes, Since has wrapper classes, we can use methods in class.

3. Wrapper class convert to primitive data types. Autoboxing and Unboxing

   ```java
   // main
   // before jdk5
   // manual boxing
   int i = 200;
   Integer integer1 = new Integer(i);
   Integer integer2 = Integer.valueOf(i);

   // manual unboxing
   int n1 = integer1.intValue();

   // after jdk5
   // auto boxing
   int n2 =200;
   Integer integer03 = n2; // in the root, it uses Integer.valueOf(n2)
   // auto unboxing
   int n3 = integer03; // in the root, it uses intValue() method
   ```

4. wrapper exercise

   ```java
   // is true or not
   Double d = 100d; // true, autoboxing
   Float f 1.5f; // true, autoboxing

   // what output
   Object obj1 = true ? new Interger(1):new Double(2.0);
   System.out.println(obj1); // 1.0, why 1.0? since ternary operator need to consider precise?it will get the top precise and return. int vs double, it will return double, and do condition determine.

   // what output
   Object obj2;
   if(true){
   obj2 = new Interger(1);
   } else {
   obj2 = new Double(2.0)
   }
   System.out.println(obj2); // 1
   ```

5. Wrapper convert to String(using Integer and String)

   ```java
   // Integer to String
   Integer i = 10;

   // method 1
   String str1 = i + "";

   // method 2
   String str2 = String.valueOf(i);

   // method 3
   String str3 = i.toString();

   // String to Integer
   String str4 = "123";

   // method 1
   Integer num1 = Integer.parseInt(str4);

   // method 2
   Integer num2 = Integer.valueOf(str4);
   ```

## String class

1. Introduction: Strings are used for storing text. A String variable contains a collection of characters surrounded by double quotes. Using Unicode to code String, one char is two bytes.
2. tips:
   1. String class implements `Serializable`, `Comperable` and so on interface.
   2. String has property `private final char value[]`, Using to store stirng content.
   3. `value` is `final` type, can't be changed, this is `value` can not store a new momery address, but single char can be changed.
      ```java
      final char[] value = {'a','b','c'};
      value[0] = 'd';
      char[] v2 = ['t','o','m'];
      value = v2; // error.
      ```
3. Create String object
   ```java
   // method1
   String s1 = "hello world";
   // method2
   String s2 = new String("hello world");
   ```
   p471
