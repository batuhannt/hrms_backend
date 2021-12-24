package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;



@RequestMapping("/api/programmingLanguages")
@RestController
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}



	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingLanguage programmingLanguage) {
		
		return this.programmingLanguageService.add(programmingLanguage);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgrammingLanguage>> getAll(){
		
		return this.programmingLanguageService.getAll();
	}
	
	

}
