package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert dept (name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept deptById(Integer id);
}
