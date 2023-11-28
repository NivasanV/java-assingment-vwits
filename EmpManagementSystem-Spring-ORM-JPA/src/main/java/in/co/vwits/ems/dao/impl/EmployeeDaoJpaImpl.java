package in.co.vwits.ems.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public int create(Employee emp) {
		em.persist(emp); // This fires insert QUERY
		return 1;
	}

	@Override
	public void delete(int id) {
		em.remove(em.find(Employee.class, id));  // This fires delete QUERY 
	}

	@Override
	public Optional<Employee> findById(int id) {
		Employee e = em.find(Employee.class, id); // This fires select QUERY
		return Optional.of(e);
	}

	@Override
	public List<Employee> findAll() {
		String jpql = "FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> studentList = query.getResultList();
		return studentList;
	}

	@Override
	public void updateName(Employee updatedEmp) {
		em.merge(updatedEmp);	// This fires delete QUERY 
	}

	@Override
	public void updateSalary(Employee updatedEmp) {
		em.merge(updatedEmp);
	}

}
