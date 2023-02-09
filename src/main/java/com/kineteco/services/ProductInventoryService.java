package com.kineteco.services;

import com.kineteco.model.ProductInventory;


public interface ProductInventoryService {

    public ProductInventory getBySku(String sku);

}
