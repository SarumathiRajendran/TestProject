package in.charu.Springtest.Entity;

import in.charu.Springtest.request.EmployeeRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@JsonProperty("Full_Name")
	
	//@NotBlank(message="Name should not be null")
	
	private String name;
	
	//@JsonIgnore
	private long age=0L;
	
	private String location;
	
	@Email(message="Please enter a valid email")
	private String email;
	
	@JoinColumn(name="department_id")
	@OneToOne
	private Department department;
	
	/*@NotBlank(message="department should not be null")
	private String department;

	@CreationTimestamp()
	@Column(name="created_At",nullable = false,updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_At")
	private Date updatedAt;*/
	
	public Employee(EmployeeRequest empReq) {
		this.name=empReq.getName();
		this.age=empReq.getAge();
		this.location=empReq.getLocation();
		this.email=empReq.getEmail();
	}
}
