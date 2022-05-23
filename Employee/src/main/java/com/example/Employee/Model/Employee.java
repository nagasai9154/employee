package com.example.Employee.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="aslam")
@JsonIgnoreProperties
public class Employee {
@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
private String empname;
private long salary;
private String Department;
Employee(){}
Employee(String empname, String Department){
	this.empname = empname;
	this.Department = Department;	
}
public long getId(){
	return this.Id;
	
}
public String getName() {
	return this.empname;
}
public String getDepartment() {
	return this.Department;
}
public long getSalary() {
	return this.salary;
}
public void setId(long Id) {
	this.Id = Id;
}

public void setName(String empname) {
	this.empname = empname;
}
public void setDepartment(String Department) {
	this.Department = empname;
}
public void setSalary(long salary) {
	this.salary = salary;

}
@Override
public boolean equals(Object o) {
	if(this==o)
		return true;
	if(!(o instanceof Employee))
		return false;
	Employee employee=(Employee) o;
	return Objects.equals(this.Id, employee.Id)&& Objects.equals(this.empname,employee.empname)
			&& Objects.equals(this.Department, employee.Department)&& Objects.equals(this.salary, employee.salary);
	
	}
@Override
public int hashCode() {
	return Objects.hash(this.Id,this.empname,this.Department,this.salary);
}
@Override
public String toString() {
	return "Employee{" +"id=" + this.Id + ", name='" + this.empname + '\'' + ", Department='" + this.Department +'\'' +", Salary='" + this.salary+ '}';
}


}
