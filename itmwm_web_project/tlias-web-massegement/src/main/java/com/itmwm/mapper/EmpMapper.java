package com.itmwm.mapper;

import com.itmwm.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
  //@Select("select count(*) total from emp")
  //public Long count();

  //@Select("select id, username, password, name, gender, " +
  //        "image, job, entrydate, dept_id, create_time, update_time " +
  //        "from emp " +
  //        "limit #{start}, #{pageSize}")
  //public List<Emp> page(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("name") String name, @Param("gender") Short gender, @Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime);

  public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime);

  public void delete(@Param("ids") List<Integer> ids);

  @Insert("insert into " +
          "emp(username, name, gender, image, job, entrydate, " +
          "dept_id, create_time, update_time) values " +
          "(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}," +
          " #{deptId}, #{createTime}, #{updateTime})")
  public void insert(Emp emp);

  @Select("select " +
          "id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
          "from emp where id = #{id}")
  public Emp getById(@Param("id") Integer id);

  public void update(Emp emp);

  @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
          "from emp where username = #{username} and password = #{password}")
  public Emp getByUsernameAndPassword(Emp emp);

  /**
   * 根据部门id删除员工数据
   * @param id 部门id
   */
  @Delete("delete from emp where dept_id = #{id}")
  public void deleteByDeptId(Integer id);
}
