package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 使用单例的方式
 * */
public class HandlerDBUtil {
	// 静态私有不可更改的对象 hdbUtil
	private static final HandlerDBUtil hdbUtil = new HandlerDBUtil();
	// 线程同步，保证操作数据库的安全性	
	public synchronized static HandlerDBUtil getInstance() {
		return hdbUtil;
	}
	// 构造方法私有化
	private HandlerDBUtil() {}
	
	// 静态代码块
	static {
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// 获取数据库连接对象
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=UTF-8", "root", "mysql123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 获取预编译对象
	public PreparedStatement getStatement(Connection con, String sql) {
		try {
			return con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 关闭所有的连接对象
	public void closeDB(Connection con, PreparedStatement st, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (st != null) {
				st.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
