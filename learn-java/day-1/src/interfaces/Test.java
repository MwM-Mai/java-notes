package interfaces;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test implements Inter {
  public static void main(String[] args) {
	//Frog f = new Frog("青蛙", 1);
	//f.eat();
	//f.swim();
	//
	//Rabbit r = new Rabbit();
	//r.eat();
	//
	//Dog d =new Dog();
	//d.eat();
	//d.swim();
	System.out.println(Inter.a);

	Scanner sc = new Scanner(System.in);
	sc.nextInt();
  }

  @Override
  public void method() {

  }
}
