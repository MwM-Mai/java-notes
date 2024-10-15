package arraylist;

import java.util.ArrayList;


// 集合类 无法添加 基本数据类型  必须要把基本数据类型转换成包装类才行
// string 是一个类 源码中 是通过 new String(); 实现的 与 js 有区别
public class ArrayListDemo1 {
  public static void main(String[] args) {
	// 1. 创建集合的对象 <> 为泛型 类似ts 的泛型
	ArrayList<String> list = new ArrayList<>();

	list.add("123");
	list.add("123");
	list.add("456");
	list.add("789");
	list.add("asd");
	
	list.remove(0);
	
	System.out.println(list);
	System.out.println(list.size());
	System.out.println(list.get(0));

	for (String s : list) {
	  System.out.println(s);
	}

	list.add(2, "插入值");
	System.out.println(list);
  }
}
