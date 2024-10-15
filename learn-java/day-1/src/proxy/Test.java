package proxy;

public class Test {
  public static void main(String[] args) {
	/*
		需求:
			外面的人想要鸡哥唱一首歌
			1. 获取代理的对象
				代理对象 = ProxyUtil.createProxy(鸡哥的对象)
			2. 再调用代理的唱歌方法
				代理对象.唱歌的方法("只因你太美")
	 */

	// 1. 获取代理的对象
	Jige jige = new Jige();
	Start proxy = ProxyUtil.createProxy(jige);

	// 2. 调用唱歌的方法
	String result = proxy.sing("只因你太美");
	System.out.println(result);
  }
}
