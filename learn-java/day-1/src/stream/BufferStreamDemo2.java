package stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferStreamDemo2 {
  public static void main(String[] args) throws IOException {
	BufferedReader br =  new BufferedReader(new FileReader("day-1\\src\\stream\\a.txt"));
	String line1 = br.readLine();
	String line2 = br.readLine();
	System.out.println(line1);
	System.out.println(line2);
  }
}
