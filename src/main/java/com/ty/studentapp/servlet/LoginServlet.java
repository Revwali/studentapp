package com.ty.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.UserDao;
import com.ty.studentapp.dto.User;

public class LoginServlet extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   UserDao dao=new UserDao();
	   String mail=req.getParameter("mail");
	   String password=req.getParameter("password");
	   PrintWriter printWriter=resp.getWriter();
	  boolean status=dao.validateUser(mail, password);
		   if(status) {
			   HttpSession httpSession=req.getSession();
			   httpSession.setAttribute("status", "loggedin");
			   RequestDispatcher dispatcher=req.getRequestDispatcher("nav.html");
			   dispatcher.forward(req, resp);
		   }
		  
		   else
		   {
			   printWriter.print("<html><body><h1>INVALID CREDENTIALS</h1></body></html>");
			   RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			   dispatcher.include(req, resp);
		   }
}
}
