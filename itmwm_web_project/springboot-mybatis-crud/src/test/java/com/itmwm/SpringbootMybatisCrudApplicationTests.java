package com.itmwm;

import com.itmwm.mapper.EmpMapper;
import com.itmwm.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

  @Autowired
  private EmpMapper empMapper;

  @Test
  void contextLoads() {
	//int id = empMapper.delete(17);
	//System.out.println("id:" + id);
	//Emp emp = new Emp();
	//emp.setId(20);
	//emp.setName("coderwhy3");
	//emp.setImage("4.png");
	//emp.setGender((short) 3);
	//emp.setUsername("corderwhy2");
	//emp.setJob((short) 3);
	//emp.setDeptId(1);
	//emp.setEntrydate(LocalDate.now());
	//emp.setUpdateTime(LocalDateTime.now());
	//
	//empMapper.update(emp);


	//Emp emp = empMapper.getById(20);
	//System.out.println(emp.toString());
	//List<Emp> list = empMapper.getList("张", (short) 1,
	//		LocalDate.of(2010, 1, 1),
	//		LocalDate.of(2020, 1, 1));
	//List<Emp> list = empMapper.getList("张", null, null, null);
	//List<Emp> list = empMapper.getList("张",null, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
	//list.forEach(item -> {
	//  System.out.println(item.toString());
	//});

	//List<Integer> ids = Arrays.asList(13, 14, 15);
    //empMapper.deleteByIds(ids);
  }

}
