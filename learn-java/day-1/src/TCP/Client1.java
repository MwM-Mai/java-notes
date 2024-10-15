package TCP;

import java.io.*;
import java.net.Socket;

public class Client1 {
  public static void main(String[] args) throws IOException {
	// 创建 socket 对象
	try(Socket socket = new Socket("127.0.0.1", 10086);) {
	  // 读取本地中的文件数据, 并写到服务器中
	  String url = "day-1\\src\\TCP\\client\\bac.jpg";
	  BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(url));// 缓冲流 否则读取大数据慢
	  OutputStream os = socket.getOutputStream(); // 这个字节输出流是一个字节一个字节写的 速度慢需要用到 缓冲流
	  BufferedOutputStream bos = new BufferedOutputStream(os);
	  bos.write(bis.readAllBytes());
	  socket.shutdownOutput();

	  // 接收服务器回写的数据
	  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	  System.out.println(br.readLine());
	  bis.close();
	  bos.close();
	  br.close();
	  socket.close();
	}

  }
}
