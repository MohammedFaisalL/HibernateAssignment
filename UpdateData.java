package com.te.StudentProject.queries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateData {

	static Scanner scanner = new Scanner(System.in);

	public static void update() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		String y = null;
		String name = null;
		long phno = 0;
		Date date=null;

		try {
			factory = Persistence.createEntityManagerFactory("studentsData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			System.out.println("Enter the rollno to update : ");
			int rollno = scanner.nextInt();

			System.out.println("Do you want to update name : ");
			String choice = scanner.next();
			if (choice.equals("y")) {
				System.out.println("Enter name : ");
				name = scanner.next();
			}

			System.out.println("Do you want to update phno : ");
			String choice1 = scanner.next();
			if (choice1.equals("y")) {
				System.out.println("Enter phno : ");
				phno = scanner.nextLong();
			}

			System.out.println("Do you want to update dob : ");
			String choice2 = scanner.next();
			if (choice2.equals("y")) {
				System.out.println("Enter dob : ");
				String dob = scanner.next();
				date = new Date(new SimpleDateFormat("dd-MM-yyyy").parse("22-04-1987").getTime());
			}
			String updateData = "update Student set dob =:dob ,name=:name ,phno=:phno where rollno=:rollno";
			Query query = manager.createQuery(updateData);

			query.setParameter("rollno", rollno);
			query.setParameter("name", name);
			query.setParameter("phno", phno);
			query.setParameter("dob", date);

			int result = query.executeUpdate();

			System.out.println(result + " rows affected!!");
			transaction.commit();
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
