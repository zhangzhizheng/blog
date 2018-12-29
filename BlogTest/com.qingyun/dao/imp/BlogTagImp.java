package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BlogTagInterface;
import entity.Tag;
import utils.HandlerDBUtil;

public class BlogTagImp implements BlogTagInterface{

	@Override
	public List<Tag> getTagList() {
		// 获取数据库连接对象
		Connection connection = HandlerDBUtil.getInstance().getConnection();
		// sql语句
		String sql = "select * from tag_table";
		// 结果集
		ResultSet rSet = null;
		ArrayList<Tag> list = new ArrayList<Tag>();
		// 获取预处理对象
		PreparedStatement preparedStatement = HandlerDBUtil.getInstance().getStatement(connection, sql);
		try {
		   rSet = preparedStatement.executeQuery();
		   while (rSet.next()) {
			   int id = rSet.getInt("id");
			   String tagTitle = rSet.getString("tag_title");
			   int status = rSet.getInt("status");
			   Tag tag = new Tag(id, tagTitle, status);
			   list.add(tag);
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
