package com.ty.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session= req.getSession();
    	PrintWriter writer=resp.getWriter();
    	writer.print(session.getAttribute("status"));
    	session.invalidate();
    	writer.print("<h1>LOGGED OUT,PLEASE LOGIN</h1>");
    	RequestDispatcher dispatche=req.getRequestDispatcher("login.html");
    	dispatche.include(req, resp);
    }
}
