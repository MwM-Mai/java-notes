package stream;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo2 {
  public static void main(String[] args) throws IOException {
	FileWriter fw = new FileWriter("day-1\\src\\stream\\a.txt");
	fw.write("你好, 世界!");
	fw.close();
  }
}
