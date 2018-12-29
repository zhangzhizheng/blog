package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.BlogImp;
import entity.Blog;



/**
 * Servlet implementation class EditBlog
 */
@WebServlet("/EditBlog")
public class EditBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String blogType = req.getParameter("blogType");
		int tag = Integer.valueOf(blogType);
		Blog blog = new Blog(title, tag, content);
		
		BlogImp bImp = new BlogImp();
		boolean isSuccess = bImp.modifiyBlog(blog);
		
		if (isSuccess) {
			resp.sendRedirect("admin.html");
		}else {
			resp.sendRedirect("EditBlog.html");
		}
		
    }
}
