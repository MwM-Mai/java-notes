package com.scw.test1;

public class User {
  private String username;
  private String password;

  private String sex;

  private String email;

  private int age;

  // 快捷键 一键生成 构造函数 以及set get 方法
  // alt + insert 或者 alt + fn + insert

  // 插件 PTG 1秒生成标准JavaBean(对象)类

  public User() {
  }

  public User(String username, String password, String sex, String email, int age) {
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.email = email;
    this.age = age;
  }

  /**
   * 获取
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * 设置
   * @param username 用户名
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * 获取
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置
   * @param password 密码
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取
   * @return sex
   */
  public String getSex() {
    return sex;
  }

  /**
   * 设置
   * @param sex 性别
   */
  public void setSex(String sex) {
    this.sex = sex;
  }

  /**
   * 获取
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * 设置
   * @param email 邮箱
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * 获取
   * @return age
   */
  public int getAge() {
    return age;
  }

  /**
   * 设置
   * @param age 年龄
   */
  public void setAge(int age) {
    this.age = age;
  }

  public String toString() {
    return "User{username = " + username + ", password = " + password + ", sex = " + sex + ", email = " + email + ", age = " + age + "}";
  }
}
