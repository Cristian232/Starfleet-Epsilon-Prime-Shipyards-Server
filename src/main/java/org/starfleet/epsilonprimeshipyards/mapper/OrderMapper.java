package org.starfleet.epsilonprimeshipyards.mapper;

import org.springframework.stereotype.Component;
import org.starfleet.epsilonprimeshipyards.dto.OrderDTO;
import org.starfleet.epsilonprimeshipyards.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDTO orderToOrderDTO(Order order) {

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());

        return dto;
    }

    public Order orderDTOToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());

        return order;
    }

    public List<OrderDTO> ordersToOrderDTOs(List<Order> orders) {
        if (orders == null) {
            return null;
        }
        return orders.stream()
                .map(this::orderToOrderDTO)
                .collect(Collectors.toList());
    }
}