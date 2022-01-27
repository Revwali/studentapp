package com.ty.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.StudentDao;
import com.ty.studentapp.dto.Student;

public class createStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		String status=(String)httpSession.getAttribute("status");
		if(status != null) {
		StudentDao dao = new StudentDao();
		Student student = new Student();
		PrintWriter printWriter = resp.getWriter();
		String ages = req.getParameter("Sage");
		String name = req.getParameter("Sname");
		String mail = req.getParameter("Smail");
		String phone = req.getParameter("Sphone");
		String genders = req.getParameter("Sgender");
		String password = req.getParameter("Spassword");
		student.setAge(Integer.parseInt(ages));
		student.setMail(mail);
		student.setName(name);
		student.setPassword(password);
		student.setPhone(Long.parseLong(phone));
		student.setGender(genders);
		dao.insertStudent(student);
		printWriter.print("<html><body><h1>added</h1></body></html>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("createStudent.jsp");
		dispatcher.include(req, resp);
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
