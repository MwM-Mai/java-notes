package com.itmwm.controller;

import com.itmwm.anno.Log;
import com.itmwm.pojo.Dept;
import com.itmwm.pojo.Result;
import com.itmwm.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // 注入 会自动定义 日志对象 log
@RestController
@RequestMapping("/depts") // 公共路径抽取到类注入
public class DeptController {

  // 需要调用 service 类的方法 注入(@Autowired) deptService 接口实现类
  @Autowired
  private DeptService deptService;

  /**
   * 查询部门数据
   * @return
   */
  @GetMapping
  public Result list() {
	log.info("查询全部部门数据");
	// 调用service查询部门数据
	List<Dept> deptList = deptService.list();
	return Result.success(deptList);
  }

  /**
   * 删除部门数据
   * @param id 部门id
   */
  @Log
  @DeleteMapping("/{id}")
  public Result list(@PathVariable Integer id) {
	log.info("根据id删除部门数据:{}", id);
	// 调用删除部门
	deptService.deleteById(id);
	return Result.success();
  }

  /**
   * 添加部门数据
   */
  @Log
  @PostMapping
  public Result add(@RequestBody Dept dept) {
	log.info("添加部门数据:{}",dept);
	deptService.add(dept);
	return Result.success();
  }

  @GetMapping("/{id}")
  public Result getById(@PathVariable Integer id) {
	log.info("根据id查询部门:{}",id);
	Dept dept = deptService.getById(id);
	return Result.success(dept);
  }

  @Log
  @PutMapping()
  public Result updateById(@RequestBody Dept obj) {
	log.info("根据id修改部门:{}", obj);
	Dept dept = deptService.updateById(obj);
	return Result.success(dept);
  }
}
