package com.scw.test1;

import java.math.BigDecimal;

public class DoubleAdd {
  public static void main(String[] args) {
	double num1 = 0.1;
	double num2 = 0.2;

	BigDecimal num3 = new BigDecimal(Double.toString(num1));
	BigDecimal num4 = new BigDecimal(Double.toString(num2));

	System.out.println("总数为: " + num3.add(num4).doubleValue());
  }
}
