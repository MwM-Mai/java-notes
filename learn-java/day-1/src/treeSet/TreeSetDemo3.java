package treeSet;

import java.util.TreeSet;

public class TreeSetDemo3 {
  public static void main(String[] args) {
	TreeSet<String> ts = new TreeSet<>((o1, o2) -> {
	  int i = o1.length() - o2.length();
	  i = i == 0 ? o1.compareTo(o2) : i; // 两个长度相等 调用默认的比较方法
	  return i;
	});
	ts.add("c");
	ts.add("ab");
	ts.add("df");
	ts.add("qwer");

	System.out.println(ts);
  }
}
