a manage system.

1. environment init.

   1. init database
   1. create springboot project, import dependencies(web, mybatis,mysql driver, lombok)
   1. config file
   1. prepare Mapper, Service, Controller

2. Restful
   REpresentational state transfer
   REST rule:
   1. get: query
   2. post: insert or add
   3. put: update
   4. delete: delete
3. uniform result

## functions

1. get all depts

```java
// annoation
@Slf4j // logbok defined and import

@GetMapping("/xxx") // http method get method, and path is /xxx
```

2. `@RequestMapping`

could get public request path into class.

```java
@RestController
public class DeptController{

   @GetMapping("/depts")
   public Result list(){
      // ...
   }

   @PostMapping("/depts")
   public Result save(@RequestBody Dept dept){
      // ...
   }
   //...
}
```

above code could be changed to below code

```java
@RestController
@RequestMapping("/depts")
public class DeptController{

   @GetMapping()
   public Result list(){
      // ...
   }

   @PostMapping()
   public Result save(@RequestBody Dept dept){
      // ...
   }
   //...
}
```

3. employee

   1. query all employee
      1. annotation
         `@RequestParam` could be set default value.
         ```java
         // ...
         public Result page(@RequestParam(defaultValue = "1") Integer page,
                     @RequestParam(defaultValue = "10") Integer pageSize) {
            // ...
         }
         // ...
         ```
         1. pagination
            PageHelp plugin
   2. condition query
      using `if` and `where` tag in `xml` file.
   3. batch delete emps
      using `foreach` tag in `xml` file.

      1. annotation: `@PathVariable`

   4. add new emp

      1. annotation: `@RequestBody`

   5. update
      1. get employee information
         `getById`
      2. update

4. file upload

   1. Notes

      1. Frontend
         1. form type is `file`
         2. post method
         3. form need to set `enctype` property is `multipart/form-data`.
      2. Backend
         1. server need to set receive type is `MultipartFile`.
      3. springboot file default size : 1MB, need to redefined upload limit size.

         ```properties
         # single file upload limit size
         spring.servlet.multipart.max-file-size=10MB

         # multiple files upload limit size
         spring.servlet.multipart.max-request-size=100MB
         ```

      4. `UUID` tool to generate a unique id to name a uploaded file.
      5. `@Value` to get value from properties file. `@Value("${key in properties file}")`
         ```java
         @Value("${test}")
         private String test;
         ```

## `yml` or `yaml` config file and `@ConfigurationProperties`

1.  Grammar
    1. be careful to UpperCase and lowerCase
    2. must be `space` before value
    3. use indentation to represent layer relationship. no `Tab` must `space`
    4. `#` represent comment.
2.  data type
    1. object/Map
       ```yml
       user:
         name: tom
       ```
    2. Array/List/Set
       ```yml
       # an Array/List/Set hobby has two values java and c
       hobby:
         - java
         - c
       ```
3.  `@ConfigurationProperties`
    auto inject value to the same name variable which in `yml` config file.

## login

1. session: The time interval in which two systems(i.e. the client and the server) communicate with each other can be termed as a session. In simpler terms, a session is a state consisting of several requests and response between the client and the server.
2. session track: Session tracking is used to record user actions on a website. Maintain client status, server need to identify multiple requests from the same client and share data in a session.

3. cookie and token
4. JWT

p163
