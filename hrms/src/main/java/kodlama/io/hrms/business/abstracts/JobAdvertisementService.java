package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	
	public DataResult<List<JobAdvertisement>> getAll();
	
	public Result add(JobAdvertisement jobAdvertisement);
	
	public Result remove(int id);
	
	public Result removeAll();
	
	DataResult<List<JobAdvertisement>> getAllSorted();
	
	public DataResult<JobAdvertisement> getByIdAndEmployer_Id(int id,int employer_id);
	
	public DataResult<JobAdvertisement> getByOpenPositionAmount(int openPositionAmount);
	
	public DataResult<List<JobAdvertisement>> getByEmployer_IdIn(List<Integer> employers);
	
	public DataResult<List<JobAdvertisement>> getByCity_CityNameStartsWith(String cityName);
	
	public DataResult<List<JobAdvertisement>> getAllPosition(int id);
	
	public DataResult<List<JobAdvertisement>> getAll(int pageNo,int pageSize);
	
	

}
