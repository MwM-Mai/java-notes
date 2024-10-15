package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
  public static void main(String[] args) throws IOException {
	// 参数二 是否书写
	FileOutputStream fos = new FileOutputStream("day-1\\src\\stream\\a.txt", true);
	String str = "abc-def";
	byte[] bytes = str.getBytes();
	fos.write(bytes);

	// 换行
	String wrap = "\r\n";
	byte[] bytes1 = wrap.getBytes();
	fos.write(bytes1);

	String _666 = "666";
	byte[] bytes2 = _666.getBytes();
	fos.write(bytes2);

	fos.close(); // 释放资源
  }
}
