package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;

public interface EducationDao extends JpaRepository<Education, Integer>{
	
	Education findAllByCandidateId(int candidateId);

}
