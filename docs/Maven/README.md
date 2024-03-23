# Maven

## install

## create a Maven project

## IDE setting

## Maven pom.xml setting

### Dependencies

sometimes we need many dependencies, modify pom.xml, add `dependencies` and `dependency` scripts. Then
write down dependency what u want. after that, update maven setting. it will auto download.
[maven dependencies repo](https://mvnrepository.com/)

1. install

   ```xml
   <dependencies>
       <!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
       <dependency>
           <groupId>ch.qos.logback</groupId>
           <artifactId>logback-classic</artifactId>
           <version>1.2.3</version>
       </dependency>

   </dependencies>
   ```

2. 依赖传递
3. 依赖范围
   依赖的 jar 包，默认情况可以在任何地方使用。可以通过 `<scope>...</scope>` 设置起作用范围。
   1. 作用范围
      1. 主程序范围有效
      2. 测试程序范围有效
      3. 是否参与打包运行
   2. 表格
      |scope value|main|test|package|demo|
      |---|--|--|--|--|
      |compile(default)|Y|Y|Y|log4j|
      |test|-|Y|-|junit|
      |provided|Y|Y|-|servlet-api|
      |runtime|-|Y|Y|jdbc driver|
4. lifecycle

   1. types

      1. clean: clean
         1. pre-clean
         2. **clean**
            ...
      2. default: core work, such as compiler, test,
         package, install, deploy and so on
         ...

         1. compile
         2. test
         3. package
         4. install
            ...

      3. site: generate report, deploy site and so on.
         ...

   2. run:
      1. directly run: double click
      2. code run: `mvn clean` or `mvn` lifecycleName
   3. notes:
      1. run the bottom of lifecycle in any lifecycle type, the before lifecycle will be run.
      2. if u don't want a lifecycle run, u can skip the lifecycle.

[video](https://www.bilibili.com/video/BV1m84y1w7Tb/)
p58

## Spring

### quick start springboot web app

start an application and access `localhost:8080/hello`, and then return `Hello world`.

1. create springboot project, and select web dependency. `Web`-`SpringWeb`.
2. create request handle class `HelloController`, add request method named `hello`, and add Comment.

   ```java
   @RestController

   ...
       @RequestMapping("/hello")
   ```

3. running, and test

## HTTP

Hyper Text Transfer Protocol, defined rules what data transfer between clients and servers.

### request

```HTTP
GET /hello HTTP/1.1
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cache-Control: max-age=0
Connection: keep-alive
Host: localhost:8080
Sec-Fetch-Dest: document
Sec-Fetch-Mode: navigate
Sec-Fetch-Site: none
Sec-Fetch-User: ?1
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36
sec-ch-ua: "Not A(Brand";v="99", "Google Chrome";v="121", "Chromium";v="121"
sec-ch-ua-mobile: ?0
sec-ch-ua-platform: "macOS"

```

1. request line
   `GET /hello HTTP/1.1`
   `GET` request method
   `/hello` request path
   `HTTP/1.1` request protocol

2. request header
   |header|desc|
   |---|---|
   |host|request host name|
   |User-Agent|browser version|
   |Accept|resources type what browser accept|
   |Accept-Language|browser receive language|
   |Accept-Encoding|browser Compression type what browser receive|
   |Content-Type|data type what request|
   |Content_length|size of request (unit:byte)|
   ...
3. request body
   `{"status":1, name:"OPPO"}`
   get method: request params in `request line`, no request body, `get` request has size limit.
   post method: request params in request body, `post` request no size limit.

### response

```HTTP
HTTP/1.1 200 ok
Content-Type: text/html;charset=UTF-8
Content-Length: 12
Date: Mon, 19 Feb 2024 07:30:08 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{name:"oppo",status:1}
```

1. response line
   `HTTP/1.1 200 ok`
   `HTTP/1.1` http protocol
   `200` status code
   `ok` descript
2. response header

```
Content-Type: text/html;charset=UTF-8
Content-Length: 12
Date: Mon, 19 Feb 2024 07:30:08 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

3. response body
   `{name:"oppo",status:1}` store response data

#### http status code

| code | desc                                                                                                                             |
| ---- | -------------------------------------------------------------------------------------------------------------------------------- |
| 1xx  | responsing-temperate code, represent request received, and tell client continus request or if it has already finsh and ignore it |
| 2xx  | success-represent request has already received and handle is done                                                                |
| 3xx  | redirect-redirect to other place, need client start a new request to handle all process                                          |
| 4xx  | client error - Handling errors, the responsibility lies with the client                                                          |
| 5xx  | server error - Handling errors, the responsibility lies with the server                                                          |

#### http response header

| header           | desc                                                                    |
| ---------------- | ----------------------------------------------------------------------- |
| Content-Type     | response content type, such as text/html,application/json               |
| Content-Length   | length of response content                                              |
| Content-Encoding | comprese encoding, such as gzip                                         |
| Cache-Control    | tell client how to cache, such as max-age=300 represent max cache 300 s |
| Set-Cookie       | tell browser set cookie for current web-site                            |

## Tomcat

Apache Tomcat is an open-source web server and Servlet container for Java code. It's a production-ready Java development tool used to implement many types of Jakarta EE (formerly known as Java EE) specifications.

### web service

- Encapsulate the http protocol to simplify web program development
- Deploy web projects and provide online information browsing services to the outside world

### Tomcat

- A lightweight web server

### basic use

1. download
2. setting default.
3. run `tomcat/bin/start.sh`

## Request - Response

### Request

1. original method: `HttpServletRequest`
2. SpringBoot:
   1. same params name: directly get query. `get` or `post`
   2. not the same name: use `@RequestParam` to cast name. But the param is required, unless setting is `required:false`

### params receive

1. simple param: one or two params
2. complex params: at least two params, for example, `User` has `name`,`age` and `Address`. And `Address` has `province` and `city`.
   1. define Class `User` and receive
   ```java
   public String complexPojo(User user){
       System.out.println(user);
       return "ok!!!";
   }
   ```
3. Array or List params.

   `path?hobby=a&hobby=b&hobby=c`, request params is the same as original params.

   1. Array

   ```java
   public String arrayParam(String[] hobby){
       System.out.println(Arrays.toString(hobby));
       return "ok!!!arrayParam";
   }
   ```

   2. list

   ```java
   public String listParam(@RequestParam List<String> hobby){
      System.out.println(hobby);
      return "ok!!!listParam";
   }
   ```

4. Datetime
   use `@DateTimeFormat` to define and convert
   ```java
   public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
       System.out.println(updateTime);
       return "ok";
   }
   ```
5. JSON
   post, use `@RequestBody` to receive
   ```java
   public String jsonParam(@RequestBody User user){
       System.out.println(user);
       return "ok!";
   }
   ```
6. path params
   `/path/1`, `@PathVariable` to define variable and use.
   ```java
   public String pathParam(@PathVariable Integer id){
       System.out.println(id);
       return "ok!";
   }
   ```
   `/path/1/tom`
   ```java
   public String mulPathParam(@PathVariable Integer id,@PathVariable String name){
       System.out.println(id+": "+ name);
       return "ok!";
   }
   ```

## `@ResponseBody`

maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.

1. Return String, directly return
2. Object or List, return JSON.

## Uniform return results

`Result(code,msg,data)`

## web system design

1. basic web three layers - Controller, Service, Dao

   1. Controller: control layer, receive request from client, handle request and return response.
   2. Service: business logic layer, hander detail business logic.
   3. Dao: data access Object, Response for data access operation, including create,delete, update and quer data.

## IOC， DI

1. IOC
   Inversion Of Control, IOC, a design principle that inverts the flow of control in a program by decoupling components,Creating object from itself move to outsite.
2. DI
   Dependency Injection, DI, inject dependencies (i.e., objects) into an object, rather than the object being responsible for creating and managing its dependencies.
3. Bean
   A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.

### `@Component` and `@Autowired`

1. `@Component` is an annotation that allows Spring to detect our custom beans automatically.
2. `@Autowired` is an annotation that used for automatic dependency injection.

### Bean

if a object need to manage by `IOC`, need to add an annotation to the class.
|annotation|desc|position|
|----|----|----|
|@Component|annotate a bean||
|@Controller|other annotatin, different with`@Component`| use in controller class|
|@Service|other annotatin, different with`@Component`| use in business class|
|@Repository|other annotatin, different with`@Component`| use in data access class|

1. name: default is class name, such as `EmpService`, its bean name is `empService`. Default rule is first letter is
   low case, other is use `Camel` rule.

### `@Autowired`

if exist multiple same type bean, `@Autowired` will be fail. need to use other annotation to declare

```java
# ServerA
@Service
public class EmpServiceA implements EmpService {}

# ServerB
@Service
public class EmpServiceB implements EmpService {}

# controller class
    @Autowired
    private EmpService empService; // error
```

1. `@Primary`, to clear use which class. below is using `EmpServiceA`

```java
# ServerA
@Primary
@Service
public class EmpServiceA implements EmpService {}
```

2. `@Qualifier` to annotate which class.

```java
# controller class
@Qualifier("empServiceB")
@Autowired
private EmpService empService;
```

3. `@Resource` to replace `@Autowired`, `@Autowired` is provided by `spring`, `@Resource` by java.

```java
# controller class
@Resource(name="empServiceB")
private EmpService empService;
```

## module design and develop

## maven inherit

1. package method
   1. jar: SpringBoot project usually is jar.
   2. war: web package
   3. pom: parent project or aggregation project, no code, just dependencies management.

`<parent><parent>`

## version lock

1. common defined
   `<dependencyManagement></dependencyManagement>`
2. self properties

```xml
<!-- parent pom.xml -->
    <properties>
        <lomnok.version>1.18.24</lomnok.version>
    </properties>

    <!-- use properties, could be use in same pom.xml file -->
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lomnok.version}</version>
        </dependency>
    </dependencies>
```

## maven aggregation

Organize multiple modules into a whole， and doing project build. need a agression project(only have a `pom` file).
