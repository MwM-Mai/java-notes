package file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo1 {
  public static void main(String[] args) throws IOException {
	String path = "C:\\Users\\Administrator\\Desktop\\learn-java\\learn-java\\day-1\\src\\file\\aaa.txt";
	File file = new File(path);
	System.out.println(file.getName());
	boolean newFile = file.createNewFile();

	String path1 = "C:\\Users\\Administrator\\Desktop\\learn-java\\learn-java\\day-1\\src\\file\\aaa";
	File file1 = new File(path1);
	boolean newFile1 = file1.mkdir();

	boolean delete = file1.delete();

	String path2 = "C:\\Users\\Administrator\\Desktop\\learn-java\\learn-java\\day-1\\src\\file";
	File file2 = new File(path2);
	File[] files = file2.listFiles();
	if (files != null) {
	  for (File file3 : files) {
		System.out.println(file3);
	  }
	}
  }
}
