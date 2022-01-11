package com.lendingpoint.atbsimulator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lendingpoint.atbsimulator.entity.LookupAndIdEntity;
import com.lendingpoint.atbsimulator.entity.ApplicantEntity;
import com.lendingpoint.atbsimulator.services.SimulatorServices;

@RestController
public class AdminController {

	@Autowired
	private SimulatorServices simulatorServices;
	
	// Get a list of canned responses

	@GetMapping(path = "/canned-responses", produces = "application/json")
	public ResponseEntity<List<LookupAndIdEntity>> getExistLookupValues() {
		List<LookupAndIdEntity> lookupValueList = simulatorServices.getLookupValueList();

		return new ResponseEntity<List<LookupAndIdEntity>>(lookupValueList, HttpStatus.OK);

	}

	// Get Response By ID
	
	@GetMapping(path = "/canned-responses/{id}", produces = "application/json")
	public ResponseEntity<ApplicantEntity> getResponseById(@PathVariable("id") String id ) {
		ApplicantEntity responseById = simulatorServices.getResponseById(id);

		return new ResponseEntity<ApplicantEntity>(responseById, HttpStatus.OK);

	}
	
	// Creating a new Response

	@PostMapping(path = "/canned-responses", consumes = "application/json", produces = "application/text")
	public ResponseEntity<String> saveResponse(@RequestBody ApplicantEntity entity) {
		ApplicantEntity response = simulatorServices.getResponse(entity.getLookupValue());
		if (response == null) {
			simulatorServices.saveResponse(entity);
			return new ResponseEntity<String>("Created", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Lookup Value Already Exists", HttpStatus.OK);
		}

	}
	
	// Delete response by ID

	@DeleteMapping(path = "/canned-responses/{id}", produces = "application/json")
	public ResponseEntity<ApplicantEntity> deleteResponse(@PathVariable("id") String id) {
		
		ApplicantEntity responseById = simulatorServices.getResponseById(id);
		simulatorServices.deleteResponse(id);

		return new ResponseEntity<ApplicantEntity>(responseById, HttpStatus.OK);

	}

}
