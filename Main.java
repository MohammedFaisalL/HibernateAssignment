package com.te.StudentProject;

import java.util.Scanner;

import com.te.StudentProject.queries.DeleteData;
import com.te.StudentProject.queries.DisplayData;
import com.te.StudentProject.queries.UpdateData;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println();
		System.out.println("1. To See all data.");
		System.out.println("2. To See any particular data.");
		System.out.println("3. To Update any particular data.");
		System.out.println("4. To Delete data.");
		System.out.println("5. Exit");
		System.out.println("Enter your choice : ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			DisplayData.displayAll();
			break;
		case 2:
			DisplayData.displayOne();
			break;
		case 3:
			UpdateData.update();
			break;
		case 4:
			DeleteData.delete();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("invalid choice !!");
		}
	}

}
