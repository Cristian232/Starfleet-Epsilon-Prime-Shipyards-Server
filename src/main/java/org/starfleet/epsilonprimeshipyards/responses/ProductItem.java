package org.starfleet.epsilonprimeshipyards.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItem {
    private String name;
    private Long price;

    public ProductItem(String name, Long price) {
        this.name = name;
        this.price = price;
    }
}
