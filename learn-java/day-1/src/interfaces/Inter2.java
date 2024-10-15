package interfaces;

public interface Inter2 {
  public default void show() {
	System.out.println("show方法开始执行");
	show3();
  }

  public default void show2() {
	System.out.println("show方法开始执行");
	show3();
  }

  // 普通的私有方法 给默认的方法服务的
  private void show3() {
	System.out.println("哈哈哈哈哈");
  }

  // 静态的私有方法 给静态的方法服务的
  private static void show4() {
	System.out.println("哈哈哈哈哈");
  }
}
