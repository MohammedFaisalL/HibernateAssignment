package com.te.StudentProject.queries;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.StudentProject.NotFoundException;

public class DeleteData {

	static Scanner scanner = new Scanner(System.in);

	public static void delete() {
		System.out.println("Enter rollno you want to delete : ");
		int rollno = scanner.nextInt();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("studentsData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String updateData = "delete from Student where rollno=:rollno";
			Query query = manager.createQuery(updateData);
			query.setParameter("rollno", rollno);

			int result = query.executeUpdate();
			if (result > 0) {
				System.out.println(result + " rows affected!!");
			} else {
				throw new NotFoundException();
			}
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
