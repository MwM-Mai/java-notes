package treeSet;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Student implements Comparable<Student> {
  private String name;
  private int age;
  private int chinese;
  
  private int math;

  private int english;

  private int total;


  public Student() {
  }

  public Student(String name, int age, int chinese, int math, int english) {
	this.name = name;
	this.age = age;
	this.chinese = chinese;
	this.math = math;
	this.english = english;
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
   * 获取
   * @return total
   */
  public int getTotal() {
	return this.getChinese() + this.getMath() + this.getEnglish();
  }

  /**
   * 设置
   * @param age
   */
  public void setAge(int age) {
	this.age = age;
  }

  /**
   * 获取
   * @return chinese
   */
  public int getChinese() {
	return chinese;
  }

  /**
   * 设置
   * @param chinese
   */
  public void setChinese(int chinese) {
	this.chinese = chinese;
  }

  /**
   * 获取
   * @return math
   */
  public int getMath() {
	return math;
  }

  /**
   * 设置
   * @param math
   */
  public void setMath(int math) {
	this.math = math;
  }

  /**
   * 获取
   * @return english
   */
  public int getEnglish() {
	return english;
  }

  /**
   * 设置
   * @param english
   */
  public void setEnglish(int english) {
	this.english = english;
  }

  public String toString() {
	return "Student{name = " + name + ", age = " + age + ", chinese = " + chinese + ", math = " + math + ", english = " + english + ", total = " + this.getTotal() +"}";
  }

  @Override
  public int compareTo(@NotNull Student o) {
	if(this.getTotal() != o.getTotal()) return -(this.getTotal() - o.getTotal());
	if(this.getChinese() != o.getChinese()) return -(this.getChinese() - o.getChinese());
	if(this.getMath() != o.getMath()) return -(this.getMath() - o.getMath());
	if(this.getEnglish() != o.getEnglish()) return -(this.getEnglish() - o.getEnglish());
	if(this.getAge() != o.getAge()) return -(this.getAge() - o.getAge());
	if(!this.getName().equals(o.getName())) return this.getName().compareTo(o.getName());
	return 0;
  }
}
