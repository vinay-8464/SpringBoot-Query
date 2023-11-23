package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllEntry() {
		return employeeRepository.executeQuery1();
	}

	@Override
	public Employee findByid(int id) {
		return employeeRepository.executeQuery2(id);
	}
	
	@Override
	public Employee getByName() {
		return employeeRepository.executeQuery3("vinay");
	}
	
	@Override
	public int insertData(String name, int age) {
		employeeRepository.executeQuery4(name,age);
		return 1;
	}

	@Override
	public void updateData(int id, String name, int age) {
		employeeRepository.executeQuery5(id,name,age);
	}

	public void deleteData(int id) {
		employeeRepository.executeQuery6(id);
	}

//	@Override
//	public Employee updateData(Employee entry1) {
//		return nu;
//	}

}
