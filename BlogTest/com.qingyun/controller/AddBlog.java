package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.BlogImp;
import entity.Blog;
@WebServlet("/AddBlog")
public class AddBlog extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			// TODO Auto-generated method stub
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;chaset=utf-8");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String blogType = req.getParameter("blogType");
			int tag = Integer.valueOf(blogType);
			Blog blog = new Blog(title, tag, content);
			
			BlogImp bImp = new BlogImp();
			boolean isSuccess = bImp.addBlog(blog);
			
			if (isSuccess) {
				resp.sendRedirect("admin.html");
			}else {
				resp.sendRedirect("addBlog.html");
			}
	}

}
