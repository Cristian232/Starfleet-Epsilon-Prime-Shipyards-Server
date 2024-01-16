package org.starfleet.epsilonprimeshipyards.responses;

import lombok.Getter;
import lombok.Setter;
import org.starfleet.epsilonprimeshipyards.dto.UserDTO;

import java.util.List;

@Getter
@Setter

public class UserOrderRequest {
    private UserDTO user;
    private FakeOrder order;

    public UserOrderRequest(UserDTO user, List<ProductItem> order) {
        this.user = user;
        this.order = new FakeOrder();
        for (ProductItem item: order){
            this.order.addItem(item);
        }
    }
}