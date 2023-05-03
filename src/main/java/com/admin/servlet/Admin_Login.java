package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.user;
@WebServlet("/adminLogin")
public class Admin_Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			HttpSession session=req.getSession();
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				
				session.setAttribute("adminObj",new user());
				resp.sendRedirect("admin/index.jsp");
			}else {
				session.setAttribute("errorMsg", "invalid email & password");
				resp.sendRedirect("AdminLogin.jsp");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
