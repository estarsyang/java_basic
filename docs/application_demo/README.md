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

p140
