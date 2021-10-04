package io.sahil.f1dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.sahil.f1dashboard.Model.Result;
import io.sahil.f1dashboard.repository.ResultRepository;

@RestController
public class StandingController {
	
	private ResultRepository resultRepository;
	
	public StandingController(ResultRepository resultRepository) {
		super();
		this.resultRepository = resultRepository;
	}


	@GetMapping("/result/{resultId}")
	public Result getResult(@PathVariable String resultId) {
		return this.resultRepository.findByResultId(resultId);
	}
	

}
