package com.example.Api_Gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatewayUnitTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGatewayRoute() {
        webTestClient.get().uri("http://localhost:8081/vehicle")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).consumeWith(response -> {
                    // add your assertions here
                    System.out.println("Response: " + response.getResponseBody());
                });
    }
}
