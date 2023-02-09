package com.kineteco.services.impl;

import com.kineteco.model.ProductInventory;
import com.kineteco.services.ProductInventoryService;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Override
    public ProductInventory getBySku(String sku) {
        ProductInventory response = ProductInventory.builder()
                .name("Carro")
                .sku(sku)
                .build();
        return response;
    }
}
