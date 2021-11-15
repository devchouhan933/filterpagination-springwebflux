package com.reactivespring.fileterpagination.service;

import com.reactivespring.fileterpagination.models.ConsumedTransactionApiResponse;
import com.reactivespring.fileterpagination.request.TransactionRequest;

import reactor.core.publisher.Mono;

public interface Transection {
	public Mono<ConsumedTransactionApiResponse> consume(TransactionRequest request);
}
