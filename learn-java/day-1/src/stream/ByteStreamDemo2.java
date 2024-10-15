package stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamDemo2 {
  public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("day-1\\src\\stream\\a.txt");
	byte[] bytes = fis.readAllBytes();
	System.out.println(new String(bytes));
	fis.close();
  }
}
