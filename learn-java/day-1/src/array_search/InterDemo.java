package array_search;

import interfaces.Inter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

// 插入排序 类似扑克牌的排序方法 max <- min 小往大的前面插入
public class InterDemo {
  public static void main(String[] args) {

	/*
	  插入排序:
	  将0索引的元素到N所有的元素看作有序的, 把N+1索引的元素到最后一个当成无需的
	  遍历无序的数据,将遍历到的元素插入有序序列中适当的位置,如遇到相同的数据,插入在后面
	  N的范围: 0~最大索引
	 */

	int[] arr = {3, 44, 38, 5, 47, 15, 36, 27, 2, 46, 4, 19, 50, 48};

	// 1. 找到无序的那一组数据是从那个索引开始 2
	int startIndex = -1;
	for (int i = 0; i < arr.length; i++) {
	  if (arr[i] > arr[i + 1]) {
		startIndex = i + 1;
		break;
	  }
	}

	// 2. 遍历从 startIndex 开始到最后一个元素, 依次得倒无序中的那一组中的每一个元素
	for (int i = startIndex; i < arr.length; i++) {
	  int j = i;
	  while (j > 0 && arr[j] < arr[j - 1]) {
		// 交换位置
		int temp = arr[j];
		arr[j] = arr[j - 1];
		arr[j - 1] = temp;
		j--;
	  }
	}

	System.out.println(Arrays.toString(arr));
  }
}
