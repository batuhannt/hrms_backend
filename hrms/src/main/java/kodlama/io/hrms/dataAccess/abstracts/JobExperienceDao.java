package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	JobExperience findAllByCandidateId(int candidateId);

}
