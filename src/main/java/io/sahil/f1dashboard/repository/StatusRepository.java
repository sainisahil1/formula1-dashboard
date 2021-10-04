package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Status;

public interface StatusRepository extends CrudRepository<Status, String>{

	Status findByStatusId(String statusId);
	
}
