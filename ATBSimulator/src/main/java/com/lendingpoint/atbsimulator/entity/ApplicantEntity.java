package com.lendingpoint.atbsimulator.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// Entity Class Connecting to the Database


@Document("BureauCreditReport")
public class ApplicantEntity {
	@Id
	private String id;
	@Field("lookupValue")
	private String lookupValue;
	@Field("body")
	private String body;

}
