package mwm.ui;

import javax.swing.*;

public class LoginJframe extends JFrame {
	public LoginJframe() {
	  this.setSize(488, 430);
	  // 设置界面标题
	  this.setTitle("拼图单机版 v1.0");
	  //设置界面置顶
	  this.setAlwaysOnTop(true);
	  // 设置界面居中
	  this.setLocationRelativeTo(null);
	  // 设置关闭模式
	  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // WindowConstants.EXIT_ON_CLOSE 关闭进程 后台虚拟机也关闭

	  this.setVisible(true); // 设置是否显示 图形化界面
	}
}
