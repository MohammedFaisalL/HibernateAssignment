package com.te.StudentProject.queries;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.StudentProject.Student;

public class InsertData {

	public static void main(String[] args) {
		Student student = new Student();
		student.setRollno(10);
		student.setName("Rahul");
		student.setPhno(908765431);
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			student.setDob(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("22-04-1987").getTime()));
			factory = Persistence.createEntityManagerFactory("studentsData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(student);
			System.out.println("Data inserted successfully");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}

	}

}
