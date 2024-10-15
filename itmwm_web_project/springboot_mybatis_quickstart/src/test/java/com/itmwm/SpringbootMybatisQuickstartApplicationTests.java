package com.itmwm;

import com.itmwm.mapper.UserMapper;
import com.itmwm.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  void contextLoads() {
    List<User> list = userMapper.list();
    list.forEach(user -> {
      System.out.println(user.toString());
    });
  }

}
