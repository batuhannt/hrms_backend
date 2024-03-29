package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeService extends EntityServiceRepository<Employee>{
	
	public DataResult<List<Employee>>  getAll();
	public Result add(Employee employee);

}
