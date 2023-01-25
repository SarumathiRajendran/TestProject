package in.charu.Springtest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.charu.Springtest.Entity.Employee;
import in.charu.Springtest.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*private static List<Employee> list=new ArrayList<>();
	static
	{
		Employee e=new Employee();
		e.setName("sabar");
		e.setLocation("cbe");
		e.setEmail("sabar@gmail.com");
		e.setDepartment("IT");
		e.setAge(29);
		list.add(e);
		 
		e=new Employee();
		e.setName("amma");
		e.setLocation("cbe");
		e.setEmail("jothi@gmail.com");
		e.setDepartment("Nurse");
		e.setAge(65);
		list.add(e);
	}*/
	
	@Autowired
	private EmployeeRepository erepo;
	
	@Override
	public List<Employee> getEmployees() {
		return erepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		
		return erepo.save(emp);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		java.util.Optional<Employee> emp=erepo.findById(id);
		if(emp.isPresent())
			return emp.get();
		else
			throw new RuntimeException("Employee Not Found Exception");
	}

	@Override
	public void deleteEmployee(Long id) {
		erepo.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return erepo.save(emp);
	}
}
