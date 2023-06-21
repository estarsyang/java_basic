## 20230621

## 一、JDK, JRE, JVM
1. JDK(Java Development Kit, Java开发工具包) = JRE + 开发工具集(例如 javac, java编译工具等)
2. JRE(Java Runtime Environment, Java 运行环境) = JVM + Java SE 标准类库(核心类库)
3. JVM(Java Virtual Machine Java 虚拟机) 一种能够执行Java字节码的虚拟机。

## 二、转义字符
1. \t: 一个制表位，实现对齐的功能
2. \n: 换行符
3. \\: 一个\
4. \": 一个"
5. \': 一个’
6. \r: 一个回车

## 三、注释
1. 单行注释 //
2. 多行注释 /* 注释文字 */
3. 文档注释 
```java
  /**
   * @author xx
   * @version 1.0
   * /
```


javadoc -d 输出的文件夹 -xx -yy xx.java 输出某个java文件的文档注释

## 四、java代码规范
1. 类，方法注释，用文档注释来写
2. 源文件使用UTF-8
3. 行宽度不超过80个字符
4. 行尾风格和次行风格