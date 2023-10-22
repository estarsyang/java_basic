# Chapter13 Common class

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
4. common methods
   1. equals
   2. equalsIgnoreCase
   3. length
   4. indexOf
   5. lastIndexOf
   6. chatAt  
      ...
   7. toUpperCase
   8. toLowerCase
   9. contact
   10. replace
   11. split
   12. format: format String,
       1. %s -- string replace
       2. %d -- int/double
       3. %.2f -- percent to replace, .2 represent two decimal
       4. %c -- char  
          ...

## StringBuffer class

1. Introduction: StringBuffer is a class in Java that represents a mutable sequence of characters. It provides an alternative to the immutable String class, allowing you to modify the contents of a string without creating a new object every time.
2. tips:
   1. super class: AbstractStringBuilder
   2. implement Serializable class
   3. In super class, AbstractStringBuilder has `char[] value` property, no `final` modify. `value` store String content.
   4. `StringBuffer` is a final class can't be extend.
3. String vs StringBuffer
   1. String store string constant variable, its value can't be changed. each change of String is assigned a new momery address, not efficient. `char[] value`, `value` store in stored in stack, but actual value store in constant pool.
   2. StringBuffer store string variable, its value can be changed, each change of String is updated content of the variable, no need to create new object if the size of variable is enough. high efficient. `char[] value` and actual value is stored in stack.
4. Constuct

   ```java
   // create a StringBuffer of size 16. default size is 16.
   StringBuffer stringBuffer = new StringBuffer();

   // give size number. create a StringBuffer of size 100.
   StringBuffer stringBuffer = new StringBuffer(100);

   // give a string. create a StringBuffer of size str.length + 16.
   StringBuffer stringBuffer = new StringBuffer("hello");
   ```

5. String convert to StringBuffer

   ```java
   // String --> StringBuffer
   // method1 using construct
   // no affect str
   String str = "hello tom";
   StringBuffer stringBuffer = new StringBuffer(str);

   // method2 using append
   StringBuffer stringBuffer1 = new StringBuffer();
   stringBuffer1 = stringBuffer1.append(str);

   // StringBuffer --> String
   // method1 using toString
   StringBuffer stringBuffer3 = new StringBuffer("hello world");
   String s = stringBuffer3.toString();

   // method2 using construct
   String s1 = new String(stringBuffer3);
   ```

6. Common methods

   1. append: append a new value to the end of the stringBuffer. can be chain call.
   2. delete(start, end)
   3. replace(start, end, string)
   4. indexOf
   5. insert
   6. length

7. Exercise

   1. price format

      ```java
      /**
       * price format:
        * 1000.24 --> 1,000.24
        * 423.24 ---> 423.23
        * 410023.54 ---> 410,023.54
        */

      String price = "123456.78";

      StringBuffer sb = new StringBuffer(price);

      for (int i = sb.indexOf(".") - 3; i > 0 ; i -= 3) {
          sb = sb.insert(i,",");
      }
      System.out.println(sb);
      ```

## StringBuilder class

1. Introduction:Java StringBuilder class is used to create mutable (modifiable) String. The Java `StringBuilder` class is same as `StringBuffer` class except that it is non-synchronized(not ensure thread safety). It's designed to replace `StringBuffer`. Since it's small and high performance. if it's ok, use `StringBuilder` first(single thread).
   Main methods of `StringBuilder` are `append` and `insert`, can override these methods to accept any data type.
2. tips:
   1. most of information are the same as `StringBuffer`.
3. String vs StringBuffer vs StringBuilder
   1. `StringBuffer` and `StringBuilder` is almost the same. Whatever properties and methods. All represent the mutable String.
   2. String: unmutable sequence of characters, low efficient but reuse often.
   3. StringBuffer: mutable sequence of characters, higher efficient(update and delete), thread safety.
   4. StringBuilder: mutable sequence of characters, top efficient, not ensure thread safety.
   5. Using rules：
      1. String more modify , usually use `StringBuffer` and `StringBuilder`.
      2. String more modify and single thread, using `StringBuilder`.
      3. String more modify and multiple thread, using `StringBuffer`.
      4. String less modify and referenct by more object, using `String`.

## Math class

1. common methods
   1. abs
   2. pow
   3. ceil
   4. floor  
      ...

## Array class

1. common methods
   1. toString
   2. sort
   3. binarySearch: require a sort array.
   4. copyOf  
      ...

## System class

1. common methods
   1. exit: exit current program
   2. arraycopy: copy array item
   3. currentTimeMilles: returns the current time in milliseconds
   4. gc: run Garbage Collection, the automated process of deleting code that's no longer needed or used  
      ...

## BigInteger and BigDecimal class

1. BigInteger: use to store big int number.
2. BigDecimal: use to store high float number.
3. common methods:
   1. add
   2. subtract
   3. multiply
   4. divide
