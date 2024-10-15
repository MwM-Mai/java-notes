package com.scw.test1;

// StringBuilder 对象用于多字符串相加以及字符串反转 返回的是 StringBuilder 容器对象 获取字符串 .toString()方法
public class StringBuilderDemo {

  public static void main(String[] args) {
	StringBuilder sb = new StringBuilder("coderwhy");

	sb.append("1");
	sb.append(true);
	sb.reverse();

	System.out.println(sb.toString());  // 转换为字符串
  }
}
