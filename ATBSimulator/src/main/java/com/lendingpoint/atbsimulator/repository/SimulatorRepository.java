package com.lendingpoint.atbsimulator.repository;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.lendingpoint.atbsimulator.entity.ApplicantEntity;

public interface SimulatorRepository extends MongoRepository<ApplicantEntity, String> {

	// Will Return the body on the basis of Name

	@Query(value = "{lookupValue: '?0'}", fields = "{body:1}")
	ApplicantEntity findBodyByLookupValue(String lookupValue);

	// Return Default if Lookup Value is not Found

//	@Query(value = "{lookupValue: 'default'}", fields = "{body:1}")
//	ApplicantEntity findDefaultResponse();

	// Find Response BY id

	@Query(value = "{id: '?0'}")
	ApplicantEntity findResponseById(String id);

	// Delete Response By Id

	@DeleteQuery
	ApplicantEntity deleteResponseById(String id);
}
