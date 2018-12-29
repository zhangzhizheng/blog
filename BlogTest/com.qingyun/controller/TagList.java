package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.imp.BlogTagImp;
import entity.Tag;

/**
 * Servlet implementation class TagList
 */
@WebServlet("/TagList")
public class TagList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagList() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 防止中文乱码		
		req.setCharacterEncoding("utf-8");
		
		BlogTagImp blogTagImp = new BlogTagImp();
		List<Tag> list = blogTagImp.getTagList();
		String jsonStr = JSON.toJSONString(list);
//		System.out.println(jsonStr);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(jsonStr);
	}
}
