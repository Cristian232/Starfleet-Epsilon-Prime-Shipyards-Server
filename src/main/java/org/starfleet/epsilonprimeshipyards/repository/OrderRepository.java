package org.starfleet.epsilonprimeshipyards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.starfleet.epsilonprimeshipyards.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
