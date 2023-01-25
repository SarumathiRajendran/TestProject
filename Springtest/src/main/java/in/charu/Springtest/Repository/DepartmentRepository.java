package in.charu.Springtest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.charu.Springtest.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
