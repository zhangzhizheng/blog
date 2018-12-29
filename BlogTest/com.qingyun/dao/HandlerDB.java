package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class HandlerDB {
	public static void testHandlerBD(String name, String pwd) {
		Connection connection = null;
		Statement st = null;
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接数据库对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=UTF-8", "root", "mysql123");
			// 3.创建编译语句对象
			st = connection.createStatement();
			String sql = "update user_table set pwd='" + pwd + "' where username='" + name + "'";
			// 4.执行编译语句
			int row = st.executeUpdate(sql);
			System.out.println("row:" + row);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		testHandlerBD("admin","67890");
	}
}
