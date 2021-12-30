package kodlama.io.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPostingStaffValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPostingStaffValidationDao;
import kodlama.io.hrms.entities.concretes.JobPostingStaffValidation;

@Service
public class JobPostingStaffValidationManager implements JobPostingStaffValidationService {
	
	private JobPostingStaffValidationDao _jobPostingStaffValidationDao;
	@Autowired
	public JobPostingStaffValidationManager(JobPostingStaffValidationDao jobPostingStaffValidationDao) {
		_jobPostingStaffValidationDao=jobPostingStaffValidationDao;
	}
	
	public Result verifyJobPosting(int id) {
		long millis=System.currentTimeMillis(); 
		Date currentDate = new Date(millis);
		this._jobPostingStaffValidationDao.verifyJobPosting(id, currentDate);
		return new SuccessResult("Başarıyla Doğrulandı");
	}
	
	public DataResult<List<JobPostingStaffValidation>> getAllUnVerifiedJobPosting() {
		return new SuccessDataResult<List<JobPostingStaffValidation>>(this._jobPostingStaffValidationDao.getByIsVerified("hayır"));
	}
}
