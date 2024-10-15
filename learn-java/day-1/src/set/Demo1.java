package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo1 {
  public static void main(String[] args) {
	Set<String> s = new HashSet<>();
	s.add("aaa");
	s.add("bbb");
	Iterator<String> it = s.iterator();
	while (it.hasNext()) {
	  System.out.println(it.next());
	}
	System.out.println(s);
  }
}
