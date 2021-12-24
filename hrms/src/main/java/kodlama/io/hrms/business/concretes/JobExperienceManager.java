package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Data getirildi.");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<JobExperience> findAllByCandidateId(int candidateId) {
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findAllByCandidateId(candidateId),"Data getirildi.");
	}
	
	

}
