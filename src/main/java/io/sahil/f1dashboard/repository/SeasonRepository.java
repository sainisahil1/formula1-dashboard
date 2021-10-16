package io.sahil.f1dashboard.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Season;

public interface SeasonRepository extends CrudRepository<Season, String>{

	ArrayList<Season> findAllByOrderByYearDesc();
	
}
