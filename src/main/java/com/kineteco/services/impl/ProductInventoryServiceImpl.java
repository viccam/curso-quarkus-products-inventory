package com.kineteco.services.impl;

import com.kineteco.model.ProductInventory;
import com.kineteco.services.ProductInventoryService;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Override
    public Response getBySku(String sku) {
        ProductInventory response = ProductInventory.builder()
                .name("Carro")
                .sku(sku)
                .build();
        return Response.ok(response).build();
    }
}
