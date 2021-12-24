package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Position;

public interface PositionService {
	
	public void add(Position position);
		
	public DataResult<List<Position>> getAll();
	
	public Result deleteById(int id);
}
