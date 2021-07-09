package com.te.StudentProject;

public class NotFoundException extends Exception{

	@Override
	public String getMessage() {
		return "Incorrect Roll Number!!";
	}
	
}
