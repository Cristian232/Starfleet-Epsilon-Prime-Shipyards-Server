package org.starfleet.epsilonprimeshipyards.responses;

import lombok.Getter;

@Getter
public class OrderResponse {
    private final boolean success;
    private final String message;
    private final FakeOrder order;

    public OrderResponse(boolean success, String message, UserOrderRequest userOrderRequest) {
        this.success = success;
        this.message = message;
        this.order = userOrderRequest.getOrder();
    }
}
