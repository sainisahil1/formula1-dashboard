package io.sahil.f1dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.sahil.f1dashboard.Model.Driver;

public interface DriverRepository extends CrudRepository<Driver, String>{
	
	Driver findByDriverId(String driverId);

}
