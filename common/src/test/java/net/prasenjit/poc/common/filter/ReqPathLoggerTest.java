package net.prasenjit.poc.common.filter;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(TestResource.class)
class ReqPathLoggerTest {

    @Test
    void filter() {
        given().get()
                .then()
                .statusCode(200)
                .body(is("Hello"))
                .header("Custom-Header", is("Custom-Header-Value"));

    }
}
