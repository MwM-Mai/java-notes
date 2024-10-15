package com.itmwm.service.impl;

import com.itmwm.mapper.DeptMapper;
import com.itmwm.mapper.EmpMapper;
import com.itmwm.pojo.Dept;
import com.itmwm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

  private EmpMapper empMapper;

  //需要调用数据库的方法 注入 Mapper 接口实现类
  @Autowired
  private DeptMapper deptMapper;

  public List<Dept> list() {
	return deptMapper.list();
  }

  /*
  *  @Transactional  事务管理 运行没报错的后 会提交事务, 出现报错会事务回滚(恢复数据)
  *  rollbackFor 回滚属性 出现什么异常就回滚 rollbackFor = Exception.class 表示所有异常都回滚
  *  propagation 传播行为, 一个事务方法被另一个事务方法调用时,这个事务方法一个如何处理
  */
  @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED) // 所有的异常都事务回滚
  public void deleteById(Integer id) {
    deptMapper.deleteById(id);

    empMapper.deleteByDeptId(id);
  }

  public void add (Dept dept) {
    dept.setCreateTime(LocalDateTime.now());
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.insert(dept);
  }

  public Dept getById(Integer id) {
    return deptMapper.getById(id);
  }

  public Dept updateById(Dept dept) {
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.updateById(dept);
    return this.getById(dept.getId());
  }
}
