package com.scw.test1;

public class Constructor {

  private String name;

  private int age;

  private char sex;

  // 通常编写对象时 都会写带参的构造函数以及不带参的构造函数 简称重载

  // 构造函数 不带参
  public Constructor () {
	System.out.println("执行了无参的构造函数");
  }

  // 构造函数 带参
  public Constructor(String name, int age, char sex) {
	System.out.println("执行了有参的构造函数");
	this.name = name;
	this.age = age;
	this.sex = sex;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getName() {
	return this.name;
  }
}
