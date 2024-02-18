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
