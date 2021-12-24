package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@DeleteMapping("/remove")
	public Result remove(@RequestParam int id) {
		
		return this.jobAdvertisementService.remove(id);
	}
	@PostMapping("/removeAll")
	public Result removeAll() {
		return this.jobAdvertisementService.removeAll();
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted(){
		
		return this.jobAdvertisementService.getAllSorted();
	}
	@GetMapping("/getByIdAndEmployer")
	public DataResult<JobAdvertisement> getByIdAndEmployer_Id(@RequestParam int id,@RequestParam int employer_id){
		
		return this.jobAdvertisementService.getByIdAndEmployer_Id(id, employer_id);
	}
	
	@GetMapping("/getByOpenPositionAmount")
	public DataResult<JobAdvertisement> getByOpenPositionAmount(@RequestParam int openPositionAmount){
		
		return this.jobAdvertisementService.getByOpenPositionAmount(openPositionAmount);
		
	}
	@GetMapping("/getByEmployer_IdIn")
	public DataResult<List<JobAdvertisement>> getByEmployer_EmployerIdIn(@RequestParam List<Integer> employers){
		
		return this.jobAdvertisementService.getByEmployer_IdIn(employers);
	}
	@GetMapping("/getByCity_CityNameStartsWith")
	public DataResult<List<JobAdvertisement>> getByCity_CityNameStartsWith(@RequestParam String cityName){
		return this.jobAdvertisementService.getByCity_CityNameStartsWith(cityName);
	}
	
	@GetMapping("/getAllPosition")
	public DataResult<List<JobAdvertisement>> getAllPosition(@RequestParam int id){
		
		return this.jobAdvertisementService.getAllPosition(id);
	}
	

}
