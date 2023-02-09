package com.kineteco;

import com.kineteco.model.ProductInventory;
import com.kineteco.services.ProductInventoryService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class original {

    //Instancia de clase a consumir(testear)
    ProductInventoryResource productInventoryResource;

    @Inject
    ProductInventoryService productInventoryService;

    @BeforeEach
    void setUp() {




    }


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testHelloByVictor() {
        given()
                .when().get("/hello/123")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive path 123"));
    }
/**
    @Test
    public void testHelloByVictorJson() {

        ProductInventory productInventoryRs = given()
                .when().get("/hello/123/json")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(ProductInventory.class);

        Assertions.assertEquals("Carro", productInventoryRs.getName());
    }

**/

}