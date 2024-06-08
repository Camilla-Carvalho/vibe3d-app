package org.br.com.vibe3d.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

//@QuarkusTest
class ClienteResourceTest {
    //@Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from App Vibe3D!"));
    }

}