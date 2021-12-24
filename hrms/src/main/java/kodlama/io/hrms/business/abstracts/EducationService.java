package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;

public interface EducationService {
	
	DataResult<List<Education>> getAll();
	
	Result add(Education education);
	
	DataResult<Education> findAllByCandidateId(int candidateId);

}
