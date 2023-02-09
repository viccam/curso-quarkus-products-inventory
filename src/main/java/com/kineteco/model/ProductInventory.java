package com.kineteco.model;


import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@RegisterForReflection // Anotacion para indicar que se desea registrar esa clase al momento de construir la aplicacion
//esto es mas usado para cuando se aplica la compilación nativa
public class ProductInventory {

    private String sku;
    private String category;
    private String name;
    private int quantity;
    private String powerWatts;
    private String footprint;
    private BigDecimal manufacturingCost;
    private BigDecimal price;
    private ProductLine productLine;
    private List<ConsumerType> targetConsumer;
    private ProductAvailability productAvailability;
    private int unitsAvailable;
}
