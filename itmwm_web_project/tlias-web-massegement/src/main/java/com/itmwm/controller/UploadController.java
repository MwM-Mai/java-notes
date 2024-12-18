package com.itmwm.controller;

import com.itmwm.pojo.Result;
import com.itmwm.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

  @Autowired
  private AliOSSUtils aliOSSUtils;

  // MultipartFile 文件类
  //@PostMapping("/upload")
  //public Result upload(String username, Integer age, MultipartFile image) throws IOException {
	//log.info("文件上传:{},{},{}", username, age, image);
  //
	//// 将文件存储在服务器的磁盘目录中 E:\images
	//String originalFilename = image.getOriginalFilename();
	//assert originalFilename != null;
	//int i = originalFilename.lastIndexOf("."); // 获取最后一个点的下标值
	//String extname = originalFilename.substring(i);
	//String uuid = UUID.randomUUID().toString();
	//String newFileName = uuid + extname;
	//log.info("获取文件名称: {}", originalFilename);
	//File directory = new File("E:\\images");
	//if(!directory.exists()) {
	//  directory.mkdirs();
	//}
	//image.transferTo(new File(directory, newFileName));
	//return Result.success();
  //}

  @PostMapping("/upload")
  public Result upload(MultipartFile image) throws IOException {
	log.info("文件上传, {}", image.getOriginalFilename());
	String url = aliOSSUtils.upload(image);
	log.info("文件上传完成,文件访问url为: {}", url);
	return Result.success(url);
  }
}
