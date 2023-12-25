package org.starfleet.epsilonprimeshipyards.service;

import org.springframework.stereotype.Service;
import org.starfleet.epsilonprimeshipyards.dto.OrderDTO;
import org.starfleet.epsilonprimeshipyards.mapper.OrderMapper;
import org.starfleet.epsilonprimeshipyards.model.Order;
import org.starfleet.epsilonprimeshipyards.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDTO getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(orderMapper::orderToOrderDTO).orElse(null);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.ordersToOrderDTOs(orders);
    }

}
