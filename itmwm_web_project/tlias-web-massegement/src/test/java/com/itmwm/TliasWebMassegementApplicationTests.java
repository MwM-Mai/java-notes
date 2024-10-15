package com.itmwm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class TliasWebMassegementApplicationTests {

  @Autowired
  private ApplicationContext applicationContext; // ioc 容器对象

  @Test
  void contextLoads() {
  }

  /**
   * 测试jwt令牌的生成
   */
  @Test
  public void textGenJwt() {
	Map<String, Object> clamis = new HashMap<>();
	clamis.put("id", "123456");
	clamis.put("name", "coderwhy");
	String jwt = Jwts.builder()
			.signWith(SignatureAlgorithm.HS256, "itmwm") // 指定jwt数字签名算法
			.setClaims(clamis) // 自定义数据
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // jwt令牌有效期设置
			.compact();
	System.out.println(jwt);
  }

  //@Test
  //public void testParseJwt() {
	//Claims claims;
	//claims = Jwts.parser()
	//		.setSigningKey("itmwm")
	//		.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiY29kZXJ3aHkiLCJpZCI6IjEyMzQ1NiIsImV4cCI6MTcyODM4Mzg3MX0.ZIAqmmOw8VwoPUEwkA9ps6x-dZIhduBargOWgHPZzTc")
	//		.getBody();
	//System.out.println(claims);
  //}
}
