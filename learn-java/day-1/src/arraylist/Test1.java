package arraylist;

import java.util.ArrayList;
import java.util.Random;

public class Test1 {
  public static void main(String[] args) {
	// 1. 创建集合
	// 无法添加 基本数据类型  必须要把基本数据类型转换成包装类
	ArrayList<Integer> IList = new ArrayList<>();

	// 在 jdk 1.5 中  Integer 之间可以互相转换
	IList.add(1);
	IList.add(22);
	System.out.println(IList);
  }
}
