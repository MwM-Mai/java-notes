package com.itmwm.service;

import com.itmwm.pojo.Emp;
import com.itmwm.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

  public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate startTime, LocalDate endTime);

  public void delete(List<Integer> ids);

  public void save(Emp emp);

  public Emp getById(Integer id);

  public void update(Emp emp);

  public Emp login(Emp emp);
}
