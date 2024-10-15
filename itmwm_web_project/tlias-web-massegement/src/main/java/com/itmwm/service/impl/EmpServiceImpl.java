package com.itmwm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itmwm.mapper.EmpMapper;
import com.itmwm.pojo.Emp;
import com.itmwm.pojo.PageBean;
import com.itmwm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

  @Autowired
  private EmpMapper empMapper;

  public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate startTime, LocalDate endTime) {
	//Long count = empMapper.count();
	//List<Emp> emps = empMapper.page(page, pageSize, name, gender, start, end);

	// 使用 pagehelper 插件实现分页查询

	// 1. 设置分页参数
	PageHelper.startPage(page, pageSize);
	// 2. 执行正常的查询操作
	List<Emp> list = empMapper.list(name, gender, startTime, endTime);
	Page<Emp> p = (Page<Emp>) list;
	// 3. 封装 pageBean 对象
	return new PageBean(p.getTotal(), p.getResult());
  }

  public void delete(List<Integer> ids) {
	empMapper.delete(ids);
  }

  public void save(Emp emp) {
	emp.setCreateTime(LocalDateTime.now());
	emp.setUpdateTime(LocalDateTime.now());
	empMapper.insert(emp);
  }

  public Emp getById (Integer id) {
	return empMapper.getById(id);
  }

  public void update (Emp emp) {
	emp.setUpdateTime(LocalDateTime.now());
	empMapper.update(emp);
  }

  public Emp login (Emp emp) {
	return empMapper.getByUsernameAndPassword(emp);
  }
}
