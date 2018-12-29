package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.imp.BlogImp;
import entity.Blog;



/**
 * Servlet implementation class GetBlogList
 */
@WebServlet("/GetBlogList")
public class GetBlogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBlogList() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		BlogImp bImp = new BlogImp();
		List<Blog> list = bImp.queryBlog(Integer.valueOf(id));
		String jsonStr = JSON.toJSONString(list);
		System.out.println("博客");
		System.out.println(jsonStr);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(jsonStr);
	}

}
