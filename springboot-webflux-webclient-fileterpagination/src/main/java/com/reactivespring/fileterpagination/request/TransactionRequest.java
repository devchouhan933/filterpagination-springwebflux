package com.reactivespring.fileterpagination.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "uid", "txnType", "month_year" })
@lombok.Data
@AllArgsConstructor
@ToString
public class TransactionRequest {

	@JsonProperty("uid")
	private int uid;
	@JsonProperty("txnType")
	private String txnType;
	@JsonProperty("month_year")
	private String monthYear;

}