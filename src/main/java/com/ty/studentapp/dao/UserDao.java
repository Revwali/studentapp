package com.ty.studentapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.studentapp.dto.User;
import com.ty.studentapp.dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void insertUser(User user) {
		entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

	public boolean deleteUser(int id) {
		entityManager = getEntityManager();
		EntityTransaction  entityTransaction = entityManager.getTransaction();
		 User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public List<User> getUsers() {
		entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Query  query= entityManager.createQuery("SELECT s FROM User s ");
		entityTransaction.commit();
		return query.getResultList();
		
	}
   public User getOneUser(int id) {
	   entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		User student= entityManager.find(User.class, id);
		entityTransaction.commit();
		return student;
   }
   public void updateUser(User user) {
	   entityManager = getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
   } 
   
   public boolean validateUser(String mail,String password) {
	   entityManager=getEntityManager();
	   EntityTransaction entityTransaction=entityManager.getTransaction();
	   entityTransaction.begin();
	   Query query=entityManager.createQuery("select u from User u");
	   List<User> list=query.getResultList();
	   for(User user:list) {
		   if(user.getMail().equals(mail) && user.getPassword().equals(password))
			   return true;
	   }
	   return false;
   }
 
}
