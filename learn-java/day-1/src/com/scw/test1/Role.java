package com.scw.test1;

import java.util.Random;

public class Role {
  private String name;
  private int blood;

  public Role() {
  }

  public Role(String name, int blood) {
	this.name = name;
	this.blood = blood;
  }

  public String getName() {
	return name;
  }

  public int getBlood() {
	return blood;
  }

  public void setName(String name) {
	this.name = name;
  }

  public void setBlood(int blood) {
	this.blood = blood;
  }

  // 定义一个方法用于攻击别人
  // 思考: 谁攻击谁?
  // Role r1 = new Role();
  // Role r2 = new Role();
  // r1.攻击(r2)
  public void attack(Role role) {
	//计算造成的伤害
	Random r = new Random();
	int hurt = r.nextInt(20) + 1;
	int remainBlood = role.getBlood() - hurt;
	remainBlood = Math.max(remainBlood, 0);
	role.setBlood(remainBlood);

	System.out.println(this.getName() + "举起拳头,打了" + role.getName() + "一下, 造成了" + hurt +
			"伤害, " + role.getName() + "剩余" + role.getBlood() + "血量");
  }
}
