# Chapter14 Collection

1. Introduction:A collection is an object that represents a group of objects (such as the classic Vector class). A collections framework is a unified architecture for representing and manipulating collections, enabling collections to be manipulated independently of implementation details.
   1. Structure
      1. Iterable[interface]
         1. Collection[interface]
            1. List
               1. Vector
               2. ArrayList
               3. LinkedList
            2. Set
               1. HashSet
               2. TreeSet
            3. ...
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
3. ArrayList vs LinkedList
   ||store data|add and delete efficient|update and read efficient|
   |----|----|----|----|
   |ArrayList|mutable array|low efficient, array expanding|high|
   |LinkedList|double linked list|high efficient, using linked list to add|low|
   1. update and reading more, choose ArrayList
   2. create and delete more, choose LinkedList
   3. Most of operation is reading, so choose ArrayList.
   4. In a project, module A using ArrayList, module B using LinkedList. Base on business.

## Set

1. Introduction: The set interface is present in java.util package and extends the Collection interface. It is an `unordered` collection of objects in which **duplicate values cannot be stored**. It is an interface that implements the mathematical set. This interface contains the methods inherited from the Collection interface and adds a feature that restricts the insertion of the duplicate elements.
2. Feature:
   1. no order, no index.
   2. no duplicate value.
3. Common methods:
   1. add: success retrun true otherwise false.
   2. iterate
   3. remove  
      ...
4. Iterate

   ```java
   // iterator
    Iterator iterator = hashSet.iterator();
    while (iterator.hasNext()){
        System.out.println(iterator.next());
    }

    //enhance for
    for (Object item:hashSet){
        System.out.println(item);
    }
   ```

## HashSet

1. Introduction

   1. HashSet implement Set interface
   2. HashSet actually is HashMap
   3. Could store null
   4. HashSet not ensure order, base on Hash function
   5. No duplicate value/element

2. Source code

   1. Implement a HashSet structure.

      ```java
      Node[] table = new Node[16];
      System.out.println("table=" + table);

      Node john = new Node("john",null);
      table[2] = john;

      Node jack = new Node("jack", null);
      john.next = jack;

      Node rose = new Node("rose", null);
      jack.next = rose;

      table[3] = new Node("lucy",null);
      ```

   2. How `add` method work?
      1. The root of HashSet is HashMap
      2. add one element, first get its hash value. And then, tranforms Hash value to a index value.
      3. find the data table, and check content of the index value is empty or not.
      4. if it's empty, store in this index.
      5. if it is not empty, using `equals` to compare, if result is equal, abort adding. if not,add it to the end(like linked list, add it to the end of list).
      6. In Java 8,if the size of a linkedlist is equal to `TREEIFY_THRESHOLD`(default is 8), and size of tbale is bigger or equal to `MIN_TREEIFY_CAPACITY`(default is 64), and then transformed from Linked list to Red Black tree (self balancing BST).
   3. p521-p524 HashSet source code, **hash code and equal**
   4. Exercise
      1. a `Employee` class, it have `age`, `name` properties.
      2. Create three employee, store in HashSet.
      3. When `name` and `age` are equal to exist data, it's the same employee. Can't be inserted into HashSet.

## LinkedHashSet

1. Introduciton:

   1. Subclass of `HashSet`.
   2. The internal of LinkedHashSet is LinkedHashMap, it maintains a array and double linked list.
   3. LinkedHashSet using hashCode of element to insert element to which position. And use linked list to maintain the `order`(it has a `order`).
   4. LinkedHashSet can't add duplicate element.

2. How LinkedHashSet add?

   1. The internal of LinkedHashSet maintains a hash table and double linked list. LinkedHashSet has `head` and `tail`.
   2. Each node has `before` and `after` properties to form a double linked List.
   3. When adding a new Element, first, to get the hashCode of this element. Second, to get the index of hash table to insert the element. Third, insert the element into double linked list(if the element already exists, no insert, the insert rules is the same as Hashset).
   4. Base on these process, Iterate LinkedHashSet couble be ensure the order of insert is the same as the order of output.

3. Exercise
   1. a `Car` class, it have `name`, `price` properties.
   2. Create three cars, store in LinkedHashSet.
   3. When `name` and `price` are equal to exist data, it's the same employee. Can't be inserted into LinkedHashSet.

## Map

1. Introduction:An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
   1. Structure
      1. Map
         1. HashMap
            1. LinkedHashMap
         2. TreeMap
         3. Hashtable
            1. Properties
2. Feartures:
   1. Map and Collection could exist side by side. Using to store a mapping relationship data(key-value).
   2. `key` and `value` could be any data type, and will be encapsulated to `HashMap$Node` object.
   3. `key` can be not duplicated, if insert a similar `key`, the value of the `key` will replace the original value.
   4. `value` could be duplicated.
   5. `key` could be `null`, value also.
   6. String class also could be `key` of a `Map` instance.
   7. `key` and `value` is a "one to one" relationship, so you can find value by using key.
   8. A key-value pair is stored in a Node, since Node implements `Entry` interface, some books write that a key-value is a `Entry`.
3. common methods
   1. put
   2. remove
   3. get
   4. size
   5. isEmpty
   6. clear
   7. containsKey
      ...
4. Iterate

   1. Introduction: If you want to iterate a `Map`,it's not easy. You need to use those methods,`containsKey`, `keySet`, `entrySet` and `values`.
   2. Steps:

      1. Get all keys by using `keySet` and find value base on key.
      2. Only get all values by using `values`.
      3. entrySet

         ```java
         // 1. using keySet
         Set keyset = hashMap.keySet();
         for (Object key : keyset) {
               System.out.println(key + "-" + hashMap.get(key));
         }

         // 2.get all values
         Collection values = hashMap.values();
         for (Object value : values) {
               System.out.println(value);
         }

         // 3. entrySet
         Set entrySet = hashMap.entrySet();
         for (Object entry : entrySet) {
               // entry to Map.Entry
               Map.Entry m = (Map.Entry) entry;
               System.out.println(m.getKey() + "-" + m.getValue());
         }
         ```

5. Conclusion

   1. Common implementation classes of `Map` interface: `HashMap`, `Hashtable` and `Peoperties`.
   2. The top using rate of implementation of `Map` is `HashMap`.
   3. `HashMap` is using key-vale pair to store data.
   4. Key can't be the same, but value is ok. `null` could be key or value.
   5. If adding the same key, old value will be replaced by new value.
   6. Same as `HashSet`, it can't be ensure the order of data, since it's base on `Hashtable` to store data.
   7. `HashMap` is not synchronized, so thread is not safed.

6. Analyse `HashMap` source code

## Hashtable

1.  Introduction
    1. store key-value pair.
    2. key and valu can't be `null`, otherwise throw error.
    3. Same as `HashMap`, most of methods are the same.
    4. `Hashtable` is thread safed.

## Properties

1. Introduction:
   1. Extend `Hashtable` class and implement `Map` interface, it also uses a key-value pair to store data.
   2. Same as `Hashtable`.
   3. Could read `xxx.properties` files and convert content to `Properties` Object, read and modify.
   4. `xxx.properties` usually as a config files.
2. Common methods
   1. get
   2. remove
   3. put
      ...

## How to choose a `Collection` in developing?

Base on your business, these are some rules below:

1. Determine the type of storage(a list of Object of a list of key-value)
   1. Object: `Collection` interface
      1. Allow duplicate: using List
         1. more add and delete operations: `LinkedList`(Base on a double linked list.)
         2. more read and modify operations: `ArrayList`(Base on a mutable array.Array\<Object\>)
      2. No duplicate: using Set
         1. no order: `HashSet`(base on `HashMap`, maintain a `Hashtable`(array+linkedlist+red black tree),)
         2. order: `TreeSet`
         3. Order of insert and output is the same: `LinkedHashSet`(maintain array+double linked list)
   2. key-value:Map
      1. Key no order: `HashMap`(maintain array + linked list + red black tree)
      2. Key order: `TreeMap`
      3. Order of key insert and key output is the same: `LinkedHashMap`
      4. Read files: `Properties`

## Collections util class

1. Introduction: `Collections` is a tool what operate `Set`, `List` and `Map`. It provides a series of static methods to , query, modify and others collection element.
2. Sort
   1. reverse(List): reverse list
   2. shuffle(List): random sort
   3. sort(List):normal sort, base on ASCII code.
   4. sort(List, Comparator): special sort, base on Comparator's result.
   5. swap(List, int, int): swap element of index i and j
3. Query and replace
   1. Object max(Collection): base on the normal order, return max object.
   2. Object max(Collection, Comparator):base on the Comparator order, return max object.
   3. Object min(Collection): base on the normal order, return min object.
   4. Object min(Collection, Comparator):base on the Comparator order, return min object.
   5. int frequency(Collection, Object): return the number of input Object in Collection
   6. void copy(List dest, List src): copy element of src to dest. Need to init dest List, the length of dest is equal to the length of src at least.
   7. boolean replaceAll(List list, Object oldVal, Object newVal): use new value replace old value in List object
