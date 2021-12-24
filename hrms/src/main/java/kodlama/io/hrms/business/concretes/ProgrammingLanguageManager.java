package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageDao programmingLanguageDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("Data eklendi.");
				
	}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		
		return new SuccessDataResult<List<ProgrammingLanguage>>(this.programmingLanguageDao.findAll(),"Data getirildi.");
	}

	@Override
	public DataResult<ProgrammingLanguage> findAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<ProgrammingLanguage>(this.programmingLanguageDao.findAllByCandidateId(candidateId),"Data getirildi.");
	}

}
