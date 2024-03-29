package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.JobExperience;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	
	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}


	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll()); 
	}
	

	@Override
	public Result add(ForeignLanguage jobAdvertisement) {
		
		this.foreignLanguageDao.save(jobAdvertisement);
		return new SuccessResult("Data eklendi.");
	}


	@Override
	public DataResult<ForeignLanguage> findAllByCandidateId(int candidateId) {
		return new SuccessDataResult<ForeignLanguage>(this.foreignLanguageDao.findAllByCandidateId(candidateId),"Data getirildi."); 
	}

}
