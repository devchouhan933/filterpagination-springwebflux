package com.reactivespring.fileterpagination.models;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "userId", "userName", "timestamp", "txnType", "amount", "location", "ip" })
@lombok.Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Data {

	@JsonProperty("id")
	private int id;
	@JsonProperty("userId")
	private int userId;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("timestamp")
	private Long timestamp;
	@JsonProperty("txnType")
	private String txnType;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("location")
	private Location location;
	@JsonProperty("ip")
	private String ip;

	public int month() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(getTimestamp());
		return calendar.get(Calendar.MONTH) + 1;

	}

	public int year() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(getTimestamp());

		return calendar.get(Calendar.YEAR);

	}

	public double parseDoubleAmount() {
		return Double.parseDouble(getAmount().replaceAll("[^a-zA-Z0-9]", ""));
	}
}
