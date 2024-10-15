package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
	// 创建 ServerSocket 对象
	try (ServerSocket ss = new ServerSocket(10086);) {
	  // 等待客户端连接
	  Socket socket = ss.accept();

	  // 获取输入流
	  InputStream is = socket.getInputStream(); // 字节流
	  InputStreamReader isr = new InputStreamReader(is); // 字符流
	  BufferedReader br = new BufferedReader(isr); // 缓存流
	  StringBuilder sb = new StringBuilder();
	  int b;
	  while ((b = br.read()) != -1) {
		sb.append((char) b);
	  }
	  System.out.println(sb.toString());
	  socket.close();
	  ss.close();
	}
  }
}
