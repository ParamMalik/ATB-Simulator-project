package com.lendingpoint.atbsimulator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// Class To store the name and value from requestBody in order to find first_name

public class DataSourceInputsEntity {
	private String name;
	private String value;

}
