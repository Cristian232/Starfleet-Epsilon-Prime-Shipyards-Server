package org.starfleet.epsilonprimeshipyards.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplyChainDTO {
    private Long id;
    private String resourceType;
    private int availableQuantity;

}
