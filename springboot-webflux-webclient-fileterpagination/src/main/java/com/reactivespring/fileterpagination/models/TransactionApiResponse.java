package com.reactivespring.fileterpagination.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "page", "per_page", "total", "total_pages", "data" })
@lombok.Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TransactionApiResponse {

	@JsonProperty("page")
	private int page;
	@JsonProperty("per_page")
	private int perPage;
	@JsonProperty("total")
	private int total;
	@JsonProperty("total_pages")
	private int totalPages;
	@JsonProperty("data")
	private List<Data> data = null;

}