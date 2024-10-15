package exercise;

public class Test {
  public static void main(String[] args) {
	MyThread mt1 = new MyThread();
	MyThread mt2 = new MyThread();
	MyThread mt3 = new MyThread();
	MyThread mt4 = new MyThread();
	MyThread mt5 = new MyThread();

	mt1.start();
	mt2.start();
	mt3.start();
	mt4.start();
	mt5.start();
  }
}
