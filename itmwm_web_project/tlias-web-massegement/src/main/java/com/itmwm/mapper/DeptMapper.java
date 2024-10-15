package com.itmwm.mapper;

import com.itmwm.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
  /**
   * 查询全部部门数据
   * @return List
   */
  @Select("select id, name, create_time, update_time from dept")
  public List<Dept> list();

  /**
   * 根据id删除部门
   * @param id 部门id
   */
  @Delete("delete from dept where id = #{id}")
  public void deleteById(Integer id);

  @Insert("insert into dept (name, create_time, update_time) " +
          "values (#{name}, #{createTime}, #{updateTime})")
  public void insert (Dept dept);

  @Select("select id, name, create_time, update_time from dept where id = #{id}")
  public Dept getById(Integer id);

  @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
  public void updateById(Dept dept);
}
