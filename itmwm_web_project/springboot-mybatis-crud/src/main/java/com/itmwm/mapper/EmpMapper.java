package com.itmwm.mapper;

import com.itmwm.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
  @Delete(value = "delete from emp where id = #{id}")
  public int delete(Integer id);

  @Options(keyProperty = "id", useGeneratedKeys = true) // 会自动将生成的主键值赋值给emp对象的id属性
  @Insert(value = "insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
		  "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
  public void inset(Emp emp);

  //@Update(value = "update emp set " +
	//	  "username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
  //public void update(Emp emp);


  public void update(Emp emp);

  @Select("select * from emp where id = #{id}")
  public Emp getById(Integer id);

  // concat 字符串拼接
  //@Select(value = "select * from emp where name like concat('%', #{name}, '%') and " +
	//	  "gender = #{gender} and entrydate between #{start} and #{end} " +
	//	  "order by update_time desc")
  //public List<Emp> getList(@Param("name") String name, @Param("gender") short gender, @Param("start") LocalDate start, @Param("end") LocalDate end);

  public List<Emp> getList(@Param("name") String name, @Param("gender") Short gender, @Param("start") LocalDate start, @Param("end") LocalDate end);


  public void deleteByIds(@Param("ids") List<Integer> ids );
}
