package com.aliyun.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data // 注解会自动加上get/set方法
@ConfigurationProperties(prefix = "aliyun.oss") // 配置文件属性自动注入
public class AliOSSProperties {
  private String endpoint;
  private String accessKeyId;
  private String accessKeySecret;
  private String bucketName;

}
