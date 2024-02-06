# Chapter15 Generic

1. Introduction: Generics means **parameterized types**. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types. An entity such as class, interface, or method that operates on a parameterized type is a generic entity.
2. contents

   1. Generic grammar
   2. Self defined generic
      1. Generic class
      2. Generic interface
      3. Generic methods
   3. Generic extend and wildcard

3. Advantages

   1. It can check data type when complier
   2. Reduce the number of casting, improve efficient.

4. Tips
   1. Generic type is reference type can not primitive type
   2. Assign a type to generic type could a reference type or its child type.
5. Self defined generic type class
   1. Grammar
      ```
      class className<T,R...>{
         members
      }
      ```
   2. notes:
      1. normal members could use generic(properties, methods)
      2. could not initial array which using generic.
         ```java
         T[] ts = new T[8]; // error
         ```
      3. could not using generic in static methods、class.
      4. when create a class, the generic type is already defined.
      5. when instances a object without defined its data type, its type is object.
6. Self define generic type interface

   1. Grammar

      ```
      interface interfaceName<T,R...>{

      }
      ```

   2. Notes
      1. static member could not using generic.
      2. type of generic interface, is defined in extends interface or implments interface.
      3. no setting type, default type is object.

7. Self define generic methods

   1. Grammar

      ```
      modifier <T,R...> returnType methodName(argus) {

      }
      ```

   2. Notes
      1. generic methods could defined in normal class and generic class.
      2. When generic methods are called, the generic type will be defined.
      3. `public void eat(E e){}`, no `<T,R...>`bellow modifier, `eat` is not a generic method but using generic.

8. Inherit and wildcard<?> in generic
   1. generic no support inherit
      `List<Object> list = new ArrayList<String>(); // error`
   2. <?>: support any generic type.
   3. <? extends A>: support A class and child classes of A.
   4. <? super A>: support A class and super classes of A.
