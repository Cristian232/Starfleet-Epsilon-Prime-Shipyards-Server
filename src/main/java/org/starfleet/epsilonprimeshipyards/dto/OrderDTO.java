package org.starfleet.epsilonprimeshipyards.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private List<ProductDTO> products;

}
