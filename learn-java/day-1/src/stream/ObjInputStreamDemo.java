package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjInputStreamDemo {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
	ObjectInputStream ojs = new ObjectInputStream(new FileInputStream("day-1\\src\\stream\\obj_out_stream.txt"));
  	Student stu = (Student) ojs.readObject();
	System.out.println(stu);
	ojs.close();
  }
}
