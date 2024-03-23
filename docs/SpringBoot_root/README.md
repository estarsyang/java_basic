SpringBoot root

## config files Priority

application.properties > **application.yml** > application.yaml, common use `yml` to do config files.

1. SpringBoot support file config ,and support _Java system properties_ and command params
   1. java system properties
      `-Dserver.port=9000`
   2. command params
      `--server.port=10010`
2. run `package` command by using maven
3. run java command to execute jar package
   1. default config by read config files: `java -jar xxx.jar`
   2. java system properties: `java -Dserver.port=9000 -jar xxx.jar`
   3. command params: `java -jar xxx.jar --server.port=10010`

## Bean management

1. get bean

   1. base name： `Object getBean(String name)`
   2. base type: `<T> T getBean(Class<T> requiredType)`
   3. base name and convert type: `<T> T getBean(String name, Class<T> requiredType)`

2. bean scope
   |scope|meaning|
   |----|----|
   |singleton|the same name bean will be only a instance in spring environment.(default setting)|
   |prototype|each time use bean will create a new instance|
   |....|...|

   1. use `@Scope("prototype")`to defined bean scope.
   2. use `@Lazy` to delay bean instance, only in fist time instance will be created

3. outside bean
   use `@Bean` to register a outside bean. Defined a config class and do bean centralized management. Bean name is method name. if a outside bean base on other bean, setting arguments, IOC container will auto import.

```java
@Configuration
public class CommonConfig {

  @Bean // assign SAXReader to IOC manage, to be a bean in IOC container.
  public SAXReader saxReader(){ // bean name is saxReader.
    return new SAXReader(DeptService depteServie); // auto import DeptService
  }
}
```

##
