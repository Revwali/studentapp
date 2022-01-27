package com.ty.studentapp.controller;

import java.util.List;

import com.ty.studentapp.dao.StudentDao;
import com.ty.studentapp.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		StudentDao dao=new StudentDao();
		List<Student> list=dao.getStudents();
       if(list != null)
    	   System.out.println("print");
       else
    	   System.out.println("nooooo");
	}

}
