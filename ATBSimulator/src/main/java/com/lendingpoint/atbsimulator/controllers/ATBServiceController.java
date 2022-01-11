package com.lendingpoint.atbsimulator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.lendingpoint.atbsimulator.entity.ApplicantEntity;
import com.lendingpoint.atbsimulator.parser.ConvertStringToXMLDocument;
import com.lendingpoint.atbsimulator.parser.ParseXMLDocument;
import com.lendingpoint.atbsimulator.services.SimulatorServices;

@RestController
public class ATBServiceController {

	@Autowired
	private SimulatorServices simulatorServices;

	@PostMapping(path = "/atb/services", consumes = { "application/xml" }, produces = "application/xml")
	public ResponseEntity<String> getResponse(@RequestBody String requestBody) {
		
		
		// Converting String To XML Document
		
		ConvertStringToXMLDocument xmlDocument = new ConvertStringToXMLDocument();
		Document document = xmlDocument.convertStringToXMLDocument(requestBody);

		
		// Parsing XML Document and getting lookupValue
		
		ParseXMLDocument parseXMLDocument = new ParseXMLDocument();
		String lookupValue = parseXMLDocument.readXml(document);

		// Getting response corresponding to the lookupValue form database 
		
		ApplicantEntity response = simulatorServices.getResponse(lookupValue);

		if (response != null) {
			return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
		} else {
			ApplicantEntity defaultResponse = simulatorServices.getResponse("default");
			return new ResponseEntity<String>(defaultResponse.getBody(), HttpStatus.OK);
		}

	}

}
