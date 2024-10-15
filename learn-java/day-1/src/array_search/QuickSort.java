package array_search;

import java.util.Arrays;

// 快速排序
public class QuickSort {
  public static void main(String[] args) {
	/*
	  快速排序:
	  第一轮: 以0索引的数字为基准数,确定基准数在数组中正确的位置.
	  比基准数小的全部在左边, 比基准数大的全部在右边
	  后面以此类推
	 */

	int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

	quicksort(arr, 0, arr.length - 1);

	System.out.println(Arrays.toString(arr));
  }

  /**
   * 参数一: 要排序的数组
   * 参数二: 要排序的起始索引
   * 参数三: 要排序的结束索引
   */
  public static void quicksort(int[] arr, int i, int j) {
	// 定义两个变量要查找的范围
	int start = i;
	int end = j;

	// 递归出口
	if(start > end) {
	  return;
	}

	// 记录基准数
	int bassNumber = arr[i];

	// 利用循环找到交换的数字
	while (start != end) {

	  // 利用end, 找到比基准数小的数字
	  while (arr[end] >= bassNumber && start < end) {
		end--;
	  }

	  // 利用start, 找到比基准数大的数字
	  while (arr[start] <= bassNumber && start < end) {
		start++;
	  }

	  int temp = arr[start];
	  arr[start] = arr[end];
	  arr[end] = temp;
	}

	// 当start == end 那么上面的循环就会结束
	// 表示已经找到了基准数在数组中应存入的位置
	// 基准数归位
	arr[i] = arr[start];
	arr[start] = bassNumber;

	// 确定6左边的范围, 重复刚刚所做的事情
	quicksort(arr, i, start - 1);
	// 确定6右边边的范围, 重复刚刚所做的事情
	quicksort(arr, start + 1, arr.length - 1);

  }
}
