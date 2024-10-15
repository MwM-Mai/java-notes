package stream;

import java.io.Serial;
import java.io.Serializable;


/*
	Serializable: 没有抽象方法的,为标记接口
	一旦实现了这个接口,就表示当前的类可以被序列化
 */
public class Student implements Serializable {

  @Serial
  private static final long serialVersionUID = -4194303301558687406L;
  private String name;
  private int age;

  public Student() {
  }

  public Student(String name, int age) {
	this.name = name;
	this.age = age;
  }

  /**
   * 获取
   * @return name
   */
  public String getName() {
	return name;
  }

  /**
   * 设置
   * @param name
   */
  public void setName(String name) {
	this.name = name;
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
   * @param age
   */
  public void setAge(int age) {
	this.age = age;
  }

  public String toString() {
	return "Student{name = " + name + ", age = " + age + "}";
  }
}
