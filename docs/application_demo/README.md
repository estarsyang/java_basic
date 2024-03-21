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
   1. generate: use `jjwt` dependency.
   2. `jjwt` generate jwt in springboot need to in jdk1.8, if u using 11 or higher version, u need to install `javax.xml.bind`
      ```xml
      <!-- pom.xml -->
      <!-- ... -->
      <dependency>
         <groupId>javax.xml.bind</groupId>
         <artifactId>jaxb-api</artifactId>
         <version>2.3.1</version>
      </dependency>
      <!-- ... -->
      ```
   3. generate
   ```java
   public static String generateJwt(Map<String, Object> claims){
      String jwt = Jwts.builder()
               .addClaims(claims)
               .signWith(SignatureAlgorithm.HS256, signKey)
               .setExpiration(new Date(System.currentTimeMillis() + expire))
               .compact();
      return jwt;
   }
   ```
   4. check jwt, need to use `try catch` to surround the `parseJWT` method. error represent the jwt value is not correct.
   ```java
   public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
   ```
5. Filter
   intercept request to do some handlers, for example, login check.
   need to add annoation `@WebFilter(urlPatterns = "/*")` in filter class.

   ```java
   @WebFilter(urlPatterns = "/*") // /* represent intercept all request.
   public class DemoFilter implements Filter{
      // ...

      @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // some hanler before request through. login check or other
        // ...

       // request through
        filterChain.doFilter(servletRequest,servletResponse);

        // do something before return client
        // ...


    }
   }
   // ...
   ```

   and add `@ServletComponentScan` in springboot entry.

   ```java
   // springboot entry
   @ServletComponentScan
   @SpringBootApplication
   public class TliasWebManagementApplication{
      // ...
   }
   ```

   1. could be more `filter` instance, running rules base on class name. for example, `AbcFilter` is running before `BFilter`.

6. Interceptor
   the same as `filter` but provide by `spring` not `Servlet`

   1. Gammar:

      ```java
      @Component
      public class LoginCheckInterceptor implements HandlerInterceptor {
         @Override
         public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("preHandle ....");
            return true;
         }

         @Override
         public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            System.out.println("postHandle ....");
         }

         @Override
         public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            System.out.println("afterCompletion ....");
         }
      }
      ```

      ```java
      @Configuration
      public class WebConfig implements WebMvcConfigurer {

         @Autowired
         private LoginCheckInterceptor loginCheckInterceptor;

         @Override
         public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");
         }
      }

      ```

   2. intercept path

   ```java
   // ...
   registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**") //
            .excludePathPatterns("/login");
   ```

   | path config | meaning                       | exmaple                                                                                         |
   | ----------- | ----------------------------- | ----------------------------------------------------------------------------------------------- |
   | /\*         | first level path              | /depts,/emps and so on, not include /depts/1                                                    |
   | /\*\*       | any path                      | could intercept any path                                                                        |
   | /depts/\*   | first level path after /depts | /depts/1, not include /depts/1/2                                                                |
   | /depts/\*\* | any path after /depts         | /depts,/depts/1,/depts/1/2, not include any path without start with /deps, for example, /emps/1 |

   3. different with `filter`
      1. filter need to implements `Filter` class, interceptor need to implements `HandlerInterceptor`
      2. scope different, filter will catch all resources but interceptor only intercept resources what pass into Spring environment

## Error handle

define a global error handle class to catch all error.

1. annotation
   1. `@RestControllerAdvice`
   2. `@ExceptionHandler`

## Spring transaction and AOP

1.  Spring transaction
    using `@Transactional` to annotate class or others. Usually annotate implemention of service which business operation.

2.  properties

    1. rollbackFor: only appear `RuntimeException` will emit rollback in default case. `rollbackFor` use to control which type exception will emit rollback.
       ```java
       // ...
       @Transactional(rollbackFor= Exception.class) // all exception will emit rollback.
       // ...
       ```
    2. propagation: When a transaction method is called by another transaction method, how to do transaction controller.
       for example, b is called by a and both of them are transaction. a start a transaction, when calling b, b will join the transaction or create a new transaction?

       ```java
       @Transactional
       public void a(){
          // ...
          userService.b();
          // ...
       }

       @Transactional
       public void b(){
          // ...
       }

       ```

    | property value   | meaning                                                                                             |
    | ---------------- | --------------------------------------------------------------------------------------------------- |
    | **REQUIRED**     | default value, need transaction, if it exist transaction and join. if not, create a new transaction |
    | **REQUIRED_NEW** | need a new transaction, always create a new. if we wish not effect between transactions, use it.    |
    | SUPPORTS         | support transation, if exits and join, if not, run in no transaction status.                        |
    | NOT_SUPPORTED    | no support transaction, run in no transaction status. if exist, will be suspended                   |
    | MANDATORY        | must exist transaction, otherwise error                                                             |
    | NEVER            | must no transaction, otherwise error                                                                |

         ```java

         @Transactional
         public void a(){
         // ...
         userService.b();
         // ...
         }

         @Transactional(propagation = Propagation.REQUIRED)
         public void b(){
         // ...
         }

         ```

## AOP

1. meaning: Aspect Oriented Programming, orient the special method to code.
   1. springAOP case: calculate cost time when business layers' methods run.
      1. steps
         1. import dependency
         2. coding AOP.
      2. annotation:
         1. `@Component`
         2. `@Aspect`
         3. `@Around`

p176
