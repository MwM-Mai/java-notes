package com.scw.test1;

import java.util.Random;

public class Reverse {
  public static Boolean contains (int[] newArr, int prize) {
	for (int j : newArr) {
	  if (j == prize) {
		return false;
	  }
	}
	return true;
  }

  public static void main(String[] args) {
	int[] arr = {2, 588, 888, 1000, 10000};
	int[] newArr = new int[arr.length];
	Random r = new Random();
	for (int i = 0; i < arr.length; ) {
	  int randomIndex = r.nextInt(arr.length);
	  int prize = arr[randomIndex];
	  boolean flag = contains(newArr, prize);
	  if(flag) {
		newArr[i] = prize;
		i++;
	  }
	}

	for (int j : newArr) {
	  System.out.println(j);
	}
  }
}
