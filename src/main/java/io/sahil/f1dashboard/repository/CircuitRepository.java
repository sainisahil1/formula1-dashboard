package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Circuit;

public interface CircuitRepository extends CrudRepository<Circuit, String>{

	Circuit findByCircuitId(String circuitId);
	
}
