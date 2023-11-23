package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
@Service
public interface EmployeeService {

	public Employee findByid(int id);
	public List<Employee> findAllEntry();
	public int insertData(String name, int age);
	public void updateData(int id, String name,int age);
	public Employee getByName();
	public void deleteData(int id);
	//public Employee updateData1(String name, int age);
	
	
}
