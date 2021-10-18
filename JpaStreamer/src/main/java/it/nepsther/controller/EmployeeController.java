package it.nepsther.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.nepsther.domain.Employee;
import it.nepsther.service.EmployeeService;

@RestController
@RequestMapping("API/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public List<Employee> save(@RequestBody List<Employee> employees){
		
		return employeeService.saveEmployee(employees);
		
	}
	
	@GetMapping
	public List<Employee> getEmployees(){		
		return employeeService.getEmployee();		
	}
	
	@GetMapping("/{offset}/{limit}")
	public List<Employee> getEmployeeSorted(@PathVariable int offset, @PathVariable int limit ){		
		return employeeService.getEmployeeSorted(offset,limit);		
	}
	
	@GetMapping("/{dept}")
	public List<Employee> getEmployeeByDept(@PathVariable String dept ){		
		return employeeService.getEmployeeByDept(dept);		
	}
	
	@GetMapping("/info1/{dept}/{salary}")
	public List<Employee> getEmployeeByDeptAndSalary(@PathVariable String dept, double salary ){		
		return employeeService.getEmployeeByDeptAndSalary(dept,salary);		
	}
	
	@GetMapping("/info12/{salary2}/{salary2}")
	public List<Employee> getEmployeeBySalary(@PathVariable double salary1, double salary2 ){		
		return employeeService.getEmployeeBySalary(salary1,salary2);		
	}

}
