package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类的作用创建代理
 */
public class ProxyUtil {
  /**
   * 给对象创建一个代理
   *
   * @return 给鸡哥创建的代理
   */
  public static Start createProxy(Jige jige) {
	/*
	 * Proxy.newProxyInstance Proxy的静态方法创建代理
	 * 参数1: 用于指定用哪个类加载器, 去加载生成的代理类
	 * 参数2: 指定接口, 这些接口用于指定生成的代理长什么样, 也就是有哪些方法
	 * 参数3: 用来指定生成的代理对象要干什么事()
	 */
	return (Start) Proxy.newProxyInstance(
			ProxyUtil.class.getClassLoader(),
			new Class[]{Start.class},
			new InvocationHandler() {
			  @Override
			  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				/*
				 * 参数1: 代理的对象
				 * 参数2: 要运行的方法
				 * 参数3: 调用运行的方法传递的实参
				 * @re
				 */
				if ("sing".equals(method.getName())) {
				  System.out.println("准备话筒, 收钱");
				} else if ("dance".equals(method.getName())) {
				  System.out.println("准备场地, 收钱");
				}
				// 去找鸡哥唱歌或者跳舞
				// 代码的表现形式, 调用鸡哥里面的唱歌或者跳舞的方法
				return method.invoke(jige,args);
			  }
			}
	);
  }
}
