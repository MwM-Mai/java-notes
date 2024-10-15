package com.scw.test1;

import java.util.Arrays;

public class test2 {
  public static void main(String[] args) {
	int[][] arr = {
			{1, 2},
			{1, 2, 4},
			{3, 4, 5}
	};

	for (int[] ints : arr) {
	  System.out.println(Arrays.toString(ints));
	}

	int[][] arr2 = new int[3][2]; // 二维数组长度为3 一维数值长度为2 的动态数组

	int[][] arr3 = new int[3][]; // 二维数组长度为3 一维数值长度为动态 的动态数组
  }
}
