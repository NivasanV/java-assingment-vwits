package in.co.vwits.ems.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.dao.impl.EmployeeDaoImpl;
import in.co.vwits.ems.exceptions.EmployeeNotFoundException;
import in.co.vwits.ems.model.Employee;

public class EmployeeServiceImpl {
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl();
	}
	
	// create
	public void create(Employee emp) {
		dao.create(emp);
	}
	
	// Delete
	public void delete(int id) {
		dao.delete(id);
	}
	
	// Find
	public Optional<Employee> findById(int id) throws EmployeeNotFoundException {
		return dao.findById(id);
	}
	
	// Find All
	public List<Employee> findAllEmployees(){
		return dao.findAll();
	}
	
	// update
	public void updateEmployeeName(int id, String updateName) {
		dao.updateName(id, updateName);
	}
	
	// sort name
	public List<Employee> sortEmployeesByNameInAsc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->e22.getName().compareTo(e11.getName()));
		return emps;
	}
	
	public List<Employee> sortEmployeesByNameInDesc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->e11.getName().compareTo(e22.getName()));
		return emps;
	}

	// sort salary
	public List<Employee> sortEmployeeBySalaryInByAsc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->(int)(e11.getSalary()-e22.getSalary()));
		return emps;
	}
	
	public List<Employee> sortEmployeesBySalaryInDesc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->(int)(e22.getSalary()-e11.getSalary()));
		return emps;
	}
	
}
