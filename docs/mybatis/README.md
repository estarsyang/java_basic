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

## connection pool

a cache of database connections maintained so that the connections can be reused when future requests to the database are required. It is a container, response to allot and manage database connection.

## Lombok

Lombok is a java class libary, it could automatic generated constructor, getter/setter, equals, hashcode, toString and so on by using annotation. And could automatic generated variable log, improve efficience.

| annotation              | desc                                                                         |
| ----------------------- | ---------------------------------------------------------------------------- |
| @Getter/@Setter         | provide all properties for getter,setter                                     |
| @ToString               | auto generate toString method                                                |
| @EqualsAndHashCode      | auto rewrite `equals` and `hashCode` for all non-static properties           |
| **@Data**               | provide all generate methods(@Getter,@Setter, @ToString, @EqualsAndHashCode) |
| **@NoArgsConstructor**  | generate no arguments constructors                                           |
| **@AllArgsConstructor** | generate all arguments constructors except `statis` modify properties        |

## basic operation

1. prepare data
2. create a new springboot project, select start dependencies(mybatis, mysql drive, lombok)
3. config database properties
4. create class `Emp`
5. prepare `Mapper` interface `EmpMapper`

### delete

1. `mapper` `sql` statement receive variable use `#{xxx}` to receive. the same name is best.

```java
// ...
 @Delete("delete from emp where id=#{id}")
 public void delete(Integer id);
// ...
```

### prepare compiler sql

`@Delete("delete from emp where id=#{id}")`
advantages: higher performance, higher safe(prevent SQL inject)

### Insert without return primary key

```java
@Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);
```

### Insert with return primary key

add `@Options` modifier

```java
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);
```

### update

```java
    @Update("update emp set username=#{username},name=#{name},gender=${gender},image=#{image}," +
            "job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id};")
    public void update(Emp emp);
```

### query

if it appears underscore is not match camel, like `dept_id` and `deptId`, uneed to open underscore to camel-cass in mybatis properties. otherwise, it will not get correct value in result.

```java
    @Select("select * from emp where id=#{id};")
    public Emp getById(Integer id);
```

### condition query

if want to fuzzy query, such as `like '%tom%'` and others, please use concat since `#{varibale}` can't using in `''`.

```java
    @Select("select * from emp where name like concat('%',#{name},'%') and gender =#{gender} and" +
            "(entrydate between #{begin} and #{end}) order by  update_time desc ;")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
```

### xml cast file

1. rules:

   1. The name of file what cast by xml is the same as `Mapper` interface, and in the same package(same package and same name)
   2. `namespace` of xml file need to the same as `Mapper` interface
   3. `id` in sql statement of xml file must be the same as `Mapper` interface method, and return the same type.

2. demo

```java
    @Select("select * from emp where name like concat('%',#{name},'%') and gender =#{gender} and" +
            "(entrydate between #{begin} and #{end}) order by  update_time desc ;")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
```

to modify

```java
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--EmpMapper.xml-->
<mapper namespace="com.itheima.mapper.EmpMapper">

    <select id="list" resultType="com.itheima.pojo.Emp">
        select * from emp where name like concat('%',#{name},'%') and gender =#{gender}
        and (entrydate between #{begin} and #{end}) order by  update_time desc ;
    </select>
</mapper>
```

### dynamic sql

1. `if`
   `if` use to determine whether the condition is met. Using `test` property to determine, if result is `true`, concat sql. `where` use to determine whether add `and` and `or` in sql condition.

```xml
    <!-- ... -->
    <select id="list" resultType="com.itheima.pojo.Emp">
        select * from emp
        <where>
            <if test="name != null">
                name like concat('%',#{name},'%')
            </if>
            <if test="gender !=null">
                and gender =#{gender}
            </if>
            <if test="begin != null and end != null">
                and (entrydate between #{begin} and #{end})
            </if>
            order by update_time desc ;
        </where>
    </select>
    <!-- ... -->
```

p131
