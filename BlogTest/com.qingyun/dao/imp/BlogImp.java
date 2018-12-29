package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.BlogInterface;
import entity.Blog;
import utils.HandlerDBUtil;

public class BlogImp implements BlogInterface {
	@Override
	public boolean addBlog(Blog blog) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "insert into blog_table (title, tag, content, lasttime, status, readnum, good, uid) values (?,?,?,now(),?,?,?,?)";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			preparedStatement.setString(1, blog.getTitle());
			preparedStatement.setInt(2, blog.getTag());
			preparedStatement.setString(3, blog.getContent());
			preparedStatement.setInt(4, 1);
			preparedStatement.setInt(5, 0);
			preparedStatement.setInt(6, 0);
			preparedStatement.setInt(7, 1);
			
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
		}
		
		return false;
	}
	
	@Override
	public boolean modifiyBlog(Blog blog) {
		// 获取数据库连接对象
				Connection connection = HandlerDBUtil.getInstance().getConnection();
				// sql语句
				String sql = "update blog_table set title = ?, tag = ?, content = ? where id = ?";
				// 获取预处理对象
				PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
				try {
					preparedStatement.setString(1, blog.getTitle());
					preparedStatement.setInt(2, blog.getTag());
					preparedStatement.setString(3, blog.getContent());
					preparedStatement.setInt(4, blog.getId());
					
					int row = preparedStatement.executeUpdate();
					if (row > 0) {
						return true;
					}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
				}
				
				return false;
	}
	
	@Override
	public boolean deleteBlog(int i) {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "update blog_table set status = 0 where id = ?";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
			preparedStatement.setInt(1, i);
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, null);
		}
		
		return false;
	}
	
	@Override
	public List<Blog> queryBlog(int tag) {
		ArrayList<Blog> list = new ArrayList<Blog>();
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "select * from blog_table where tag = ? and status != 0";
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		ResultSet rSet = null;
		try {
			preparedStatement.setInt(1, tag);
			rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				int id = rSet.getInt("id");
				String title = rSet.getString("title");
				int t = rSet.getInt("tag");
				String content = rSet.getString("content");
				Date date = rSet.getDate("lasttime");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-dd hh:mm:ss");
				String lasttime = simpleDateFormat.format(date);
				int status = rSet.getInt("status");
				int good = rSet.getInt("good");
				int readNum = rSet.getInt("readnum");
				int uid = rSet.getInt("uid");
				
				Blog blog = new Blog(id, title, t, content, lasttime, status, good, readNum, uid);
				list.add(blog);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HandlerDBUtil.getInstance().closeDB(connection, preparedStatement, rSet);
		}	
		
		return list;
	}
}
