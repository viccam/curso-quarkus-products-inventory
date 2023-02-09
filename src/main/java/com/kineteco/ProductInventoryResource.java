package com.kineteco;

import com.kineteco.model.ProductInventory;
import com.kineteco.services.ProductInventoryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class ProductInventoryResource {

    @Inject
    ProductInventoryService productInventoryService;

    public ProductInventoryResource(ProductInventoryService productInventoryService){
        this.productInventoryService = productInventoryService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("123")
    public String helloByVictor() {
        return "Hello from RESTEasy Reactive path 123";
    }

    /**
     *
     * @return Response: objeto de tipo response permite cambiar el status code
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("123/json")
    public Response helloByVictorJson() {

        Response response =  productInventoryService.getBySku("123");
        return response;
    }
}