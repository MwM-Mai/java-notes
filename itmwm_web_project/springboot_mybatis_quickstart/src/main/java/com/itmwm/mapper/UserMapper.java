package com.itmwm.mapper;

import com.itmwm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
  @Select(value = "select * from user")
  public List<User> list();
}
