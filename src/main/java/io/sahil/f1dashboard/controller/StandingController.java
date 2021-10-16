package io.sahil.f1dashboard.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.sahil.f1dashboard.Model.Circuit;
import io.sahil.f1dashboard.Model.Race;
import io.sahil.f1dashboard.Model.Result;
import io.sahil.f1dashboard.Model.Season;
import io.sahil.f1dashboard.Model.Status;
import io.sahil.f1dashboard.dto.ResultDto;
import io.sahil.f1dashboard.repository.CircuitRepository;
import io.sahil.f1dashboard.repository.ConstructorsRepository;
import io.sahil.f1dashboard.repository.DriverRepository;
import io.sahil.f1dashboard.repository.RaceRepository;
import io.sahil.f1dashboard.repository.ResultRepository;
import io.sahil.f1dashboard.repository.SeasonRepository;
import io.sahil.f1dashboard.repository.StatusRepository;

@RestController
@CrossOrigin
public class StandingController {
	
	private ResultRepository resultRepository;
	private CircuitRepository circuitRepository;
	private ConstructorsRepository constructorsRepository;
	private DriverRepository driverRepository;
	private StatusRepository statusRepository;
	private RaceRepository raceRepository;
	private SeasonRepository seasonRepository;
	
	public StandingController(
			ResultRepository resultRepository,
			CircuitRepository circuitRepository,
			ConstructorsRepository constructorsRepository,
			DriverRepository driverRepository,
			StatusRepository statusRepository,
			RaceRepository raceRepository,
			SeasonRepository seasonRepository
			) {
		super();
		this.resultRepository = resultRepository;
		this.circuitRepository = circuitRepository;
		this.constructorsRepository = constructorsRepository;
		this.driverRepository = driverRepository;
		this.statusRepository = statusRepository;
		this.raceRepository = raceRepository;
		this.seasonRepository = seasonRepository;
	}
	
	
	
	
	@GetMapping("/standings/results/{raceId}")
	public ResponseEntity<Object> getRaceResult(@PathVariable String raceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Result[] results = this.resultRepository.findByRaceIdOrderByPositionOrder(raceId);
		ArrayList<ResultDto> resultDtoArrayList = new ArrayList<ResultDto>();
		for(Result r: results) {
			resultDtoArrayList.add(new ResultDto(
					r.getResultId(),
					r.getRaceId(),
					r.getDriverId(),
					this.driverRepository.findByDriverId(r.getDriverId()).getCode(),
					r.getConstructorId(),
					this.constructorsRepository.findByConstructorId(r.getConstructorId()).getName(),
					r.getGrid(),
					r.getPositionText(),
					r.getPositionOrder(),
					r.getPoints(),
					r.getLaps(),
					r.getFastestLap(),
					r.getFastestLapTime(),
					r.getFastestLapSpeed(),
					this.statusRepository.findByStatusId(r.getStatusId()).getStatus(),
					r.getAbsoluteTime()
					));	
		}
		if(resultDtoArrayList.size() == 0) {
		map.put("message", "no entry exist");
		} else {
			map.put("message", "success");
		}
		map.put("results", resultDtoArrayList);
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/standings/races/{year}")
	public ResponseEntity<Object> getRacesByYear(@PathVariable String year) {
		Race[] races = this.raceRepository.findByYearOrderByRound(year);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("races", races);
		if(races.length == 0) {
			map.put("message", "no entry exist");
		} else {
			map.put("message", "success");
		}
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/standings/circuits/{circuitId}")
	public ResponseEntity<Object> getCircuitById(@PathVariable String circuitId){
		Map<String, Object> map = new HashMap<String, Object>();
		Circuit circuit = this.circuitRepository.findByCircuitId(circuitId);
		map.put("circuit", circuit);
		if(circuit == null) {
			map.put("message", "no entry exist");
		} else map.put("message", "success");
		return new ResponseEntity<Object>(map, HttpStatus.OK);	
	}
	
	
	@GetMapping("/standings/status/{statusId}")
	public ResponseEntity<Object> getStatusById(@PathVariable String statusId){
		Map<String, Object> map = new HashMap<String, Object>();
		Status status = this.statusRepository.findByStatusId(statusId);
		map.put("status", status);
		if(status == null) {
			map.put("message", "no entry exist");
		} else map.put("message", "success");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/standings/seasons")
	public ResponseEntity<Object> getSeasons(){
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Season> seasons =  this.seasonRepository.findAllByOrderByYearDesc();
		//Collections.reverse(seasons);
		map.put("seasons", seasons);
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	


	
	

}
