package com.orangesoft.Inventory_service;

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

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

	@ServiceConnection //to override the application properties connection details
	static PostgreSQLContainer postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));
//			.withUsername("testUser")
//			.withPassword("testSecret")
//			.withDatabaseName("testDatabase");

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
		RestAssured.given()
				.contentType("application/json")
				.queryParam("sku", "iphone 16")
				.queryParam("quantity", 10)
				.when()
				.post("/api/v1/inventory")
				.then()
				.statusCode(201);
	}

}
