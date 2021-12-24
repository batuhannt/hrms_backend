package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;

public interface CityService {
	
	public void add(City city);
	
	public DataResult<List<City>> getAll();
	
	public Result deleteById(int id);

}
