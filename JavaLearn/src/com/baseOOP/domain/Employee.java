package com.baseOOP.domain;

public class Employee {

	public static int id;
	private String name;
	private String position;
	private int salary;
	private String department;
	
	static {
		id = 1000;
	}
	
	{
		department = "IT";
		System.out.println("Non-static init");
	}
	
	public Employee() {
		this("A", "B", 1);
		System.out.println("Empty constructor called");
		this.id ++;

	}
	
	public Employee(String name, String position, int salary) {
		this(name, position, salary, "IT");
		System.out.println("Constructor with 3 arguments");
	}

	
	
	private Employee(String name, String position, int salary, String department) {
		this.id ++;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.department = department;
		System.out.println("Constructor with 4 arguments");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + " , name=" + name + ", position=" + position + ", salary=" + salary + ", department=" + department
				+ "]";
	}

		
	
}
