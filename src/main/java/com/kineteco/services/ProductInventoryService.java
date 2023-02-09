package com.kineteco.services;

import javax.ws.rs.core.Response;

public interface ProductInventoryService {

    public Response getBySku(String sku);

}
