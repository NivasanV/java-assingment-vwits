package in.co.vwits.ems.dao.impl;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmployeeDaoJpaImpl implements EmployeeDao{
	
	private EntityManagerFactory factory;
	
	public EmployeeDaoJpaImpl() {
		factory = Persistence.createEntityManagerFactory("emsapp");
	}

	@Override
	public int create(Employee emp) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(emp); // This fires insert QUERY
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Employee.class, id));  // This fires delete QUERY 
		tx.commit();
		em.close();
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee e = em.find(Employee.class, id); // This fires select QUERY
		tx.commit();
		em.close();
		return Optional.of(e);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// call a method which returns all the records from the database
		String jpql = "FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> studentList = query.getResultList();
		tx.commit();
		em.close();
		return studentList;
	}

	@Override
	public void updateName(Employee updatedEmp) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(updatedEmp);	// This fires delete QUERY 
		tx.commit();
		em.close();
	}

	@Override
	public void updateSalary(Employee updatedEmp) {
		// TODO Auto-generated method stub
		
	}

}
