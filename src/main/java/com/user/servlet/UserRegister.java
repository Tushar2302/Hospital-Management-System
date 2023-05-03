package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import com.entity.user;
import com.dao.UserDao;
import com.db.DBConnect;
@WebServlet("/user_register")


public class UserRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	try {
		String fullname=req.getParameter("fullname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		user u=new user(fullname,email,password);
		
		HttpSession session=req.getSession();
		
		UserDao dao=new UserDao(DBConnect.getConn());
		
		boolean f=dao.register(u);
		
		if(f==true) {
			session.setAttribute("suchMsg", "Register Successfully");
			resp.sendRedirect("signup.jsp");
		}else {
			session.setAttribute("errorMsg", "Something wrong on server ");
			resp.sendRedirect("signup.jsp");
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	
}
