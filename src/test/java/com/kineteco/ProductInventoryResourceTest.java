package com.kineteco;

import com.kineteco.model.ProductInventory;
import com.kineteco.services.ProductInventoryService;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.resteasy.reactive.common.jaxrs.ResponseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@QuarkusTest
public class ProductInventoryResourceTest {

    //Instancia de clase a consumir(testear)
    ProductInventoryResource productInventoryResource;

    @Inject
    ProductInventoryService productInventoryService;

    //Objeto de respuesta
    Response rs = new ResponseImpl();

    @BeforeEach
    void setUp() {
        //Creación de mock para las clases dependientes
        productInventoryService = Mockito.mock(ProductInventoryService.class);

        //Se inyectan los mock a la clase que se desea probar
        productInventoryResource = new ProductInventoryResource(productInventoryService);

        ProductInventory product = ProductInventory.builder()
                .name("victor")
                .sku("123")
                .build();

        rs = Response.ok(product).build();


    }

    @Test
    public void testHelloByVictorJson(){

        //Indica al mock que responder cuando se consume metodo getBySku
        Mockito.when(productInventoryService.getBySku("123")).thenReturn(rs);
        //Consume metodo de clase a testear
        Response rsHelloByVictorJson = productInventoryResource.helloByVictorJson();
        System.out.print(((ProductInventory) rsHelloByVictorJson.getEntity()).getName());
        Assertions.assertEquals("victor", ((ProductInventory) rsHelloByVictorJson.getEntity()).getName());
    }



/**
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
    }*/
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