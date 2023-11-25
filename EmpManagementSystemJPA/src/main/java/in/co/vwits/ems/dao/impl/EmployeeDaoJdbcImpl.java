package in.co.vwits.ems.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;

public class EmployeeDaoJdbcImpl implements EmployeeDao {
	
	// create
	@Override
	public int create(Employee emp) {
		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO tbl_emp VALUES(?,?,?) "); // 4 ? map to columns in the table we want to insert
				)
		{
			// Before actually firing the QUERY you must set the values for all ?
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());

			int noOfRowUpdated = pstmt.executeUpdate(); // firing QUERY
			return noOfRowUpdated;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	// Delete
	@Override
	public void delete(int id) {
		
		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM tbl_emp WHERE id=? "); // ? map to columns in the table we want to insert
				)
		{

			// Before actually firing the QUERY you must set the values for all ?
			pstmt.setInt(1, id);

			int noOfRowUpdated = pstmt.executeUpdate(); // firing QUERY

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Find 
	@Override
	public Optional<Employee> findById(int id){
		
		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_emp WHERE id=? "); // ? map to columns in the table we want to insert
				)
		{

			// Before actually firing the QUERY you must set the values for all ?
			pstmt.setInt(1, id);


			ResultSet rs = pstmt.executeQuery(); // firing QUERY.... // result set query on specific condition
			Employee foundStudent = new Employee();
			if(rs.next()) { // next() method returns
				foundStudent.setId(rs.getInt(1));
				foundStudent.setName(rs.getString(2));
				foundStudent.setSalary(rs.getDouble(3));
			}
			return Optional.of(foundStudent);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	// Find All
	@Override
	public List<Employee> findAll(){
		List<Employee> employees = new ArrayList<>();
		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_emp"); // ? map to columns in the table we want to insert
			)
		{

			ResultSet rs = pstmt.executeQuery(); // firing QUERY.... // result set query on specific condition
			
			while(rs.next()) { // next() method returns
				Employee foundEmp = new Employee();
				foundEmp.setId(rs.getInt(1));
				foundEmp.setName(rs.getString(2));
				foundEmp.setSalary(rs.getDouble(3));
				employees.add(foundEmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	// update

	public void updateName(int id, String updateName) {
		
		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("UPDATE tbl_emp SET name=? WHERE id=? "); // ? map to columns in the table we want to insert
				)
		{

			// Before actually firing the QUERY you must set the values for all ?
			pstmt.setString(1, updateName); // 1st ? is for attempts
			pstmt.setInt(2, id); // 2nd ? is for rollno


			int noOfRowUpdated = pstmt.executeUpdate(); // firing QUERY
			System.out.println("No of Records Updated are "+ noOfRowUpdated);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateName(Employee updatedEmp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalary(Employee updatedEmp) {
		// TODO Auto-generated method stub
		
	}
}
