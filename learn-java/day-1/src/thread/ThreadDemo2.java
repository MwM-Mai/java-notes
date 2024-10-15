package thread;

public class ThreadDemo2 {
  public static void main(String[] args) {
    /**
     * 多线程的第二种启动方法
     * 1. 自定义类实现Runable接口
     * 2. 重写run方法
     * 3. 创建自定义类对象
     * 4. 创建一个Thread对象,并开启线程
     */

    Mythread2 mr = new Mythread2(); // 表示多线程要执行的任务
    Thread t1 = new Thread(mr);
    Thread t2 = new Thread(mr);

    t1.setName("线程1");
    t2.setName("线程2");

    t1.start();
    t2.start();
  }
}
