package reflect;

public class MyReflectDemo1 {
  public static void main(String[] args) throws ClassNotFoundException {
	/*
		获取class对象的三种方式
		1. Class.forName("全类名")
		2. 类名.class;
		3. 对象.getClass();
	 */

    // 方式1 常用
    Class<?> clazz = Class.forName("reflect.Student");
    System.out.println(clazz);

    // 方式2 当作参数进行使用
    Class<Student> clzz2 = Student.class;
    System.out.println(clzz2);

    System.out.println(clzz2.equals(clazz));

    // 方式3
    Student student = new Student();
    System.out.println(student.getClass());

  }
}
