package com.reactivespring.fileterpagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reactivespring.fileterpagination.models.ConsumedTransactionApiResponse;
import com.reactivespring.fileterpagination.request.TransactionRequest;
import com.reactivespring.fileterpagination.service.Transection;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fetch-all")
public class Controller {
	@Autowired
	private Transection service;

	@GetMapping("/transection")
	public Mono<ConsumedTransactionApiResponse> response(@RequestBody TransactionRequest request) {

		return service.consume(request);
	}

}
