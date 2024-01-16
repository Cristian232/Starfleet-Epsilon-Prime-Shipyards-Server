package org.starfleet.epsilonprimeshipyards.responses;

import lombok.Getter;

@Getter
public class ProductCatalogResponse {
    private final boolean success;
    private final String message;

    public ProductCatalogResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
