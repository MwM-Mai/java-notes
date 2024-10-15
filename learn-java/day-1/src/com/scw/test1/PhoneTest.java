package com.scw.test1;

import com.scw.test1.Phone;

public class PhoneTest {
  public static void main(String[] args) {
	Phone phone = new Phone();

	phone.brand = "小米";
	phone.price = 1999.99;

	System.out.println(phone.brand);
	System.out.println(phone.price);

	phone.cell();
	phone.paygGame();
  }
}
