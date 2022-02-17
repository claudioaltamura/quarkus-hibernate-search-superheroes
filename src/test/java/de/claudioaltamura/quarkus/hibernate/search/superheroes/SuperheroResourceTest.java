package de.claudioaltamura.quarkus.hibernate.search.superheroes;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class SuperheroResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/v1/superheroes")
          .then()
             .statusCode(200);
    }

}