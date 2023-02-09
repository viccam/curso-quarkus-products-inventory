package com.kineteco;

import com.kineteco.model.ProductInventory;
import com.kineteco.services.ProductInventoryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductInventoryResource {

    @Inject
    ProductInventoryService productInventoryService;

    public ProductInventoryResource(ProductInventoryService productInventoryService){
        this.productInventoryService = productInventoryService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Product Inventory Service is up!";
    }

    /**
     *
     * @return Response: objeto de tipo response permite cambiar el status code
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("KE180")
    public Response inventory() {
        ProductInventory productInventory = productInventoryService.getBySku("KE180");
        return Response.ok(productInventory).build();
    }




    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("123")
    public String helloByVictor() {
        return "Hello from RESTEasy Reactive path 123";
    }


}