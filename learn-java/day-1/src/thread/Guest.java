package thread;

public class Guest extends Thread {
  @Override
  public void run() {
	while (true) {
	  synchronized (Desk.obj) {
		if (Desk.count == 0) {
		  break;
		} else {
		  if (Desk.foodFlag == 0) {
			try {
			  Desk.obj.wait();
			} catch (InterruptedException e) {
			  throw new RuntimeException(e);
			}
		  } else {
			System.out.println("我吃了" + (10 - Desk.count + 1) + "晚");
			Desk.foodFlag = 0;
			Desk.count--;
			Desk.obj.notifyAll();
		  }
		}
	  }
	}
  }
}
