package com.ty.studentapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.studentapp.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void insertStudent(Student student) {
		entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

	}

	public boolean deleteStudent(int id) {
		entityManager = getEntityManager();
		EntityTransaction  entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public List<Student> getStudents() {
		entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Query  query= entityManager.createQuery("SELECT s FROM Student s ");
		entityTransaction.commit();
		return query.getResultList();
		
	}
   public Student editStudent(int id) {
	   entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Student student= entityManager.find(Student.class, id);
		entityTransaction.commit();
		return student;
   }
   public void updateStudent(Student student) {
	   entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
   }
}
