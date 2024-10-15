package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
	// TCP协议, 发送数据
	// 创建 Socket 对象
	try (Socket s = new Socket("127.0.0.1", 10086);) {
	  String str = "你好, 世界";
	  byte[] bytes = str.getBytes();
	  OutputStream os = s.getOutputStream();
	  os.write(bytes);
	  s.shutdownOutput(); // 接收标记
	  s.close();
	}
  }
}
