package com.orangesoft.order_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

//@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection //to override the application properties connection details
	static PostgreSQLContainer postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"))
			.withUsername("testUser")
			.withPassword("testSecret")
			.withDatabaseName("testDatabase");

	@LocalServerPort
	private int port;

	static {
		postgres.start();
	}

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldCreateOrder() {
		String requestBody = """
				{
				  "name":"iphone 16",
				  "description": "sample desc",
				  "status": "not filled",
				  "totalPrice": 25
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/v1/order")
				.then()
				.statusCode(201)
				.body("name", Matchers.equalTo("iphone 16"))
				.body("description", Matchers.equalTo("sample desc"));
	}

}
