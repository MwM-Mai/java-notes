package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class ReceiveMessageDemo {
  public static void main(String[] args) throws IOException {
	// 接收数据
	DatagramSocket ds = new DatagramSocket(10086);
	byte[] bytes = new byte[1024];
	DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
	// 接收数据包
	ds.receive(dp);
	System.out.println(new String(bytes));
	ds.close();
  }
}
