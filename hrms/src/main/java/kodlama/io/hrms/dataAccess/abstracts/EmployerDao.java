package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	List<Employer> getByEmailAndPassword(String email,String password);

}
