package array_search;

public class Demo2<T> {
  Object[] obj = new Object[10];
  int size;

  public <E> boolean add(T e) {
	obj[size] = e;
	size ++;
	return true;
  }

  public T get(int index) {
	return (T)obj[index];
  }
}
