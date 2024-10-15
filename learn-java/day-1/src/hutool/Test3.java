package hutool;

import cn.hutool.core.io.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 带权重的随机算法
public class Test3 {
  public static void main(String[] args) {
	// 1. 读取文件中的信息封装成对象并且放到集合中
	List<String> infoList = FileUtil.readLines("hutool\\info.txt", "utf-8");
	ArrayList<Student> studentList = new ArrayList<>();
	infoList.forEach(item -> {
	  String[] info = item.split("-");
	  Student student = new Student(info[0], info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3]));
	  studentList.add(student);
	});
	double weight = 0;
	for (Student student : studentList) {
	  weight = weight + student.getWeight();
	}
	double[] arr = new double[studentList.size()];
	int index = 0;
	for (Student student : studentList) {
	  arr[index] = student.getWeight() / weight;
	  index++;
	}

	for (int i = 0; i < arr.length; i++) {
	  if (i != 0) {
		arr[i] = arr[i] + arr[i - 1];
	  }
	}
	double random = Math.random();

	int i = -Arrays.binarySearch(arr, random) - 1; // 返回的是 -index - 1
	Student student = studentList.get(i);
	student.setWeight(student.getWeight() / 2);
	FileUtil.writeLines(studentList, "hutool\\info.txt", "utf-8");
  }
}
