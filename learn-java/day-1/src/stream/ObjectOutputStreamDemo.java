package stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// 序列化溜  obj对象写入到io流中
public class ObjectOutputStreamDemo {
  public static void main(String[] args) throws IOException {
	// 1. 创建对象
    Student stu = new Student("coderwhy", 18);

    // 2. 创建序列化流对象/对象操作输出流
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day-1\\src\\stream\\obj_out_stream.txt"));

    oos.writeObject(stu);

    oos.close();
  }
}
