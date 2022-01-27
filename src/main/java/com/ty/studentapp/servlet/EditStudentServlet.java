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

public class EditStudentServlet extends HttpServlet{
     
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  HttpSession session=req.getSession();
    		 if(session.getAttribute("status") != null) {
    	  StudentDao dao = new StudentDao();
  		Student student = new Student();
  		PrintWriter printWriter = resp.getWriter();
  		String id=req.getParameter("id");
  		String ages = req.getParameter("Sage");
  		String name = req.getParameter("Sname");
  		String mail = req.getParameter("Smail");
  		String phone = req.getParameter("Sphone");
  		String genders = req.getParameter("Sgender");
  		String password = req.getParameter("Spassword");
  		student.setId(Integer.parseInt(id));
  		student.setAge(Integer.parseInt(ages));
  		student.setMail(mail);
  		student.setName(name);
  		student.setPassword(password);
  		student.setPhone(Long.parseLong(phone));
  		student.setGender(genders);
  		dao.updateStudent(student);
  		printWriter.print("<html><body><h1> user edited</h1></body></html>");
  		RequestDispatcher dispatcher=req.getRequestDispatcher("/getAll");
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
