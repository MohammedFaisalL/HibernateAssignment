package com.te.StudentProject.queries;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.StudentProject.NotFoundException;
import com.te.StudentProject.Student;

public class DisplayData {

	static Scanner scanner = new Scanner(System.in);

	public static void displayAll() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("studentsData");
			manager = factory.createEntityManager();

			String readAll = "from Student";
			Query query = manager.createQuery(readAll);

			List list = query.getResultList();

			for (Object object : list) {
				System.out.println(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
	}

	public static void displayOne() {
		System.out.println("Enter rollno you want to search : ");
		int rollno = scanner.nextInt();
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("studentsData");
			manager = factory.createEntityManager();

			String readAll = "from Student where rollno=:rollno";
			Query query = manager.createQuery(readAll);
			query.setParameter("rollno", rollno);

			Student student = (Student) query.getSingleResult();
			if (student != null) {
				System.out.println("Student Rollno : " + student.getRollno());
				System.out.println("Student Name : " + student.getName());
				System.out.println("Student Phno : " + student.getPhno());
				System.out.println("Student Dob : " + student.getDob());
			} else {
				throw new NotFoundException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
	}
}
