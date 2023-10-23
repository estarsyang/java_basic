# Chapter14 Collection

1. Introduction:A collection is an object that represents a group of objects (such as the classic Vector class). A collections framework is a unified architecture for representing and manipulating collections, enabling collections to be manipulated independently of implementation details.
2. Advantages:
   1. Could store any more objects, easy to use.
   2. Provide a series of methods to operate object, like `add`,`remove`,`set`,`get` and so on.
   3. Using collection to add, delete new element is easy.
3. Collection framework
   1. Collection (single value)
      1. List
         1. ArrayList
         2. LinkedList
         3. Vector
      2. Set
         1. HashSet
         2. TreeSet
   2. Collection (key-value)
      1. Map
         1. HashMap
         2. TreeMap
         3. HashTable
         4. Properties
4. Common methods
   1. add
   2. remove
   3. contains  
      ...
5. Iterator
   1. Introduction: Collection Iterate by using Iterator. To iterate element of collection. All collection classes what implement `Collection` interface have a method named `iterator`. `iterator` method return a object which implement `Iterator` interface.
   2. Methods
      1. hasNext
      2. next
      3. remove
6. Collection iterate

   1. Using Iterator

      ```java
      List col = new ArrayList();

        col.add("tom");
        col.add("jerry");
        // key word: itit, quick to code a iterator
        // return a iterator, has hasNext, next...
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        // second iterate
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
      ```

   2. Enhance for

      ```java
      List col = new ArrayList();

      col.add("tom");
      col.add("jerry");

      for (Object item:col){
          System.out.println(item);
      }
      ```

## List interface

1. Introduction: The `List` interface in Java provides a way to store the ordered collection. It is a child interface of `Collection`. It is an **ordered** collection of objects in which **duplicate** values can be stored. Since List preserves the insertion order, it allows positional access and insertion of elements.
2. features:

   1. List is ordered
   2. List has index, so it supports searching index
   3. Value could be duplicate

      ```java
      List list = new ArrayList();

      list.add("jerry");
      list.add("tomm");
      list.add("mary");
      list.add("mary");

      // index
      list.get(2); // mary
      ```

3. Common methods:
   1. add
   2. addAll
   3. get
   4. indexOf
   5. lastIndexOf
   6. remove
   7. set
   8. subList  
      ...
4. Iterate

   1. Iterator
   2. enhance for
   3. for

      ```java
      // enhance for
      for (Object item:arrayList){
          System.out.println(item);
      }

      // for
      for (int i = 0; i < arrayList.size(); i++) {
          System.out.println(arrayList.get(i));
      }
      ```

5. tips:
   1. could insert all elements inclduing null, undefined
   2. ArrayList implemented by array
   3. ArrayList is the same as Vector, not ensure thread safety. Multiple thread shoud be not use ArrayList
6. Source code analyze
   1. ArrayList maintain an array to store data, `Object[] elementData`. Item type is `Object`.
   2. When create an ArrayList object with no formal arguments, the length of `elementData` is 0, first time add data, the length will be set to **10**, the length will be set to **1.5\*the length** in second time adding or following times.
   3. Create an ArrayList with size, the length of `elementData` is equal to size. The length of `elementData` will be set to **1.5\*the length** in first time adding.

## Vector

1. Introduction:
   1. Vector also using an object array to store data.
   2. Vector ensure thread safety. All methods in Vector have `synchronized` key word.
   3. Need thread safety use Vector.
2. Vector vs ArrayList
   ||store structor|version|thread/efficient|expanding|
   |----|----|----|----|----|
   |ArrayList|mutable array|jdk1.2|not safety but high efficient|no arguments first time set 10, following time set 1.5\* old length. Have arguments set 1.5\* old length|
   |Vector|mutable array|jdk1.0|safety but low efficient|no arguments first time set 10, following time set 2\* old length. Have arguments set 2\* old length|

## LinkedList

1. Introduction:
   1. Could add any data
   2. not thread safety.
2. Implement
   1. LinkedList maintain a double linked list.
   2. It has two properties, one is `first`, represent first node. Other is `last` represent the last node.
   3. Each node has three properties, `prev`, `next`, `item`. `prev` represent previous node, `next` represent next node, item represent currnt node's data.
   4. add and delete item is not using array.

p515
