package com.reactivespring.fileterpagination.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.reactivespring.fileterpagination.models.ConsumedTransactionApiResponse;
import com.reactivespring.fileterpagination.models.Data;
import com.reactivespring.fileterpagination.models.TransactionApiResponse;
import com.reactivespring.fileterpagination.request.TransactionRequest;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TransectionServiceImpl implements Transection {
	@Autowired
	WebClient client;

	public Mono<TransactionApiResponse> getFromApi(int userId, int page) {
		return client.get()
				.uri(uriBuilder -> uriBuilder.path("/search").queryParam("userId", String.valueOf(userId))
						.queryParam("page", String.valueOf(page)).build())
				.retrieve().bodyToMono(TransactionApiResponse.class);
	}

	public String getDateFromTimeStamp(long timeStamp) {

		Format format = new SimpleDateFormat("MM-yyyy");

		return format.format(new Date(timeStamp));

	}

	@Override
	public Mono<ConsumedTransactionApiResponse> consume(TransactionRequest request) {

		Mono<TransactionApiResponse> monoApiRespnseForPage = this.getFromApi(request.getUid(), 1);
		Mono<Integer> total = monoApiRespnseForPage.map(TransactionApiResponse::getTotalPages);

		return total.flatMap(totalPage -> {
			List<Mono<TransactionApiResponse>> listOfMonoOfTransactionRes = new ArrayList<>();
			for (int i = 1; i <= totalPage; i++) {
				listOfMonoOfTransactionRes.add(this.getFromApi(request.getUid(), i));
			}
			return Flux.fromIterable(listOfMonoOfTransactionRes)
					.flatMap(monoListOfTransactionRes -> monoListOfTransactionRes).collectList()
					.flatMap(listOfTransactionApiRes -> {

						List<Data> list = listOfTransactionApiRes.stream().flatMap(s -> s.getData().stream())
								.filter(data -> (((!request.getMonthYear().isEmpty()) && (this
										.getDateFromTimeStamp(data.getTimestamp()).equals(request.getMonthYear())))
										|| request.getMonthYear().isEmpty()))
								.sorted().collect(Collectors.toUnmodifiableList());
						double avg = list.stream().filter(s -> s.getTxnType().equals("debit"))
								.mapToDouble(Data::parseDoubleAmount).average().orElse(0.0);
						List<Integer> ids = list.stream()
								.filter(data -> (!data.getTxnType().isEmpty()
										&& data.getTxnType().equalsIgnoreCase(request.getTxnType())
										&& data.parseDoubleAmount() > avg || request.getTxnType().isEmpty()))
								.filter(s -> s.parseDoubleAmount() > avg).map(Data::getId).sorted()
								.collect(Collectors.toUnmodifiableList());
						return Mono.just(ids);

					});

		}).map(ids -> new ConsumedTransactionApiResponse("Success", ids));

	}
}



