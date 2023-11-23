package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Employee;

//import jakarta.transaction.Transactional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value="select id,name,age from employee",nativeQuery = true)
	public List<Employee> executeQuery1();
	
	@Query(value="select id,name,age from employee where id=:id",nativeQuery = true)
	public Employee executeQuery2(int id);

	@Query(value="select id,name,age from employee where name=:name",nativeQuery = true)
	public Employee executeQuery3(String name);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO employee(name,age) VALUES(:name,:age)",nativeQuery = true)
	public int executeQuery4(String name, int age);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE employee SET name=:name,age=:age WHERE id=:id",nativeQuery = true)
	public void executeQuery5(int id, String name, int age);

	@Transactional
	@Modifying
	@Query(value="delete from employee where age=:id",nativeQuery = true)
	public void executeQuery6(int id);

	
}
