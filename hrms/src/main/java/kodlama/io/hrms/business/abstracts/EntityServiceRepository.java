package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

public interface EntityServiceRepository<T> {
	
	
	public DataResult<List<T>>  getAll();
	public Result add(T entity);

}
