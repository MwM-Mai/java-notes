package obj;

import java.util.Arrays;
import java.util.Objects;

public class User implements Cloneable {
  private String name;

  private int id;

  private int[] data;

  public User(String name, int id, int[] data) {
	this.name = name;
	this.id = id;
	this.data = data;
  }

  public User() {
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public int[] getData() {
	return data;
  }

  public void setData(int[] data) {
	this.data = data;
  }

  // 重写toString
  @Override
  public String toString() {
	return "User{" +
			"name='" + name + '\'' +
			", id=" + id +
			", data=" + Arrays.toString(data) +
			'}';
  }

  // 重写比较 比较的是 obj 的内容
  @Override
  public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	User user = (User) o;
	return id == user.id && Objects.equals(name, user.name) && Arrays.equals(data, user.data);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
	// 调用父类中的clone方法
	return super.clone();
  }
}
