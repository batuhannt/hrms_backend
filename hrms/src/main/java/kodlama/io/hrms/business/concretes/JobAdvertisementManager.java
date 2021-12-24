package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisement) {
		super();
		this.jobAdvertisementDao = jobAdvertisement;
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll()); 
	}
	

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Data eklendi.");
	}


	@Override
	public Result remove(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("Data silindi.");
	}


	@Override
	public Result removeAll() {
		this.jobAdvertisementDao.deleteAll();
		return new SuccessResult("Tüm veri silindi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC,"createDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}


	@Override
	public DataResult<JobAdvertisement> getByIdAndEmployer_Id(int id, int employer_id) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByIdAndEmployer_Id(id, employer_id));
	}


	@Override
	public DataResult<JobAdvertisement> getByOpenPositionAmount(int openPositionAmount) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByOpenPositionAmount(openPositionAmount));
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_IdIn(List<Integer> employers) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_IdIn(employers));

	}


	@Override
	public DataResult<List<JobAdvertisement>> getByCity_CityNameStartsWith(String cityName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCity_CityNameStartsWith(cityName));

	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllPosition(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllPosition(id));

	}


	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable= PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}
	
	
	
	

}