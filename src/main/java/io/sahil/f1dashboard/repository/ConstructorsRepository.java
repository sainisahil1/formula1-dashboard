package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Constructors;

public interface ConstructorsRepository extends CrudRepository<Constructors, String>{

	Constructors findByConstructorId(String constructorId);
	
}
