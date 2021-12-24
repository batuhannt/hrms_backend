package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	public Result add(Employer employer);
	
	public DataResult<List<Employer>> getAll();
	
	public Result deleteById(int id);
	
	public DataResult<List<Employer>> Authentication(String email,String password);

}
