package com.scw.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test1 {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入的头数量: ");
	int heads = sc.nextInt();

	System.out.println("请输入的脚的数量: ");
	int foots = sc.nextInt();

	if(heads > foots / 2 || foots % 2 != 0) {
	  System.out.println("No Answer");
	  return;
	}

	int chicken, rabbit;
	int chickenFoots = 2 * heads;
	int remainder = foots - chickenFoots;
	rabbit = remainder / 2;
	chicken = heads - rabbit;
	System.out.println("鸡的数量是"+ chicken);
	System.out.println("兔的数量是"+ rabbit);
  }
}
