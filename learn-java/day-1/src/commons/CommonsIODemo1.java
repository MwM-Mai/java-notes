package commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommonsIODemo1 {
  public static void main(String[] args) throws IOException {
    File src = new File("day-1\\src\\commons\\a.txt");
    String s = FileUtils.readFileToString(src, StandardCharsets.UTF_8);
    System.out.println(s);
  }
}
