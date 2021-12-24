package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dtos.CvDto;


public interface CandidateService extends EntityServiceRepository<Candidate>{
	
	public DataResult<List<Candidate>>  getAll();
	public Result add(Candidate candidate);
	public DataResult<CvDto> getByCandidateId(int candidateId);
	public DataResult<Candidate> findById(int candidateId);
	public DataResult<List<Candidate>> findByFirstName(String firstName);
}
