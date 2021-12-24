package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	
	private CityService cityService;
	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		
		this.cityService.add(city);
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		
		return this.cityService.getAll();
	}
	@PostMapping("/deleteById")
	public Result deleteById(@RequestBody int id) {
		return this.cityService.deleteById(id);
	}
	
	

}
