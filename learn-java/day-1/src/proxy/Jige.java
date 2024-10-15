package proxy;

public class Jige implements Start {


  public Jige() {
  }

  public String toString() {
	return "Jige{}";
  }

  @Override
  public String sing(String name) {
	System.out.println("正在唱" + name);
	return  "谢谢";
  }

  @Override
  public void dance() {
	System.out.println("正在跳舞");
  }
}
