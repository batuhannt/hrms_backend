package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{
	
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Data getirildi");
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<Education> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<Education>(this.educationDao.findAllByCandidateId(candidateId),"Data getirildi");
	}

}
