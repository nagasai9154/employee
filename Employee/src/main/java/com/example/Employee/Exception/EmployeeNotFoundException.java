package com.example.Employee.Exception;

public class EmployeeNotFoundException extends Exception{
	private long Id;
	public EmployeeNotFoundException(long Id) {
		super(String.format("Employee not found with Id: '%s'",Id));
	}
	

}
