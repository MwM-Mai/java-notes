package arraylist;

import java.util.ArrayList;

public class Test2 {
  public static void main(String[] args) {
	ArrayList<Student> list = new ArrayList<>();

	Student s1 = new Student("coderwhy", 18);
	Student s2 = new Student("james", 39);

	list.add(s1);
	list.add(s2);

	System.out.println(list);
  }
}
