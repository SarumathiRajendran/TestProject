package in.charu.Springtest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.charu.Springtest.Entity.Department;
import in.charu.Springtest.Entity.Employee;
import in.charu.Springtest.Repository.DepartmentRepository;
import in.charu.Springtest.Repository.EmployeeRepository;
import in.charu.Springtest.Service.EmployeeService;
import in.charu.Springtest.request.EmployeeRequest;
import jakarta.validation.Valid;

//@RequestMapping("/api/v1")
@RestController //@Controller + @ResponseBody
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	@Autowired
	private DepartmentRepository drepo;
	@Autowired
	private EmployeeRepository erepo;
	@GetMapping("/employees")  //@RequestMapping(value="/employees", method = RequestMethod.GET)
	public List<Employee> getEmployees()
	{
		return eService.getEmployees() ;
	}
	/*
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable Long id )
	{
		return "The ID is: "+id;
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee theEmployee)
	{
		return "saving the employee details:" +theEmployee;
		
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee theEmployee)
	{
		System.out.println( "updated the employee: "+id);
		return theEmployee;
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam Long id)  //@RequestParam("id1") Long id
	{
		return "Deleted ID is: "+id;
		
	}*/
	@PostMapping("/employees")
	public Employee saveEmp(@Valid @RequestBody EmployeeRequest empReq)
	{
		Department dept=new Department();
		dept.setName(empReq.getDepartment());
		dept=drepo.save(dept);
		
		Employee emp=new Employee(empReq);
		emp.setDepartment(dept);
		
		emp=eService.saveEmployee(emp);
		return emp;
	}
	
	@GetMapping("/employees/{id}")
	public Employee getSingleEmployee(@PathVariable Long id)
	{
		return eService.getSingleEmployee(id);
	}
	
	@DeleteMapping("/employees")
	public void deleteEmp(@RequestParam Long id)
	{
		eService.deleteEmployee(id);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee emp)
	{
		emp.setId(id);
		return eService.saveEmployee(emp);
	}
	
	@GetMapping("/employees/filter/{name}")
	public List<Employee> getEmployeesByDepartment(@PathVariable String name)
	{
		return erepo.findByDepartmentName(name);
		
	}
}
