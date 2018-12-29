package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.imp.BlogUserImp;
import entity.User;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=uft-8");
		String un = req.getParameter("username");
		String pwd = req.getParameter("password");	
		String nick=req.getParameter("nickname");	
		String email=req.getParameter("email");
		User user = new User(un, pwd,nick,email);
		
		BlogUserImp blogUserImp = new BlogUserImp();
		boolean isSuccess = blogUserImp.register(user);
		
		if (isSuccess) {
			// 重定向			
			resp.sendRedirect("login.html");
		}else {
			resp.sendRedirect("register.html");
		}
	}
}
