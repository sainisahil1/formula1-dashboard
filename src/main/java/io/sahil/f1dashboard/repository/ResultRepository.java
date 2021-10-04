package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Result;

public interface ResultRepository extends CrudRepository<Result, String>{
	
	Result findByResultId(String resultId);
	
	Result[] findByRaceId(String raceId);

}
