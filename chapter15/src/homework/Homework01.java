package homework;

import java.util.ArrayList;

/**
 * defined a generic class DAO<T>, defined a member variable Map, the key type of Map is String, value is T.
 * it has methods:
 * 1. public void save(String id, T entity): save T type object to Map
 * 2. public T get(String id): get an object which input id.
 * 3. public void update(String id, T entity): update an object which input id
 * 4. public List<T> list(): return a list what contain all T objects
 * 5. public void delete(String id): delete object which input id
 *
 * defined a User class.
 * member variables: (int) id, age.(String) name.
 *
 * create DAO class object and call save,get,update,list,delete methods to handle User object
 * using Junit to test
 */
public class Homework01 {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("001", new User(1,10,"tom"));
        dao.save("002", new User(2,20,"jerry"));

        System.out.println(dao);
        System.out.println(dao.get("002"));
        dao.update("002", new User(3,30,"dog"));
        System.out.println(dao.get("002"));
        System.out.println(dao.list());
        dao.delete("002");
        System.out.println(dao);


    }
}
