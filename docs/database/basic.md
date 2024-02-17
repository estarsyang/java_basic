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

5. 表操作-修改
   1. 添加字段
      ```sql
      ALTER TABLE tableName ADD columnName columnType(column length) [COMMENT comment] [constrict];
      ```
   2. modify column type
      ```sql
      ALTER TABLE tableName MODIFY columnName newColumnType(column length);
      ```
   3. modify column name and type
      ```sql
      ALTER TABLE tableName CHANGE oldColumnName newColumnName columnType(column length) [COMMENT comment] [constrict];
      ```
   4. Drop column
      ```sql
      ALTER TABLE tableName DROP column;
      ```
   5. Rename table name
      ```sql
      ALTER TABLE tableName RENAME TO newTableName;
      ```
   6. Drop table
      ```sql
      ALTER TABLE [IF EXISTS] tableName;
      ```
   7. Drop and recreate table
      ```sql
      TRUNCATE TABLE tableName;
      ```

### DML

DML, data manipulation language, used to modify data in database. Including insert, update and delete.

1. insert data
   1. insert data to the specified column.
      ```sql
      INSERT INTO tableName (column1, column2,...) VALUES (value1, value2,...);
      ```
   2. insert data to all columns.
      ```sql
      INSERT INTO tableName VALUES (value1, value2,...);
      ```
   3. insert more data to columns.
      ```sql
      INSERT INTO tableName (column1, column2,...) VALUES (value1, value2,...),(value1, value2,...),(value1, value2,...);
      INSERT INTO tableName VALUES (value1, value2,...),(value1, value2,...),(value1, value2,...);
      ```
2. update data
   1. update data
      ```sql
      UPDATE tableName SET column1=value1, column2=value2,... [WHERE condition]
      ```
3. delete data
   1. delete data
      ```sql
      DELETE FROM tableName [WHERE condition]
      ```

### DQL

DQL, data query language, used to query data.

1.  query data
    ```sql
    SELECT column1, column2,...
    FROM tableName
    WHERE conditions
    GROUP BY group cloumn
    HAVING condition after group by
    ORDER BY order conditon
    LIMIT data number
    ```
2.  base query
    1.  query multiple column
        ```sql
        SELECT column1, column2,... FROM tableName;
        SELECT * FROM tableName;
        ```
    2.  query setting alias name.
        ```sql
        SELECT column1 [AS alias1], column2 [AS alias2],... FROM tableName;
        ```
    3.  remove repeat data.
        ```sql
        SELECT DISTINCT column1,column2,... FROM tableName;
        ```
3.  condition query.

    1.  condition query.
        ```sql
        SELECT columns FROM tableName WHERE conditions.
        ```
    2.  conditions
        |comparison operator|function|
        |----|----|
        |>|bigger than|
        |>=|bigger than or equal|
        |<||
        |<=||
        |<> or !=|no equal|
        |BETWEEN ... AND ...|between the range(including min and max)|
        |IN(...)|the value in list, match one value is ok|
        |LIKE |fuzzy query(\_ represent single charter, % represent any charter|
        |IS null|value is null|

        | logic operator | function |
        | -------------- | -------- |
        | AND or &&      |          |
        | OR or \|\|     |          |
        | NOT or !       |          |

4.  aggregation query
    1.  calculate one cloumn, not including `null` value.
    2.  normal use function
        |function name|function|
        |----|----|
        |count|count the number|
        |max||
        |min||
        |avg||
        |sum||
    3.  Grammar
        ```sql
        SELECT aggregateFun(columns) FROM tableName;
        ```
5.  group query
    1.  group query
        ```sql
        SELECT columns FROM tableName [WHERE condition] GROUP BY group column name [HAVING filter condition after group]
        ```
    2.  `where` and `having` different
        1.  running time: `where` is running before group query, if it's not match `where` condition, it will not consider to group. `having` is running after group query.
        2.  condition: `where` can not use in aggregation but `having` can use in.
    3.  notes
        1.  query oreder: where > aggregation > having
        2.  After group query, the query result is normal _aggregation function_ or _group column_, other result is pointless.
6.  order query
    1. order query
       ```sql
       SELECT columns FROM tableName ORDER BY column1 orderRule1, column2 orderRule2,...;
       ```
    2. order rules
       1. ASC: ascending
       2. DESC: descending
    3. multiple columns order, query first column by order, if value is equal, query second column by order. if value is not equal, not consider other columns only first column.
7.  pagination query
    1. pagination query
       ```sql
       SELECT columns FROM tableName LIMIT index, query number;
       ```
    2. notes:
       1. index start with `0`, start index = (query page - 1) \* number of each page.
       2. mysql is use `limit` to query, different databases have their keyword.
       3. if query first page data, index colud be not passing in, `limt 10`.
8.  excute order
    ```sql
    SELECT column1, column2,...
    FROM tableName
    WHERE conditions
    GROUP BY group cloumn
    HAVING condition after group by
    ORDER BY order conditon
    LIMIT
    ```
    1. FROM
    2. WHERE
    3. GROUP BY
    4. HAVING
    5. SELECT
    6. ORDER BY
    7. LIMIT

### DCL

data control language, used to control database user, access rules.

1. user

   1. query user
      ```sql
      USE mysql;
      SELECT * FROM user;
      ```
   2. create user
      ```sql
      CREATE USER 'username'@'hostname' IDENIFIED BY 'password';
      ```
   3. change user password
      ```sql
      ALTER USER 'username'@'hostname' IDENIFIED WITH mysql_native_password BY 'new password';
      ```
   4. delete user
      ```sql
      DROP USER 'username'@'hostname'
      ```

2. user access control
   |permission|desc|
   |ALL, ALL PRIVILEGES|all permiss|
   |----|----|
   |SELECT|query data|
   |INSERT|insert data|
   |UPDATE|update data|
   |DELETE|delete data|
   |ALTER|alter table|
   |DROP|delete databse, table, view|
   |CREATE|create databse, table, view|
   1. query permission
      ```sql
      SHOW GRANTS FOR 'username'@'hostname';
      ```
   2. grant permission
      ```sql
      GRANT permissionList ON databaseName.tableName TO 'username'@'hostname';
      ```
   3. revoke permission
      ```sql
      REVOKE  permissionList ON databaseName.tableName FROM 'username'@'hostname';
      ```

## function

### String function

| function name            | function desc                                                                      |
| ------------------------ | ---------------------------------------------------------------------------------- |
| CONCAT(S1,S2,...Sn)      | concat string                                                                      |
| LOWER(str)               | convert str to lowercase                                                           |
| UPPER(str)               |                                                                                    |
| LPAD(str,n,pad)          | left padding, Use string pad to pad the left side of str to reach n string lengths |
| RPAD(str,n,pad)          |                                                                                    |
| TRIM(str)                |                                                                                    |
| SUBSTRING(str,start,len) | return string where start in `start` index,length is `len` in str                  |

1. grammar
   ```sql
   SELECT functionName()
   ```

### Number function

| function name | function desc                                                     |
| ------------- | ----------------------------------------------------------------- |
| CEIL(x)       | Rounded up                                                        |
| FLOOR(x)      | Rounded down                                                      |
| MOD(x)        | Returns the modulus of x/y                                        |
| RAND()        | Returns random number between 0 and 1                             |
| ROUND(x,y)    | Find the rounded value of parameter x, retaining y decimal places |

### date function

| function name                      | function desc                                     |
| ---------------------------------- | ------------------------------------------------- |
| CURDATE()                          | return current date                               |
| CURTIME()                          | return current time                               |
| NOW()                              | return current date and time                      |
| YEAR(date)                         | get year of date                                  |
| MONTH(date)                        | get month of date                                 |
| DAY(date)                          | get day of date                                   |
| DATE_ADD(date, INTERVAL expr type) | return a date/time what date add a time span expr |
| DATEDIFF(date1, date2)             | return a date/time between date1 and date2        |

### flow function

| function name                                              | function desc                                                            |
| ---------------------------------------------------------- | ------------------------------------------------------------------------ |
| IF(value,t,f)                                              | if value is true, return t,otherwise f                                   |
| IF NULL(value1,value2)                                     | if value1 is null, return value1,otherwise value2                        |
| CASE WHEN [val1] THEN [res1] ... ELSE [default] END        | if val1 is true, returen res1,...otherwise return default value          |
| CASE [expr] WHEN [val1] THEN [res1] ... ELSE [default] END | if expr is equal to val1, returen res1,...otherwise return default value |

## constraint

ensure that rules defined at data model creation are enforced when the data is manipulated ( inserted, updated, or deleted) in a database

### type

| constraint  | desc                                                                            | keyword     |
| ----------- | ------------------------------------------------------------------------------- | ----------- |
| NOT NULL    | data can not be null                                                            | NOT NULL    |
| UNIQUE      | data is unique,no repeat                                                        | UNIQUE      |
| PRIMARY KEY | A combination of a NOT NULL and UNIQUE. Uniquely identifies each row in a table | PRIMARY KEY |
| DEFAULT     | Sets a default value for a column if no value is specified                      | DEFAULT     |
| CHECK       | Ensures that the values in a column satisfies a specific condition              | CHECK       |
| FOREIGN KEY | Prevents actions that would destroy links between tables                        | FOREIGN KEY |

1. example

   | column | column desc | column type | constraint                 | constraint keyword          |
   | ------ | ----------- | ----------- | -------------------------- | --------------------------- |
   | id     | id unique   | int         | primary key, auto increase | PRIMARY KEY, AUTO_INCREMENT |
   | name   | name        | varchar(10) | not null, unique           | NOT NULL, UNIQUE            |
   | age    | age         | int         | > 0 and <= 120             | CHECK                       |
   | status | status      | char(1)     | not value, set 1           | DEFAULT                     |
   | gender | gender      | char(1)     | no                         |                             |

2. foreign key constraint

   1. add foreign key

      ```sql
      CREATE TABLE tableName (
         column column type,
         ...
         [CONSTRAINT] [foreignKeyName] FOREIGN KEY(foreignKey column) REFERENCES mainTable(mainTable columnName);
      );

      ALTER TABLE tableName ADD CONSTRAINT foreignKeyName FOREIGN KEY(foreignKey column) REFERENCES mainTable(mainTable columnName);
      ```

   2. remove foreign key
      ```sql
      ALTER TABLE tableName DROP FOREIGN KEY foreignKeyName;
      ```
   3. foreign key action

      1. delete/update action
         |action|desc|
         |----|----|
         |NO ACTION|If there are any existing references to the key being updated, the transaction will fail at the end of the statement.|
         |RESTRICT|If there are any existing references to the key being updated, the transaction will fail at the end of the statement.|
         |CASCADE|When a referenced foreign key is deleted or updated, all rows referencing that key are deleted or updated, respectively.|
         |SET NULL|When a referenced foreign key is deleted or updated, respectively, the columns of all rows referencing that key will be set to NULL|
         |SET DEFAULT|When a referenced foreign key is deleted or updated, the columns of all rows referencing that key are set to the default value for that column.|
      2. grammar
         ```sql
         ALTER TABLE tableName ADD CONSTRAINT foreignKeyName FOREIGN KEY (column) REFERENCES mainTable(mainTale columnName) ON UPDATE CASCADE ON DELETE CASCAD;
         ```

## multiple table query

### multiple tables relationship

In a project, many tables have relationship, they are

1. one to more(more to one)
   1. example: many employee belong to a department
2. more to more
   1. example: students to course
3. one to one
   1. example: user to user information

### multiple tables query

blends together information from two or more related tables.

### types

1.  inner join: Returns records that have matching values in both tables.
    1. hidden inner join:
       ```sql
       SELECT columns FROM table1,table2 WHERE conditions...;
       ```
    2. inner join:
       ```sql
       SELECT columns FROM table1 [INNER] JOIN table2 ON conditions...;
       ```
2.  outer join
    1. left join: Returns all records from the left table, and the matched records from the right table
       ```sql
       SELECT colums FROM table1 LEFT [OUTER] JOIN table2 ON conditions...;
       ```
    2. right join: Returns all records from the right table, and the matched records from the left table
       ```sql
       SELECT colums FROM table1 RIGHT [OUTER] JOIN table2 ON conditions...;
       ```
3.  self join:
    ```SQL
    SELECT columns FROM table1 aliasA JOIN table2 aliasB ON conditions...;
    ```
4.  subquery

### union, union all

union query, combine multiple query result to a new result.

```sql
SELECT columns FROM table1,...
UNION [ALL]
SELECT columns FROM table2,...;
```

`UNION ALL` is directly union all data, `UNION` is union data and distinct. The number of query result's columns must be the same, and columns also.

### subquery

a query within a query, nest query.

```sql
SELECT * FROM table1 WHERE column1 = (SELECT column1 FROM table2);
```

1. types:

   1. return result

      1. return single value, usually uses `=,>=,<=,<` and so on.
      2. return a column,could be multiple rows, usually uses `IN, NOT IN, ANY, SOME, ALL` and so on.
         |operator|desc|
         |----|----|
         |IN||
         |NOT IN||
         |ANY|match anyone is ok in return list|
         |SOME|the same as ANY|
         |ALL|must match everyone in return list|
      3. return a rows,multiple columns, usually uses `=,<>,IN, NOT IN`.
         ```sql
         # find the employee of the salary and manager is equal to 'tom'
         SELECT * FROM emp where (salary,managerid) = (SELECT salary,managerid FROM emp WHERE name='tom');
         ```
      4. return multiple rows and columns,usually uses `IN`.

         ```sql
         # find employ of job and salary is equal to 'tom' and 'jerry'
         # SELECT job, salary FROM emp where name = 'tom' and 'jerry'
         SELECT * FROM emp e WHERE (job, salary) IN (SELECT job, salary FROM emp where name = 'tom' and 'jerry');

         # find employee what entrydate is bigger than '2006-01-01' and their department.

         # SELECT * FROM emp WHERE entrydate > 2006-01-01

         SELECT e.*,d.* FROM (SELECT * FROM emp WHERE entrydate > 2006-01-01) e LEFT JOIN dept d ON e.dept_id = d.id;
         ```

   2. subquery position
      1. after where
      2. after from
      3. after select

## transact

a transaction is a sequence of one or more SQL statements that are executed as a single unit of work. they all success or all fail at the same time.

### transaction operation

1.  method1
    1. show/set transaction summit type
       ```sql
       SELECT @@autocommit;
       SET @@autocommit=0;
       ```
    2. submit transaction
       ```sql
       COMMIT
       ```
    3. rollback transaction
       ```sql
       ROLLBACK;
       ```
2.  method2
    1. start transaction
       ```sql
       START TRANSACTION or BEGIN;
       ```
    2. commit transaction
       ```sql
       COMMIT;
       ```
    3. rollback transaction
       ```sql
       ROLLBACK;
       ```

### transaction feature

1. Atomicity : all statements or operations within the transaction unit must be executed successfully. Otherwise, if any operation is failed, the whole transaction will be aborted,and it goes rolled back into their previous state.
2. Consistency:the database changes state only when a transaction will be committed successfully.
3. Isolation:each operation in the transaction unit operated independently.
4. Durability:the result of committed transactions persists permanently even if the system crashes or failed.

### concurrent transaction

Concurrency is a situation that arises in a database due to the transaction process. Concurrency occurs when two or more than two users are trying to access the same data or information

#### concurrent problems

if one transaction update data but not commit transaction, at the same time, another transaction read or update data. In this case will lead to problems.

1. dirty read: This problem occurs when another process reads the changed, but uncommitted data. For instance, if one process has changed data but not committed it yet, another process is able to read the same data. This leads to the inconsistent state for the reader.
2. Non-repeatable Reads: This problem occurs when one process is reading the data, and another process is writing the data. In non-repeatable reads, the first process reading the value might get two different values, as the changed data is read a second time because the second process changes the data.
3. Phantom read: If two same queries executed by two users show different output, then it would be a Phantom Read problem.

### transaction isolation

to solve these concurrent transaction problems, MyQql uses isolation to do.

| isolation level          | dirty read | Non-repeatable Reads | Phantom read | desc                                |
| ------------------------ | ---------- | -------------------- | ------------ | ----------------------------------- |
| READ uncommitted         | yes        | yes                  | yes          | performance best, data safety worst |
| READ committed           | no         | yes                  | yes          |                                     |
| Repeatable Read(default) | no         | no                   | yes          |                                     |
| Serializable             | no         | no                   | no           | performance worst, data safety best |

1. show、set isolation

   ```sql
   # show
   SELECT @@TRANSACTION_ISOLATION;

   # set
   SELECT [SESSION|GLOBAL] TRANSACTION ISOLATION LEVEL [READ UNCOMMITED |READ COMMITED |REPEATABLE READ|SERIALIZABLE]
   ```

# ending

[video](https://www.bilibili.com/video/BV1Kr4y1i7ru/?vd_source=d71377f649cfc8d319aa45ec353a83f5)
p57
