package hutool;

import cn.hutool.core.io.FileUtil;

public class Test1 {
  public static void main(String[] args) {
	FileUtil.copyFile("day-1\\src\\commons\\a.txt", "day-1\\src\\hutool\\copy.txt");
  }
}
