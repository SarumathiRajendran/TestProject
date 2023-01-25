package in.charu.Springtest.Service;

import java.util.List;

import in.charu.Springtest.Entity.Employee;

public interface EmployeeService {
	
	List <Employee> getEmployees();

	public Employee saveEmployee(Employee emp);
	
	public Employee getSingleEmployee(Long id);
	
	public void deleteEmployee(Long id);
	
	public Employee updateEmployee(Employee emp);
}
