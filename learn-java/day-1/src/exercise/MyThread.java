package exercise;

import java.math.BigDecimal;
import java.util.Random;

public class MyThread extends Thread{
	static BigDecimal money = BigDecimal.valueOf(100);

	static int count = 3;

	static final BigDecimal MIN = BigDecimal.valueOf(0.01);

  @Override
  public void run() {
	synchronized (MyThread.class) {
	  if(count == 0) {
		System.out.println("红包已被抢完");
		return;
	  } else {
		double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
		Random r = new Random();
		double v = r.nextDouble(bounds);
		double min = Math.max(v, MIN.doubleValue());
		min = count == 1 ?  money.doubleValue() : min;
		min = Double.parseDouble(String.format("%.2f", min));
		System.out.println("抢到红包" + min + "元");
		money =  money.subtract(BigDecimal.valueOf(min));
		count --;
	  }
	}
  }
}
