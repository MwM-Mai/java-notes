package stream;

import java.io.*;
import java.nio.charset.Charset;

public class ConverStreamDemo1 {
  public static void main(String[] args) throws IOException {
    //InputStreamReader isr = new InputStreamReader(new FileInputStream("day-1\\src\\stream\\GBK.txt"), "GBK");
    //int ch;
    //while ((ch = isr.read()) != -1) {
    //  System.out.println((char) ch);
    //}
    //
    //isr.close();

    FileReader fr = new FileReader("day-1\\src\\stream\\GBK.txt", Charset.forName("GBK"));
    int ch;
    while ((ch = fr.read()) != -1) {
      System.out.println((char) ch);
    }

    fr.close();
  }
}
