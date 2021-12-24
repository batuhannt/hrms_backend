package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CvDto> getByCandidateCv(@RequestParam int candidateId) {
		
		return this.candidateService.getByCandidateId(candidateId);
	}
	@GetMapping("/getByFirstName")
	public DataResult<List<Candidate>> getByFirstName(@RequestParam String firstName){
		return this.candidateService.findByFirstName(firstName);
	}
	

}
