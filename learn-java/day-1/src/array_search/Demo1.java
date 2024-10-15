package array_search;

import java.lang.reflect.Array;

public class Demo1 {
  // 二分查找/折半查找 必须是排序的 不能乱序的
  public static void main(String[] args) {
	int[] arr = {1, 3, 4, 5, 10, 20, 33, 40, 50, 55, 60, 69, 86, 88, 90, 99, 100, 120, 130, 131, 150};
	int min = 0, mid, max = arr.length - 1, index = -1;
	int search = 88;

	while (true) {
	  if(min > max) break;
	  mid = (max + min) / 2;
	  if(arr[mid] > search) {
		max = mid - 1;
	  } else if(arr[mid] < search) {
		min = mid + 1;
	  } else {
		index = mid;
		break;
	  }
	}

	System.out.println(index);
  }
}
