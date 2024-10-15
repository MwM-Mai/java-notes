package stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ConverStreamDemo2 {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day-1\\src\\stream\\GBK.txt"), "GBK");
  }
}
