package stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;

public class CharStreamDemo1 {
  public static void main(String[] args) throws IOException {
    //FileReader fr = new FileReader("day-1\\src\\stream\\a.txt");
    //int ch;
    //while ((ch = fr.read()) != -1) {
    //  System.out.println((char) ch);
    //}
    //
    //fr.close();

    FileReader fr = new FileReader("day-1\\src\\stream\\a.txt");
    char[] chars = new char[2];
    int len;
    while ((len = fr.read(chars)) != -1) {
      System.out.print(new String(chars, 0, len));
    }

    fr.close();

  }
}
