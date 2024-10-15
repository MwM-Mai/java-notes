package UDP;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
  public static void main(String[] args) throws SocketException {
	// 创建对象(快递公司)
	// new DatagramSocket() 空参构造 在随机一个端口进行发送 有参构造 指定端口进行发送
	try (DatagramSocket ds = new DatagramSocket()) {
	  String str = "hello world";
	  byte[] bytes = str.getBytes();
	  InetAddress ia = InetAddress.getByName("127.0.0.1");
	  int port = 10086;
	  // 打包数据
	  DatagramPacket dp = new DatagramPacket(bytes, bytes.length, ia, port);
	  ds.send(dp);
	  ds.close();
	} catch (IOException e) {
	  throw new RuntimeException(e);
	}
  }
}
