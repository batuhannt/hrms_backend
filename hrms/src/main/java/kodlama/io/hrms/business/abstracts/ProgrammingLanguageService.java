package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	Result add(ProgrammingLanguage cv);
	
	DataResult<List<ProgrammingLanguage>> getAll();
	
	DataResult<ProgrammingLanguage> findAllByCandidateId(int candidateId);

}
