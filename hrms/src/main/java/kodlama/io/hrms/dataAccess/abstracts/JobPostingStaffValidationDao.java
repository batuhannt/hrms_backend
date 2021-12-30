package kodlama.io.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobPostingStaffValidation;

public interface JobPostingStaffValidationDao extends JpaRepository<JobPostingStaffValidation, Integer>{
	
	List<JobPostingStaffValidation> getByIsVerified(String isVerified);
	
	@Transactional
	@Modifying
	@Query("Update JobPostingStaffValidation Set isVerified='evet',verifiedAt=:verifiedAt Where id=:id")
	void verifyJobPosting(int id, Date verifiedAt);
	
	
}
