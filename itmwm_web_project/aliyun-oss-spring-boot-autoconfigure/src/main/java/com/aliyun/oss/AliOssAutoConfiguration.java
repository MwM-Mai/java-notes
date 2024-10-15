package com.aliyun.oss;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliOSSProperties.class) // 将 AliOSSProperties 导入到ioc容器
public class AliOssAutoConfiguration {
  @Bean
  public AliOSSUtils aliOSSUtils(AliOSSProperties aliOSSProperties) {
	AliOSSUtils aliOSSUtils = new AliOSSUtils();
	aliOSSUtils.setAliOSSProperties(aliOSSProperties);
	return aliOSSUtils;
  }
}
