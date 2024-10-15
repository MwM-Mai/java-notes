package stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferStramDemo1 {
  public static void main(String[] args) throws IOException {
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day-1\\src\\stream\\a.txt"));
	int b;
	while ((b = bis.read()) != -1) {
	  System.out.println((char) b);
	}
  }
}
