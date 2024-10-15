package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
  public static void main(String[] args) throws IOException {
	// 创建 ServerSocket 对象
	try(ServerSocket ss = new ServerSocket(10086);) {
	  Socket socket = ss.accept();  // 等待客户端连接
	  BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
	  BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day-1\\src\\TCP\\server\\bac.jpg"));
	  bos.write(bis.readAllBytes());
	  bos.flush();
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	  bw.write("上传成功");
	  bw.flush();
	  bis.close();
	  bos.close();
	  bw.close();
	  socket.close();
	}
  }
}
