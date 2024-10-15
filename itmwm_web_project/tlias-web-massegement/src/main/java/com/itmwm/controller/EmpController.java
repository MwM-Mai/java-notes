package com.itmwm.controller;

import com.itmwm.anno.Log;
import com.itmwm.pojo.Emp;
import com.itmwm.pojo.PageBean;
import com.itmwm.pojo.Result;
import com.itmwm.service.EmpService;
import com.itmwm.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

  @Autowired
  private EmpService empService;

  @GetMapping("")
  public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startTime, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime) {
	log.info("{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, startTime, endTime);
	PageBean pages = empService.page(page, pageSize, name, gender, startTime, endTime);
	return Result.success(pages);
  }

  @Log
  @DeleteMapping("/{ids}")
  public Result delete(@PathVariable List<Integer> ids) {
	log.info("批量删除操作, ids: {}", ids);
	empService.delete(ids);
	return Result.success();
  }

  @Log
  @PostMapping("")
  public Result save(@RequestBody Emp emp) {
	log.info("新增员工的功能, emp: {}", emp);
	empService.save(emp);
	return  Result.success();
  }

  @GetMapping("/{id}")
  public Result getById(@PathVariable Integer id) {
	log.info("查询员工信息: {}", id);
	Emp emp = empService.getById(id);
	return Result.success(emp);
  }

  @Log
  @PutMapping("")
  public Result update(@RequestBody Emp emp) {
	log.info("修改员工信息: {}", emp);
	empService.update(emp);
	return Result.success();
  }
}
