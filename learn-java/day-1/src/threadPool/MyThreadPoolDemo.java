package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
  public static void main(String[] args) {
	// 1. 创建线程池
	//ExecutorService pool1 = Executors.newCachedThreadPool(); // 创建没有上限的线程池
	ExecutorService pool2 = Executors.newFixedThreadPool(2); // 创建有上限的线程池

	// 2. 提交任务
	pool2.submit(new MyRunable());
	pool2.submit(new MyRunable());
	pool2.submit(new MyRunable());
	pool2.submit(new MyRunable());
	pool2.submit(new MyRunable());
	pool2.submit(new MyRunable());

	// 3. 销毁线程池
	//pool1.shutdown();
  }
}
