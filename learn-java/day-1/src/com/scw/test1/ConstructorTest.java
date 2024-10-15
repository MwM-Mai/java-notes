package com.scw.test1;

public class ConstructorTest {
  public static void main(String[] args) {
	Constructor ctr = new Constructor("coderwhy", 18, '男');
	String ctrName = ctr.getName();
	System.out.println(ctrName);

	Constructor ctr2 = new Constructor();
  }
}
