package com.itmwm.service;

import com.itmwm.pojo.Dept;

import java.util.List;

public interface DeptService {
  /**
   * 查询全部部门数据
   * @return DeptMapper
   */
  List<Dept> list();

  /**
   * 根据id删除部门
   */
  public void deleteById(Integer id);

  public void add(Dept dept);

  public Dept getById(Integer id);

  Dept updateById(Dept obj);
}
