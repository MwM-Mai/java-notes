package obj;

public class Clone {
  public static void main(String[] args) throws CloneNotSupportedException {
	int[] data = {1, 2, 3, 4, 5, 6, 7};
	User u1 = new User("zhangsan", 1, data);
	System.out.println(u1.clone());
  }
}
