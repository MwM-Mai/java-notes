package thread;

public class Cook extends Thread {

  @Override
  public void run() {
	while (true) {
	  synchronized (Desk.obj) {
		if (Desk.count == 0) {
		  break;
		} else {
		  if (Desk.foodFlag == 1) {
			try {
			  Desk.obj.wait();
			} catch (InterruptedException e) {
			  throw new RuntimeException(e);
			}
		  } else {
			System.out.println("我做了" + (10 - Desk.count + 1) + "碗");
			Desk.foodFlag = 1;
			Desk.obj.notifyAll();
		  }
		}
	  }
	}
  }
}
