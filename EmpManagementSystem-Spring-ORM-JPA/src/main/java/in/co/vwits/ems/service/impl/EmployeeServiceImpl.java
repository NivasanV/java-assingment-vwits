package in.co.vwits.ems.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.exceptions.EmployeeNotFoundException;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	// create
	@Override
	public void create(Employee emp) {
		dao.create(emp);
	}
	
	// Delete
	@Override
	public void delete(int id) {
		dao.delete(id);
	}
	
	// Find
	@Override
	public Optional<Employee> findById(int id) throws EmployeeNotFoundException {
		return dao.findById(id);
	}
	
	// Find All
	@Override
	public List<Employee> findAllEmployees(){
		return dao.findAll();
	}
	
	// update
	@Override
	public void updateEmployeeName(Employee updatedEmp) {
		dao.updateName(updatedEmp);
	}
	
	// sort name
	@Override
	public List<Employee> sortEmployeesByNameInAsc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->e11.getName().compareTo(e22.getName()));
		return emps;
	}
	
	@Override
	public List<Employee> sortEmployeesByNameInDesc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->e22.getName().compareTo(e11.getName()));
		return emps;
	}

	// sort salary
	@Override
	public List<Employee> sortEmployeeBySalaryInByAsc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->(int)(e11.getSalary()-e22.getSalary()));
		return emps;
	}
	
	@Override
	public List<Employee> sortEmployeesBySalaryInDesc(){
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->(int)(e22.getSalary()-e11.getSalary()));
		return emps;
	}


	@Override
	public void updateEmployeeSalary(Employee updatedEmp) {
		// TODO Auto-generated method stub
		
	}
	
}
