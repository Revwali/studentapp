package com.ty.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.StudentDao;
import com.ty.studentapp.dto.Student;

public class GetOneStudentServlet extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session=req.getSession();
		 if(session.getAttribute("status") != null) {
	    	StudentDao dao=new StudentDao();
	    	String id=req.getParameter("id");
	    	Student student=dao.editStudent(Integer.parseInt(id));
	    	req.setAttribute("object", student);
	    	RequestDispatcher dispatcher=req.getRequestDispatcher("EditUser.jsp");
	    	dispatcher.forward(req, resp);
		 }
	    	 else 
	 		{
	 			PrintWriter printWriter = resp.getWriter();
	 			printWriter.print("<html><body><h1>added</h1></body></html>");
	 		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
	 		dispatcher.forward(req, resp);
	 		}
	    }
}
