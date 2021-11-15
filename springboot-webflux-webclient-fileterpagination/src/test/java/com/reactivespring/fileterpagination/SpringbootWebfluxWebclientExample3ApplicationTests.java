package com.reactivespring.fileterpagination;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.reactivespring.fileterpagination.models.ConsumedTransactionApiResponse;
import com.reactivespring.fileterpagination.models.TransactionApiResponse;
import com.reactivespring.fileterpagination.request.TransactionRequest;
import com.reactivespring.fileterpagination.service.TransectionServiceImpl;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class SpringbootWebfluxWebclientExample3ApplicationTests {
	@Mock
	WebClient client;
	@InjectMocks
	TransectionServiceImpl impl = new TransectionServiceImpl(client);
	TransactionRequest request = new TransactionRequest(4, "debit", "022019");

	@Test
	void contextLoads() {
		Mono<ConsumedTransactionApiResponse> consume = impl.consume(request);

		StepVerifier.create(consume).assertNext(res -> {
			assertEquals(3, res.ids.size());
			assertEquals("success", res.status);
		});
	}

}
