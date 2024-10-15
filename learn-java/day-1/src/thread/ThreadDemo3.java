package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
	/**
	 * 多线程的第三种实现方式
	 * 特点: 可以获取到多线程的结果
	 * 1. 创建一个类MyCallable实现Callable接口
	 * 2. 重写 call (是有返回值的, 表示多线程运行的结果)
	 *
	 * 3. 创建MyCallable对象(便是对现场要执行的任务)
	 * 4. 创建FutureTask对象(作用管理多线程运行的结果)
	 * 5. 创建Thread对象 并且启动线程
	 */

	MyCallable mc = new MyCallable();
	FutureTask<Integer> i = new FutureTask<Integer>(mc);
	Thread t = new Thread(i);
	t.start();
	Integer i1 = i.get();
	System.out.println(i1); 
  }
}
