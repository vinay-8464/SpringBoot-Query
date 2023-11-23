package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeServiceImpl;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/")
	public List<Employee> getAllData() {
		return employeeService.findAllEntry();
	}
	
	@GetMapping("/findByName")
	public Employee findByName() {
		return employeeService.getByName();
	}

	@GetMapping("/{id}")
	public Employee getData(@PathVariable("id") int id) {
		Employee entry= employeeService.findByid(id);
		return entry;
	}
	
	@PostMapping("/")
	public int pushData(@RequestBody Employee employee) {
		String name= employee.getName();
		int age= employee.getAge();
		employeeService.insertData(name,age);
		return 1;
		
	}
//	@PutMapping("/")
//	public Employee updateData(@PathVariable("id") int id, @RequestBody Employee entry) {
//		Employee entry1= new Employee();
//		String name= entry.getName();
//		int age= entry.getAge();
//		if(name!= null && name.length()> 0) {
//			entry1.setName(name);
//		}
//		if(age>= 1) {
//			entry1.setAge(age);
//		}
//		Employee updatedData= employeeService.updateData(entry1);
//		return updatedData;
//	}
	@PutMapping("/update/{id}")
	public void updateData(@PathVariable("id") int id, @RequestParam String name, @RequestParam int age) {
		employeeService.updateData(id,name,age);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecord(@PathVariable("id") int id) {
		employeeService.deleteData(id);
	}
}
