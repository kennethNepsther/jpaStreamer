package it.nepsther.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedment.jpastreamer.application.JPAStreamer;

import it.nepsther.domain.Employee;
import it.nepsther.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JPAStreamer jpaStreamer;

	public List<Employee> saveEmployee(List<Employee> employees) {

		return employeeRepository.saveAll(employees);

	}

	public List<Employee> getEmployee() {

		return jpaStreamer.stream(Employee.class)
				.collect(Collectors.toList());
	}


	public List<Employee> getEmployeeSorted(int offset, int limit) {

		return jpaStreamer.stream(Employee.class)
				//.sorted(Employee$.name)
				.skip(offset)
				.limit(limit)
				.collect(Collectors.toList());
	}
	
	public List<Employee> getEmployeeByDept(String department) {

		return jpaStreamer.stream(Employee.class)
				//.filter(Employee$.dept.equal(department))				
				.collect(Collectors.toList());
	}
	
	public List<Employee> getEmployeeByDeptAndSalary(String department, double salary) {

		return jpaStreamer.stream(Employee.class)
				//.filter(Employee$.dept.equal(department)
				//.and(Employee$.salary.greaterOrEqual(salary)))										
				.collect(Collectors.toList());
	}
	
	public List<Employee> getEmployeeBySalary(double salary1, double salary2) {

		return jpaStreamer.stream(Employee.class)
				//.filter(Employee$.salary.between(salary1,salary2))																
				.collect(Collectors.toList());
	}
}
