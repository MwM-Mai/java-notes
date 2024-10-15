package reflect;

public class Student {
  String name;
  int age;
  char sex;

  public Student() {
  }

  private Student(String name, int age, char sex) {
	this.name = name;
	this.age = age;
	this.sex = sex;
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

  /**
   * 获取
   * @return sex
   */
  public char getSex() {
	return sex;
  }

  /**
   * 设置
   * @param sex
   */
  public void setSex(char sex) {
	this.sex = sex;
  }

  public String toString() {
	return "Student{name = " + name + ", age = " + age + ", sex = " + sex + "}";
  }
}
