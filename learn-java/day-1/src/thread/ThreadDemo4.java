package thread;

public class ThreadDemo4 {
  public static void main(String[] args) {
	Cook c = new Cook();
	Guest g = new Guest();


	c.start();
	g.start();
  }
}
