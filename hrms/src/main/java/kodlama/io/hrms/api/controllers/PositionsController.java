package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.PositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
@CrossOrigin
public class PositionsController {
	
	
	private PositionService positionService;
	@Autowired
	public PositionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}

	@PostMapping("/add")
	private void add(@RequestBody Position position) {
		
		this.positionService.add(position);
	}
	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
		
		return this.positionService.getAll();
	}
	
	@PostMapping("/deleteById")
	public Result deleteById(@RequestBody int id) {
		
		return this.positionService.deleteById(id);
	}

}
