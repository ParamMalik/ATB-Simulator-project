package com.lendingpoint.atbsimulator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// Class used to get list (id and lookupValue) of canned responses 

// @Document("BureauCreditReport")
public class LookupAndIdEntity {

//	@Id
	private String id;
//	@Field("lookupValue")
	private String lookupValue;

}
