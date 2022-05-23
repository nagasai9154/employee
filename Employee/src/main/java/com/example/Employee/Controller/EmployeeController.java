package com.example.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Exception.EmployeeNotFoundException;
import com.example.Employee.Model.Employee;
import com.example.Employee.Repository.EmployeeRepository;


@RestController
@RequestMapping("/api/version1")
public class EmployeeController {
@Autowired
EmployeeRepository employeeRepository;

//Get all employees
@GetMapping("/employees")
public List<Employee> displayMessage(){
	return employeeRepository.findAll(); 
	
}
//Save the all Employees
@PostMapping("/employees")
public Employee addEmployee(@RequestBody Employee emp) {
	Employee getEmp = employeeRepository.save(emp);
	return getEmp;
}
//Get Employee by Id
@GetMapping("/employees/{Id}")
public ResponseEntity<Employee> getEmployee( @PathVariable long Id){
	Employee getEmp = employeeRepository.getById(Id);
	return ResponseEntity.ok().body(getEmp);

}
//update an employee by Id
@PutMapping("/employees/{Id}")
public ResponseEntity<Employee>updatedEmployeeById(@PathVariable(value="Id")long Id,
		@Validated@RequestBody Employee employee)throws EmployeeNotFoundException{
	Employee getEmp = employeeRepository.findById(Id)
			.orElseThrow(()->new EmployeeNotFoundException(Id));
      getEmp.setId(employee.getId());
      getEmp.setName(employee.getName());
      getEmp.setDepartment(employee.getDepartment());
      getEmp.setSalary(employee.getSalary());
      
      Employee updateEmp = employeeRepository.save(getEmp);
      return ResponseEntity.ok().body(updateEmp);
		
}
//Delete an employee
@DeleteMapping("/employees/{Id}")
public String deleteEmployeeById(@PathVariable long Id) {
	Employee getEmp = employeeRepository.getById(Id);
	employeeRepository.delete(getEmp);
	return "A record is deleted";
		
}

}
