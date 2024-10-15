package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyReflectDemo2 {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
	Class<?> clazz = Class.forName("reflect.Student");

	// 获取私有构造函数
	Constructor<?> con = clazz.getDeclaredConstructor(String.class, int.class, char.class);

	con.setAccessible(true); // 允许临时访问私有变量 否则 通过私有构造函数创建对象会报错
	// 通过私有构造函数创建对象
	Student s = (Student) con.newInstance("coderWhy", 18, '男');
	System.out.println(s.toString());
  }
}
