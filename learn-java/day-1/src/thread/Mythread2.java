package thread;

public class Mythread2 implements Runnable {
  @Override
  public void run() {
	Thread t = Thread.currentThread();
	for (int i = 0; i < 100; i++) {
	  System.out.println(t.getName() + "Hello world");
	}
  }
}
