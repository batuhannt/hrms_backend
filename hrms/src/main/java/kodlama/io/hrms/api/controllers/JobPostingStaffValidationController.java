package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPostingStaffValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPostingStaffValidation;

@RestController
@RequestMapping("/api/JobPostingStaffValidation")
@CrossOrigin
public class JobPostingStaffValidationController {
	
	private JobPostingStaffValidationService _jobPostingStaffValidationService;
	
	@Autowired
	public JobPostingStaffValidationController(JobPostingStaffValidationService jobPostingStaffValidationService) {
		this._jobPostingStaffValidationService = jobPostingStaffValidationService;
	}
	@GetMapping("/getAllStagingValidation")
	public DataResult<List<JobPostingStaffValidation>> getAllStagingValidation() {

		return this._jobPostingStaffValidationService.getAllUnVerifiedJobPosting();
	}
	
	@GetMapping("/verifyJobPosting")
	public Result verifyJobPosting(@RequestParam int id) {
		return this._jobPostingStaffValidationService.verifyJobPosting(id);
	}
}
