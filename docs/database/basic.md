## concern

1. DB：database
2. DBMS： database management system.
3. SQL：structed query language

## 关系型数据库 RDBMS

1. 建立在关系模型的基础上，用多张相互连接的二维表组成的数据库
   1. 使用表存储数据，格式统一，便于维护
   2. 使用 SQL 语言操作，标准统一，使用方便

## SQL 通用语法

1. 可单行，多行
2. SQL 可以使用空格/缩进来增强语句
3. 不区分大小写，关键字使用建议使用大写
4. 注释
   1. 单行： -- 或 # (mysql 特有)
   2. 多行： /\* \*/

## 分类

| 分类 | 全称                       | 说明                                                   |
| ---- | -------------------------- | ------------------------------------------------------ |
| DDL  | Data definition            | 数据定义语言，用来定义数据库对象(数据库，表，字段)     |
| DML  | data manipulation language | 数据操作语言，用来对数据库表中的数据进行增删改         |
| DQL  | data query language        | 数据查询语言，用来查询数据库中表的记录                 |
| DCL  | data control language      | 数据控制语言，用来创建数据库用户，控制数据库的访问权限 |

### DDL

1. 数据库操作
   1. 查询
      1. 查询所有的数据库: SHOW DATABASES;
      2. 查询当前数据库: SELECT DATABASE();
   2. 创建
      1. CREATE DATABASE [IF NOT EXISTS] 数据库名 [DEFAULT CHARSET 字符集] [collate 排序规则]
   3. 删除
      1. DROP DATABASE[IF EXISTS] 数据库名;
   4. 使用
      1. USE 数据库名;
2. 表操作 - 查询
   1. 查询当前数据库所有表
      1. SHOW TABLES;
   2. 查询表结构
      1. DESE tableName;
   3. query a sql that create this table
      1. SHOW CREATE TABLE tableName;
3. table operations-create
   ```sql
   CREATE TABLE 表名(
     字段1 字段1类型[COMMENT 字段1注释],
     字段2 字段2类型[COMMENT 字段2注释],
     字段3 字段3类型[COMMENT 字段3注释],
     ...
   )[COMMENT 表注释];
   ```
4. 表操作-数据类型
   1. 数字类型
      |类型|大小|有符号(SIGNED)范围|无符号(UNSIGNED)范围|描述|
      |--|--|--|--|--|
      |TINYINT|1 byte|||||
      |SMALLINT|2 byte|||||
      |MEDIUMINT|3 byte|||||
      |INT 或 INTEGER|4 byte|||||
      |BIGINT|8 byte|||||
      |FLOAT|4 byte|||单精度|
      |DOUBLE|8 byte|||双精度|
      |DECIMAL||||||
   2. 字符串类型
      |类型|大小|描述|
      |--|--|--|
      |CHAR|0~255 bytes|定长字符串，char(10),长度是固定的，任何时候都是 10，性能好|
      |VARCHAR|0~65 535 bytes|变长字符串，varchar(10),长度不固定，根据输入设置，性能差|
      |TINYBLOB|0~255 bytes|不超过 255 个字符的二进制数据|
      |TINYTEXT|0~255 bytes|短文本字符串|
      |BLOB|0~65 535 bytes|二进制形式的长文本数据|
      |TEXT|0~65 535 bytes|长文本数据|
      |MEDIUMBLOB|0 ~ 16 777 215 bytes|二进制形式的中等长度文本数据|
      |MEDIUMTEXT|0 ~ 16 777 215 bytes|中等长度文本数据|
      |LONGBLOB|0 ~ 4 294 967 295 bytes|二进制的极大文本数据|
      |LONGTEXT|0 ~ 4 294 967 295 bytes|极大文本数据|
   3. 日期类型
      |类型|大小|范围|格式|描述|
      |--|--|--|--|--|
      |DATE|3|1000-01-01 至 9999-12-13|YYYY-MM-DD|日期值|
      |TIME|3|-838:59:59 至 838:59:59|HH:MM:SS|时间值或持续时间|
      |YEAR|1|1901 to 2155|YYYY|年份值|
      |DATETIME|8|1000-01-01 00:00:00 to 9999-12-31 23:59:59|YYYY-MM-DD HH:MM:SS|混合日期和时间值|
      |TIMESTAMP|4|1970-01-01 00:00:01 to 2038-01-19 03:14:07|YYYY-MM-DD HH:MM:SS|混合日期和时间值,时间戳|

```sql
create table emp (
  id int,
  workno varchar(10),
  name varchar(10),
  gender char(1),
  age tinyint unsigned,
  idcard char(18),
  entrydate date
);
```

09
