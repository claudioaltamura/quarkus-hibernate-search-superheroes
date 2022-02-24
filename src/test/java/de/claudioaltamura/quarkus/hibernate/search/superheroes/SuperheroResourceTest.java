package de.claudioaltamura.quarkus.hibernate.search.superheroes;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import de.claudioaltamura.quarkus.hibernate.search.superheroes.quarkus.hibernate.search.superheroes.SuperheroResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(SuperheroResource.class)
class SuperheroResourceTest {

	@Test
	void testHelloEndpoint() {
		given()
				.when().get()
				.then()
				.statusCode(200);
	}

}