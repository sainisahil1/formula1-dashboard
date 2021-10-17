package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Season;

public interface SeasonRepository extends CrudRepository<Season, Integer>{

	Season[] findAllByOrderByYearDesc();
	
}
