package com.ty.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateValidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("status") != null) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("createStudent.jsp");
					dispatcher.forward(req, resp);
		}
		else
		{
			PrintWriter writer=resp.getWriter();
			writer.print("<h1>pls login</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
		}
	}
}
