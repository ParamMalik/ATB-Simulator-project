package com.lendingpoint.atbsimulator.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendingpoint.atbsimulator.dao.SimulatorDAO;
import com.lendingpoint.atbsimulator.entity.LookupAndIdEntity;
import com.lendingpoint.atbsimulator.entity.ApplicantEntity;

@Service
public class SimulatorServices {

	@Autowired
	private SimulatorDAO dao;

	// Return Response Based on lookupValue

	public ApplicantEntity getResponse(String lookupValue) {
		return dao.getResponse(lookupValue);
	}

	// Return response if lookup Value not found

//	public ApplicantEntity getDefalutResponse() {
//		return dao.getDefaultResponse();
//	}

	// Add New Response To Database

	public ApplicantEntity saveResponse(ApplicantEntity entity) {
		return dao.saveResponse(entity);

	}

	// Return list of Lookup Values

	public ArrayList<LookupAndIdEntity> getLookupValueList() {

		return dao.getLookupValueList();

	}

	// Return Response Searched By id

	public ApplicantEntity getResponseById(String Id) {
		return dao.getResponseById(Id);
	}

	// Delete Response By Id

	public void deleteResponse(String id) {
		dao.deleteResponse(id);
	}

}
