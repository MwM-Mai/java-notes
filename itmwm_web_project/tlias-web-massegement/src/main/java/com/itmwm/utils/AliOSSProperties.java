package com.itmwm.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data // 注解会自动加上get/set方法
@Component // 交给oc容器管理
@ConfigurationProperties(prefix = "aliyun.oss") // 配置文件属性自动注入
public class AliOSSProperties {
  private String endpoint;
  private String accessKeyId;
  private String accessKeySecret;
  private String bucketName;

}
