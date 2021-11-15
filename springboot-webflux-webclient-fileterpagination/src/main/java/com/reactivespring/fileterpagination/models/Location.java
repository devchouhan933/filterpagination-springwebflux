package com.reactivespring.fileterpagination.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "address", "city", "zipCode" })
@lombok.Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Location {

	@JsonProperty("id")
	private int id;
	@JsonProperty("address")
	private String address;
	@JsonProperty("city")
	private String city;
	@JsonProperty("zipCode")
	private long zipCode;

}
