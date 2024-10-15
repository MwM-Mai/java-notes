package mwm.ui;

import javax.swing.*;

public class GameJframe extends JFrame {
  public GameJframe() {
	initJFrame();

	initJMenuBar();

	this.setVisible(true); // 设置是否显示 图形化界面
  }

  // 初始化菜单
  private void initJMenuBar() {
	// 创建整个菜单对象
	JMenuBar jMenuBar = new JMenuBar();

	JMenu functionMenu = new JMenu("功能");
	JMenu aboutMenu = new JMenu("关于我们");

	JMenuItem replayItem = new JMenuItem("重新游戏");
	JMenuItem reLoginItem = new JMenuItem("重新登录");
	JMenuItem closeItem = new JMenuItem("关闭游戏");

	JMenuItem accountItem = new JMenuItem("公众号");

	functionMenu.add(replayItem);
	functionMenu.add(reLoginItem);
	functionMenu.add(closeItem);

	aboutMenu.add(accountItem);

	jMenuBar.add(functionMenu);
	jMenuBar.add(aboutMenu);

	// 给整个页面设置菜单
	this.setJMenuBar(jMenuBar);
  }

  private void initJFrame() {
	// 设置界面宽高
	this.setSize(603, 680);
	// 设置界面标题
	this.setTitle("拼图单机版 v1.0");
	// 设置界面置顶
	this.setAlwaysOnTop(true);
	this.setLocationRelativeTo(null); // 居中
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
