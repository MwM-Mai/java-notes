package com.scw.test1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {
  // connect 对象
  static Connection connect;
  static String user = "root";
  static String pwd = "rootroot";
  static String url = "jdbc:mysql://localhost:3306/demo?useSSL=true&trustCertificateKeyStoreUrl=C:UsersAdministratorDesktoplearn-java/truststore.jks&trustCertificateKeyStorePassword=123456\";";
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

  // 获取服务器连接
  public static void getConnect() {
	try {
	  // 数据库驱动加载
	  Class.forName(JDBC_DRIVER);
	  System.out.println("数据库驱动加载成功");
	} catch (ClassNotFoundException e) {
	  Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "An error occurred", e);
	}

	// 通过访问数据库的URL获取数据库连接对象
	try {
	  connect = DriverManager.getConnection(url, user, pwd);
	  System.out.println("数据库连接成功");
	} catch (SQLException e) {
	  Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "An error occurred", e);
	}
  }

  public static void main(String[] args) throws SQLException {
	getConnect();
	Statement statement = connect.createStatement();
	String sql = "SELECT * FROM users;";
	ResultSet resultSet = statement.executeQuery(sql);
	while (resultSet.next()) {
	  System.out.println("name="+resultSet.getString("name"));
	  System.out.println("password="+resultSet.getString("password"));
	}
  }
}
