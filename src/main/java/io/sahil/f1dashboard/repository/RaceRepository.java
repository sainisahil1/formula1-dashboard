package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Race;

public interface RaceRepository extends CrudRepository<Race, String>{
	
	Race[] findByYearOrderByRound(String year);

}
