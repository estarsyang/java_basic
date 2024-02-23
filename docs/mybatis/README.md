# Mybatis

MyBatis is a first class persistence framework with support for custom SQL, stored procedures and advanced mappings.
DAO layer tools, support easy JDBC code and manual setting of parameters and retrieval of results.

## demo - select all user information.

1. init a springboot project.

   1. dependencies:
      1. MyBatis Framework
      2. MySQL Driver

2. defined a entity class `User` in package `pojo`. properties is the same as data in database;
3. defined a mappper interface `UserMapper` in package `mapper`

```java
import com.it.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // when running, it will auto generate a implement object of the interface, and assign the object to the IOC container.
public interface UserMapper {

    // query all user information
    @Select("select * from user")
    public List<User> list();
}
```

4. configure database in `src/main/resources/application.properties`

```properties
# driver name
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# database url
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis
# root
spring.datasource.username=root
# password, 12345678 is demo password, base on ur.
spring.datasource.password=12345678
```

5. run test. write a unit test. print all user information is ok.

```java
// ...
    @Autowired
    private UserMapper userMapper;

// ...
    @Test
    public void testListUser(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user ->{
            System.out.println(user);
        });

    }
```

## JDBC

Java DataBase Connectivity, is a set of API what use Java to operate relation database.
the JavaSoft specification of a standard application programming interface (API) that allows Java programs to access database management systems.

p119
