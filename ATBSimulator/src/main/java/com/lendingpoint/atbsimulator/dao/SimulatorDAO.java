package com.lendingpoint.atbsimulator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lendingpoint.atbsimulator.entity.LookupAndIdEntity;
import com.lendingpoint.atbsimulator.entity.ApplicantEntity;
import com.lendingpoint.atbsimulator.repository.SimulatorRepository;

@Repository
public class SimulatorDAO {

	@Autowired
	private SimulatorRepository repository;

	// Returns the Body Based on the lookup Value

	public ApplicantEntity getResponse(String lookupValue) {
		return repository.findBodyByLookupValue(lookupValue);
	}

	// Returns the Default Response If lookup Value is not Found

//	public ApplicantEntity getDefaultResponse() {
//		return repository.findDefaultResponse();
//	}

	// Return list of Lookup Values present in the Database

	public ArrayList<LookupAndIdEntity> getLookupValueList() {
		ArrayList<LookupAndIdEntity> lookupList = new ArrayList<LookupAndIdEntity>();

		List<ApplicantEntity> list = repository.findAll();
		list.forEach(lookup -> {
			LookupAndIdEntity entity = new LookupAndIdEntity();
			entity.setLookupValue(lookup.getLookupValue());
			entity.setId(lookup.getId());
			lookupList.add(entity);

		});

		return lookupList;

	}

	// Return Response By Id

	public ApplicantEntity getResponseById(String Id) {
		return repository.findResponseById(Id);
	}

	// Delete Response By Id

	@Transactional
	public void deleteResponse(String id) {
		repository.deleteById(id);
	}

	// Add New Response To Database

	@Transactional
	public ApplicantEntity saveResponse(ApplicantEntity entity) {
		return repository.insert(entity);

	}

}
