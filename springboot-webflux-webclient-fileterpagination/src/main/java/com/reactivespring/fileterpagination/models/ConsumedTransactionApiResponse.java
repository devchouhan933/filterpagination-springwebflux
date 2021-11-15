package com.reactivespring.fileterpagination.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "ids" })
@lombok.Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter

public class ConsumedTransactionApiResponse {

	@JsonProperty("status")
	public String status;
	@JsonProperty("ids")
	public List<Integer> ids = null;

}